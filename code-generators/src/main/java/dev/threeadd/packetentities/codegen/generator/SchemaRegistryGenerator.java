package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.*;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypesIndex;

import javax.lang.model.element.Modifier;
import java.util.Map;

public class SchemaRegistryGenerator {

    private static final ClassName API_STATUS_INTERNAL = ClassName.get("org.jetbrains.annotations", "ApiStatus", "Internal");

    public JavaFile generate(Map<String, EntityMetaNode> aggregatedEntities) {
        System.out.println("Generating Schema Registry class file...");

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder("EntityTypeSchemas")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addAnnotation(API_STATUS_INTERNAL);

        MethodSpec.Builder initMethod = MethodSpec.methodBuilder("init")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC);

        for (EntityMetaNode node : aggregatedEntities.values()) {
            String constantName = EntityTypeMapper.defaultConstantName(node.getClassName());
            if (EntityTypesIndex.exists(constantName)) {
                ClassName metaClass = ClassName.get(GeneratedRefs.OUTPUT_PACKAGE, GeneratedRefs.OUTER_CLASS_NAME, node.getClassName());

                initMethod.addStatement("$T.registerProvider($T.$L, () -> $T.SCHEMA)",
                        GeneratedRefs.SCHEMA_REGISTRY, GeneratedRefs.ENTITY_TYPES, constantName, metaClass);
            }
        }

        classBuilder.addMethod(initMethod.build());

        return JavaFile.builder(GeneratedRefs.OUTPUT_PACKAGE, classBuilder.build())
                .addFileComment("Auto-generated file. Do not edit manually.\n")
                .indent("    ")
                .build();
    }

}
