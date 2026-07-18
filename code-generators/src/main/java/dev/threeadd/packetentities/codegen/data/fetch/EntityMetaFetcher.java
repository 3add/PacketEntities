package dev.threeadd.packetentities.codegen.data.fetch;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.FieldNode;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EntityMetaFetcher {

    private final String versionsPath;
    private final String dataPathFormat;
    private final Set<String> excludedVersions;

    public EntityMetaFetcher(String versionsPath, String dataPathFormat, Set<String> excludedVersions) {
        this.versionsPath = versionsPath;
        this.dataPathFormat = dataPathFormat;
        this.excludedVersions = excludedVersions;
    }

    public List<String> fetchVersions() throws IOException {
        List<String> filtered = new ArrayList<>();

        try (InputStream is = getClass().getResourceAsStream(this.versionsPath)) {
            if (is == null) throw new IOException("Could not find resource: " + this.versionsPath);

            JsonElement parsedElement = JsonParser.parseReader(new InputStreamReader(is));

            if (parsedElement != null && parsedElement.isJsonArray()) {
                for (JsonElement obj : parsedElement.getAsJsonArray()) {
                    String version = obj.getAsString();

                    if (!version.matches("^\\d+(\\.\\d+)*$")) {
                        continue;
                    }

                    if (!this.excludedVersions.contains(version)) {
                        filtered.add(version);
                    }
                }
            }
        }
        return filtered;
    }

    public Map<String, EntityMetaSnapshot> fetchVersionSnapshot(String version) throws IOException {
        String path = String.format(this.dataPathFormat, version);
        Map<String, EntityMetaSnapshot> versionEntities = new HashMap<>();

        try (InputStream is = getClass().getResourceAsStream(path)) {
            if (is == null) throw new IOException("Could not find resource: " + path);

            JsonElement parsedElement = JsonParser.parseReader(new InputStreamReader(is));

            if (parsedElement != null && parsedElement.isJsonObject()) {
                JsonObject rootObject = parsedElement.getAsJsonObject();

                for (Map.Entry<String, JsonElement> metaEntry : rootObject.entrySet()) {
                    String rawType = metaEntry.getKey();
                    if (!metaEntry.getValue().isJsonObject()) continue;
                    JsonObject metaObj = metaEntry.getValue().getAsJsonObject();

                    String superClass = null;
                    if (metaObj.has("superClass") && !metaObj.get("superClass").isJsonNull()) {
                        String rawSuperClass = metaObj.get("superClass").getAsString();
                        superClass = cleanClassName(rawSuperClass);
                    }

                    Map<String, FieldSnapshot> fieldsMap = new HashMap<>();
                    if (metaObj.has("fields") && metaObj.get("fields").isJsonArray()) {
                        JsonArray fieldsArray = metaObj.getAsJsonArray("fields");
                        for (JsonElement fieldElement : fieldsArray) {
                            if (!fieldElement.isJsonObject()) continue;
                            JsonObject fieldObj = fieldElement.getAsJsonObject();

                            int index = fieldObj.get("index").getAsInt();
                            String dataType = fieldObj.get("dataType").getAsString();
                            String fieldName = fieldObj.get("fieldName").getAsString();

                            fieldsMap.put(fieldName, new FieldSnapshot(index, dataType));
                        }
                    }

                    versionEntities.put(rawType, new EntityMetaSnapshot(superClass, fieldsMap));
                }
            }
        }

        return versionEntities;
    }

    public Map<String, EntityMetaNode> fetchAndAggregateMetas(List<String> versions) throws IOException {
        Map<String, EntityMetaNode> entities = new TreeMap<>();

        for (String version : versions) {
            if (this.excludedVersions.contains(version)) continue;

            System.out.println("Loading snapshot layouts for Minecraft version: " + version);
            Map<String, EntityMetaSnapshot> versionSnapshot = fetchVersionSnapshot(version);

            for (Map.Entry<String, EntityMetaSnapshot> entry : versionSnapshot.entrySet()) {
                String rawType = entry.getKey();
                EntityMetaSnapshot rawMeta = entry.getValue();

                String className = cleanClassName(rawType);
                EntityMetaNode aggregatedNode = entities.computeIfAbsent(className, EntityMetaNode::new);
                aggregatedNode.getSupportedVersions().add(version);

                if (rawMeta.rawSuperClassName() != null) {
                    aggregatedNode.setSuperClassName(rawMeta.rawSuperClassName());
                }

                for (Map.Entry<String, FieldSnapshot> fieldEntry : rawMeta.fields().entrySet()) {
                    String fieldName = fieldEntry.getKey();
                    FieldSnapshot rawField = fieldEntry.getValue();

                    FieldNode fieldNode = aggregatedNode.getFields().computeIfAbsent(fieldName, FieldNode::new);
                    fieldNode.getVersions().put(version, rawField);
                }
            }
        }

        return entities;
    }

    private String cleanClassName(String rawInput) {
        if (rawInput.isEmpty()) throw new IllegalStateException("Input was null or empty");
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : rawInput.toCharArray()) {
            if (c == ' ' || c == '_' || c == '-') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                sb.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
