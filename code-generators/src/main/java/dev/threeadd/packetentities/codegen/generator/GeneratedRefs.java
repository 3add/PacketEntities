package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.ClassName;

/**
 * Package/class names shared across the generators, so {@link MetaFieldClassGenerator} and
 * {@link SchemaRegistryGenerator} can't quietly drift apart the way their previous, separately
 * declared copies of these same constants could.
 */
final class GeneratedRefs {

    static final String OUTPUT_PACKAGE = "dev.threeadd.packetentities.meta.protocol";
    static final String OUTER_CLASS_NAME = "EntityMetaFields";
    static final String META_PACKAGE = "dev.threeadd.packetentities.meta";
    static final String ENTITY_TYPES_PACKAGE = "com.github.retrooper.packetevents.protocol.entity.type";

    static final ClassName ENTITY_TYPES = ClassName.get(ENTITY_TYPES_PACKAGE, "EntityTypes");
    static final ClassName METADATA_SCHEMA = ClassName.get(META_PACKAGE, "EntityMetaSchema");
    static final ClassName SCHEMA_REGISTRY = ClassName.get(META_PACKAGE, "EntityMetaSchemaRegistry");
    static final ClassName FIELD_HOLDER = ClassName.get("dev.threeadd.packetentities.meta.field", "IEntityMetaFieldHolder");

    private GeneratedRefs() {
    }

}
