package dev.threeadd.packetentities.codegen.data;

import dev.threeadd.packetentities.codegen.MetaPropertiesCodeGen;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Represents a metadata class node parsed from {@link MetaPropertiesCodeGen#DATA_PATH_FORMAT},
 * aggregated across every Minecraft version that was fetched.
 */
public class EntityMetaNode {

    private final String className;
    private String superClassName;
    private final Map<String, FieldNode> fields = new TreeMap<>();
    private final Set<String> supportedVersions = new TreeSet<>(MetaPropertiesCodeGen.VERSION_COMPARATOR);

    public EntityMetaNode(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public String getSuperClassName() {
        return this.superClassName;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public Map<String, FieldNode> getFields() {
        return this.fields;
    }

    public Set<String> getSupportedVersions() {
        return this.supportedVersions;
    }

}
