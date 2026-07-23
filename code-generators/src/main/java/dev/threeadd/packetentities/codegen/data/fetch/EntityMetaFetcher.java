package dev.threeadd.packetentities.codegen.data.fetch;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.FieldNode;
import dev.threeadd.packetentities.codegen.data.mapping.EntityClassAliasMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Reads the raw {@code /entity-data/*.json} resources produced for each supported Minecraft
 * version and aggregates them into a single {@link EntityMetaNode} per canonical class name,
 * merging renamed classes via {@link EntityClassAliasMapper}.
 */
public class EntityMetaFetcher {

    private static final String VERSION_PATTERN = "^\\d+(\\.\\d+)*$";

    private final String versionsPath;
    private final String dataPathFormat;
    private final Set<String> excludedVersions;

    public EntityMetaFetcher(String versionsPath, String dataPathFormat, Set<String> excludedVersions) {
        this.versionsPath = versionsPath;
        this.dataPathFormat = dataPathFormat;
        this.excludedVersions = excludedVersions;
    }

    /**
     * Reads and filters the list of supported Minecraft versions declared at {@link #versionsPath}.
     */
    public List<String> fetchVersions() throws IOException {
        JsonElement parsed = readJson(this.versionsPath);
        List<String> versions = new ArrayList<>();

        if (parsed == null || !parsed.isJsonArray()) {
            return versions;
        }

        for (JsonElement element : parsed.getAsJsonArray()) {
            String version = element.getAsString();
            if (isSupportedVersion(version)) {
                versions.add(version);
            }
        }

        return versions;
    }

    private boolean isSupportedVersion(String version) {
        return version.matches(VERSION_PATTERN) && !this.excludedVersions.contains(version);
    }

    /**
     * Reads the raw, unmerged meta layout for a single Minecraft version.
     */
    public Map<String, EntityMetaSnapshot> fetchVersionSnapshot(String version) throws IOException {
        String path = String.format(this.dataPathFormat, version);
        JsonElement parsed = readJson(path);

        Map<String, EntityMetaSnapshot> versionEntities = new HashMap<>();
        if (parsed == null || !parsed.isJsonObject()) {
            return versionEntities;
        }

        for (Map.Entry<String, JsonElement> metaEntry : parsed.getAsJsonObject().entrySet()) {
            if (!metaEntry.getValue().isJsonObject()) continue;
            versionEntities.put(metaEntry.getKey(), parseSnapshot(metaEntry.getValue().getAsJsonObject()));
        }

        return versionEntities;
    }

    private EntityMetaSnapshot parseSnapshot(JsonObject metaObj) {
        return new EntityMetaSnapshot(parseSuperClass(metaObj), parseFields(metaObj));
    }

    private String parseSuperClass(JsonObject metaObj) {
        if (!metaObj.has("superClass") || metaObj.get("superClass").isJsonNull()) {
            return null;
        }
        return cleanClassName(metaObj.get("superClass").getAsString());
    }

    private Map<String, FieldSnapshot> parseFields(JsonObject metaObj) {
        Map<String, FieldSnapshot> fields = new HashMap<>();
        if (!metaObj.has("fields") || !metaObj.get("fields").isJsonArray()) {
            return fields;
        }

        JsonArray fieldsArray = metaObj.getAsJsonArray("fields");
        for (JsonElement fieldElement : fieldsArray) {
            if (!fieldElement.isJsonObject()) continue;
            JsonObject fieldObj = fieldElement.getAsJsonObject();

            int index = fieldObj.get("index").getAsInt();
            String dataType = fieldObj.get("dataType").getAsString();
            String fieldName = fieldObj.get("fieldName").getAsString();

            fields.put(fieldName, new FieldSnapshot(index, dataType));
        }

        return fields;
    }

    /**
     * Reads every requested version's snapshot and merges them into one {@link EntityMetaNode}
     * per canonical class name. Renamed classes (and renamed superclass references) are resolved
     * through {@link EntityClassAliasMapper} first, so e.g. {@code EntityLivingBase} and
     * {@code LivingEntity} end up as a single aggregated node.
     */
    public Map<String, EntityMetaNode> fetchAndAggregateMetas(List<String> versions) throws IOException {
        Map<String, EntityMetaNode> entities = new TreeMap<>();

        for (String version : versions) {
            if (this.excludedVersions.contains(version)) continue;

            System.out.println("Loading snapshot layouts for Minecraft version: " + version);
            Map<String, EntityMetaSnapshot> snapshot = fetchVersionSnapshot(version);

            for (Map.Entry<String, EntityMetaSnapshot> entry : snapshot.entrySet()) {
                mergeIntoAggregate(entities, version, entry.getKey(), entry.getValue());
            }
        }

        return entities;
    }

    private void mergeIntoAggregate(Map<String, EntityMetaNode> entities, String version, String rawType, EntityMetaSnapshot rawMeta) {
        String className = EntityClassAliasMapper.canonicalize(cleanClassName(rawType));
        EntityMetaNode node = entities.computeIfAbsent(className, EntityMetaNode::new);
        node.getSupportedVersions().add(version);

        if (rawMeta.rawSuperClassName() != null) {
            node.setSuperClassName(EntityClassAliasMapper.canonicalize(rawMeta.rawSuperClassName()));
        }

        for (Map.Entry<String, FieldSnapshot> fieldEntry : rawMeta.fields().entrySet()) {
            FieldNode fieldNode = node.getFields().computeIfAbsent(fieldEntry.getKey(), FieldNode::new);
            fieldNode.getVersions().put(version, fieldEntry.getValue());
        }
    }

    private JsonElement readJson(String resourcePath) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is == null) throw new IOException("Could not find resource: " + resourcePath);
            return JsonParser.parseReader(new InputStreamReader(is));
        }
    }

    /** Converts a raw JSON identifier (e.g. {@code "entity_living_base"}) into PascalCase. */
    private String cleanClassName(String rawInput) {
        if (rawInput.isEmpty()) throw new IllegalStateException("Input was null or empty");

        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : rawInput.toCharArray()) {
            if (c == ' ' || c == '_' || c == '-') {
                capitalizeNext = true;
                continue;
            }
            sb.append(capitalizeNext ? Character.toUpperCase(c) : c);
            capitalizeNext = false;
        }

        return sb.toString();
    }

}
