package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.FieldNode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Builds the Javadoc attached to generated classes and fields: a one-line summary, followed by
 * zero or more {@code <p>} detail blocks (supported version range, view wrapper, wiki link),
 * always separated from the summary by exactly one blank line.
 */
public class JavadocGenerator {

    private static final String WIKI_PAGE_URL = "https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata";
    private static final Pattern ANCHOR_PATTERN = Pattern.compile("id=\"([^\"]+)\"");

    private final List<String> allVersions;

    // Cache fields so the wiki page is fetched at most once per generator run.
    private Set<String> validWikiAnchors;
    private boolean fetchAttempted = false;

    public JavadocGenerator(List<String> allVersions) {
        this.allVersions = allVersions;
    }

    public CodeBlock generateClassJavadoc(EntityMetaNode node) {
        String displayName = toDisplayName(node.getClassName());
        List<CodeBlock> details = new ArrayList<>();

        addVersionRangeDetail(details, node.getSupportedVersions());
        addWikiLinkDetail(details, node.getClassName(), displayName);

        return buildJavadoc(CodeBlock.of("EntityMeta properties for the {@code $L} meta\n", displayName), details);
    }

    public CodeBlock generateFieldJavadoc(FieldNode field, ClassName viewClass) {
        List<CodeBlock> details = new ArrayList<>();

        if (viewClass != null) {
            details.add(CodeBlock.of("<p>Wrapped by view: {@link $T}</p>\n", viewClass));
        }
        addVersionRangeDetail(details, field.getVersions().keySet());

        return buildJavadoc(CodeBlock.of("Property representing the metadata field {@code $L}\n", field.getFieldName()), details);
    }

    private CodeBlock buildJavadoc(CodeBlock summary, List<CodeBlock> details) {
        CodeBlock.Builder builder = CodeBlock.builder().add(summary);

        if (!details.isEmpty()) {
            builder.add("\n");
            details.forEach(builder::add);
        }

        return builder.build();
    }

    private void addVersionRangeDetail(List<CodeBlock> details, Set<String> supportedVersions) {
        String range = formatVersionRange(supportedVersions);
        if (!range.isEmpty()) {
            details.add(CodeBlock.of("<p>Supported Versions: {@code $L}</p>\n", range));
        }
    }

    private void addWikiLinkDetail(List<CodeBlock> details, String className, String displayName) {
        String wikiAnchor = toWikiAnchor(className);

        if (!getValidWikiAnchors().contains(wikiAnchor)) {
            System.out.println("Skipping wiki link for '" + className + "' (anchor #" + wikiAnchor + " not found on the wiki page)");
            return;
        }

        details.add(CodeBlock.of("<p><a href=\"" + WIKI_PAGE_URL + "#$L\">$L on the minecraft.wiki</a></p>\n", wikiAnchor, displayName));
    }

    private String toWikiAnchor(String className) {
        String rawType = className.replace("MetaProperties", "");
        return rawType.replaceAll("(?<!^)(?=[A-Z])", "_"); // Pascal_Snake_Case
    }

    private String toDisplayName(String className) {
        return toWikiAnchor(className).replace("_", " "); // Pascal Case
    }

    private String formatVersionRange(Set<String> supportedVersions) {
        if (supportedVersions == null || supportedVersions.isEmpty()) return "";

        List<Integer> sortedIndices = supportedVersions.stream()
                .map(this.allVersions::indexOf)
                .filter(idx -> idx >= 0)
                .sorted()
                .distinct()
                .toList();

        if (sortedIndices.isEmpty()) return "";

        List<String> ranges = new ArrayList<>();
        int rangeStart = sortedIndices.getFirst();
        int previous = rangeStart;

        for (int i = 1; i <= sortedIndices.size(); i++) {
            boolean isLastIteration = i == sortedIndices.size();
            int current = isLastIteration ? -1 : sortedIndices.get(i);
            boolean runBroke = isLastIteration || current != previous + 1;

            if (runBroke) {
                ranges.add(formatSingleRange(rangeStart, previous));
                rangeStart = current;
            }

            previous = current;
        }

        return String.join(", ", ranges);
    }

    private String formatSingleRange(int startIdx, int endIdx) {
        int maxIdx = this.allVersions.size() - 1;
        boolean isEarliestVersion = startIdx == 0;
        boolean isLatestVersion = endIdx == maxIdx;

        if (isEarliestVersion && isLatestVersion) return "All Supported Versions";
        if (isEarliestVersion) return this.allVersions.get(endIdx) + "-";
        if (isLatestVersion) return this.allVersions.get(startIdx) + "+";
        if (startIdx == endIdx) return this.allVersions.get(startIdx);

        return this.allVersions.get(startIdx) + " - " + this.allVersions.get(endIdx);
    }

    // Used to check if the entity has a link on the minecraft wiki
    // (not 100% accurate, but it'll never link to a non-existing anchor)
    private synchronized Set<String> getValidWikiAnchors() {
        if (!this.fetchAttempted) {
            this.fetchAttempted = true;
            this.validWikiAnchors = fetchWikiAnchors();
        }
        return this.validWikiAnchors != null ? this.validWikiAnchors : Collections.emptySet();
    }

    private Set<String> fetchWikiAnchors() {
        try (HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(10))
                .build()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(WIKI_PAGE_URL))
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) CodeGenerator/1.0") // bypass cloudflare, whoops
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.err.println("Failed to fetch anchors, HTTP status code: " + response.statusCode());
                return null;
            }

            Set<String> anchors = extractAnchors(response.body());
            System.out.println("Parsed " + anchors.size() + " valid anchors from the Minecraft Wiki.");
            return anchors;

        } catch (Exception e) {
            System.err.println("Network error: " + e.getMessage());
            return null;
        }
    }

    private Set<String> extractAnchors(String html) {
        Set<String> anchors = new HashSet<>();
        Matcher matcher = ANCHOR_PATTERN.matcher(html);
        while (matcher.find()) {
            anchors.add(matcher.group(1));
        }
        return anchors;
    }

}
