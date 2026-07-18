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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavadocGenerator {

    private final List<String> allVersions;

    // Cache variables to fetch the wiki page only once
    private Set<String> validWikiAnchors = null;
    private boolean fetchAttempted = false;

    public JavadocGenerator(List<String> allVersions) {
        this.allVersions = allVersions;
    }

    public CodeBlock generateClassJavadoc(EntityMetaNode node) {
        CodeBlock.Builder builder = CodeBlock.builder();

        String rawType = node.getClassName().replace("MetaProperties", "");
        String wikiAnchor = rawType.replaceAll("(?<!^)(?=[A-Z])", "_"); // Pascal_Snake_Case
        String displayName = wikiAnchor.replace("_", " "); // Pascal Case

        builder.add("Metadata properties for the {@code $L} meta\n", displayName);

        String versionsRange = getVersionRangeString(node.getSupportedVersions());
        if (!versionsRange.isEmpty()) {
            builder.add("<p>Supported Versions: {@code $L}</p>\n", versionsRange);
        }

        Set<String> workingAnchors = getValidWikiAnchors();
        if (workingAnchors.contains(wikiAnchor)) {
            builder.add("<p><a href=\"https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#$L\">$L on the minecraft.wiki</a></p>\n",
                    wikiAnchor, displayName);
        } else {
            System.out.println("Skipping wiki link for '" + node.getClassName() + "' (Anchor #" + wikiAnchor + " not found on the wiki page)");
        }

        return builder.build();
    }

    public CodeBlock generateFieldJavadoc(FieldNode field, ClassName viewClass) {
        CodeBlock.Builder builder = CodeBlock.builder();

        builder.add("Property representing the metadata field {@code $L}\n\n", field.getFieldName());

        if (viewClass != null) {
            builder.add("<p>Wrapped by view: {@link $T}</p>\n", viewClass);
        }

        String versionsRange = getVersionRangeString(field.getVersions().keySet());
        if (!versionsRange.isEmpty()) {
            builder.add("<p>Supported Versions: {@code $L}</p>\n", versionsRange);
        }

        return builder.build();
    }

    private String getVersionRangeString(Set<String> supportedVersions) {
        if (supportedVersions == null || supportedVersions.isEmpty()) return "";

        List<Integer> indices = supportedVersions.stream()
                .map(this.allVersions::indexOf)
                .filter(idx -> idx != -1)
                .sorted()
                .distinct()
                .toList();

        if (indices.isEmpty()) return "";
        int maxIdx = this.allVersions.size() - 1;

        return IntStream.range(0, indices.size())
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> indices.get(i) - i,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .values()
                .stream()
                .map(positions -> {
                    int s = indices.get(positions.getFirst());
                    int e = indices.get(positions.get(indices.size() - 1));

                    if (s == 0 && e == maxIdx) return "All Supported Versions";
                    if (s == 0) return this.allVersions.get(e) + "-";
                    if (e == maxIdx) return this.allVersions.get(s) + "+";
                    if (s == e) return this.allVersions.get(s);

                    return this.allVersions.get(s) + " - " + this.allVersions.get(e);
                })
                .collect(Collectors.joining(", "));
    }

    // Used to check if the entity has a link on the minecraft wiki
    // (not 100% accurate, but it'll never display a non-existing entity)
    private synchronized Set<String> getValidWikiAnchors() {
        if (this.validWikiAnchors != null || this.fetchAttempted) {
            return this.validWikiAnchors != null ? this.validWikiAnchors : Collections.emptySet();
        }

        this.fetchAttempted = true;
        Set<String> anchors = new HashSet<>();

        try (HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(10))
                .build()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata"))
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) CodeGenerator/1.0") // bypass cloudflare, whoops
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Matcher matcher = Pattern.compile("id=\"([^\"]+)\"").matcher(response.body());
                while (matcher.find()) {
                    anchors.add(matcher.group(1));
                }

                this.validWikiAnchors = anchors;
                System.out.println("Parsed " + anchors.size() + " valid anchors from the Minecraft Wiki.");
            } else {
                System.err.println("Failed to fetch anchors, HTTP status code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.err.println("Network error: " + e.getMessage());
        }

        return this.validWikiAnchors != null ? this.validWikiAnchors : Collections.emptySet();
    }

}
