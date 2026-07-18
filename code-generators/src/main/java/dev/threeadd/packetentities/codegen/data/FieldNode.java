package dev.threeadd.packetentities.codegen.data;

import dev.threeadd.packetentities.codegen.MetaPropertiesCodeGen;
import dev.threeadd.packetentities.codegen.data.fetch.FieldSnapshot;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a metadata field after parsing from {@link MetaPropertiesCodeGen#DATA_PATH_FORMAT},
 * aggregated across every Minecraft version that was fetched.
 */
public class FieldNode {

    private final String fieldName;
    private final Map<String, FieldSnapshot> versions = new TreeMap<>(MetaPropertiesCodeGen.VERSION_COMPARATOR);

    public FieldNode(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Map<String, FieldSnapshot> getVersions() {
        return this.versions;
    }

}
