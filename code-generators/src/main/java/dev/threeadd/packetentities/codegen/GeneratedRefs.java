package dev.threeadd.packetentities.codegen;

import com.palantir.javapoet.AnnotationSpec;
import com.palantir.javapoet.ClassName;
import dev.threeadd.packetentities.codegen.generator.MetaFieldClassGenerator;
import dev.threeadd.packetentities.codegen.generator.SchemaRegistryGenerator;
import org.jetbrains.annotations.ApiStatus;

/**
 * Package/class names shared across the generators, so {@link MetaFieldClassGenerator} and
 * {@link SchemaRegistryGenerator} can't quietly drift apart the way their previous, separately
 * declared copies of these same constants could.
 */
public final class GeneratedRefs {

    public static final String META_PACKAGE = "dev.threeadd.packetentities.entity.meta";
    public static final String OUTPUT_PACKAGE = META_PACKAGE + ".protocol";
    public static final String OUTER_CLASS_NAME = "EntityMetaFields";
    public static final String ENTITY_TYPES_PACKAGE = "com.github.retrooper.packetevents.protocol.entity.type";

    public static final String FIELD_PACKAGE = META_PACKAGE + ".field";
    public static final ClassName SIMPLE_FIELD = ClassName.get(FIELD_PACKAGE, "SimpleField");
    public static final ClassName VIEW_FIELD = ClassName.get(FIELD_PACKAGE, "ViewField");
    public static final ClassName FIELD_HOLDER = ClassName.get(FIELD_PACKAGE, "IEntityMetaFieldHolder");
    public static final ClassName CLIENT_VERSION = ClassName.get("com.github.retrooper.packetevents.manager.server", "ServerVersion");
    public static final ClassName ENTITY_DATA_TYPES = ClassName.get("com.github.retrooper.packetevents.protocol.entity.data", "EntityDataTypes");

    public static final ClassName ENTITY_TYPES = ClassName.get(ENTITY_TYPES_PACKAGE, "EntityTypes");
    public static final ClassName METADATA_SCHEMA = ClassName.get(META_PACKAGE, "EntityMetaSchema");
    public static final ClassName SCHEMA_REGISTRY = ClassName.get(META_PACKAGE, "EntityMetaSchemaRegistry");

    public static final AnnotationSpec API_STATUS_INTERNAL = AnnotationSpec.builder(ApiStatus.Internal.class).build();
    public static final AnnotationSpec SUPPRESS_WARNINGS_UNUSED_AND_SPELLING = AnnotationSpec.builder(SuppressWarnings.class)
            .addMember("value", "{$S, $S}", "unused", "SpellCheckingInspection")
            .build();

    private GeneratedRefs() {
    }

}
