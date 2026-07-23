package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.*;
import dev.threeadd.packetentities.codegen.GeneratedRefs;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypesIndex;

import javax.lang.model.element.Modifier;
import java.util.Map;

/**
 * Generates the {@code EntityTypeSchemas} class, whose static {@code init()} method registers
 * every aggregated entity's {@code SCHEMA} against its packetevents {@code EntityTypes} constant.
 */
public class SchemaRegistryGenerator {

    public JavaFile generate(Map<String, EntityMetaNode> aggregatedEntities) {
        System.out.println("Generating Schema Registry class file...");

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder("EntityTypeSchemas")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addAnnotation(GeneratedRefs.API_STATUS_INTERNAL);

        MethodSpec.Builder initMethod = MethodSpec.methodBuilder("init")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC);

        for (EntityMetaNode node : aggregatedEntities.values()) {
            addRegistration(initMethod, node);
        }

        classBuilder.addMethod(initMethod.build());

        return JavaFile.builder(GeneratedRefs.OUTPUT_PACKAGE, classBuilder.build())
                .addFileComment("Auto-generated file. Do not edit manually.\n")
                .indent("    ")
                .build();
    }

    private void addRegistration(MethodSpec.Builder initMethod, EntityMetaNode node) {
        String constantName = EntityTypeMapper.resolveConstantName(node.getClassName());
        if (!EntityTypesIndex.exists(constantName)) {
            return;
        }

        ClassName metaClass = ClassName.get(GeneratedRefs.OUTPUT_PACKAGE, GeneratedRefs.OUTER_CLASS_NAME, node.getClassName());
        initMethod.addStatement("$T.registerProvider($T.$L, () -> $T.SCHEMA)",
                GeneratedRefs.SCHEMA_REGISTRY, GeneratedRefs.ENTITY_TYPES, constantName, metaClass);
    }

}
