package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.*;
import dev.threeadd.packetentities.codegen.GeneratedRefs;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.FieldNode;
import dev.threeadd.packetentities.codegen.data.mapping.DataTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypesIndex;
import dev.threeadd.packetentities.codegen.data.mapping.FieldAliasMapper;

import javax.lang.model.element.Modifier;
import java.util.List;

/**
 * Generates the single {@code EntityMetaFields} outer class, containing one static inner class
 * per aggregated {@link EntityMetaNode}, each holding its fields and combined {@code SCHEMA}.
 */
public class MetaFieldClassGenerator {

    private final DataTypeMapper mapper;
    private final FieldGenerator fieldGenerator;

    public MetaFieldClassGenerator(DataTypeMapper mapper, JavadocGenerator javadocGenerator) {
        this.mapper = mapper;
        this.fieldGenerator = new FieldGenerator(javadocGenerator);
    }

    public JavaFile generate(List<EntityMetaNode> sortedEntities) {
        TypeSpec.Builder outerClassBuilder = TypeSpec.classBuilder(GeneratedRefs.OUTER_CLASS_NAME)
                .addAnnotation(GeneratedRefs.SUPPRESS_WARNINGS_UNUSED_AND_SPELLING)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addJavadoc("Holds all {@link $T} and {@link $T}, grouped by their respective {@link $T}.\n",
                        GeneratedRefs.FIELD_HOLDER, GeneratedRefs.METADATA_SCHEMA, GeneratedRefs.ENTITY_TYPES);

        for (EntityMetaNode node : sortedEntities) {
            FieldAliasMapper.mergeAliases(node);
            outerClassBuilder.addType(generateInnerClass(node));
        }

        return JavaFile.builder(GeneratedRefs.OUTPUT_PACKAGE, outerClassBuilder.build())
                .addFileComment("Auto-generated file. Do not edit manually.\n")
                .skipJavaLangImports(true)
                .indent("    ")
                .build();
    }

    private TypeSpec generateInnerClass(EntityMetaNode node) {
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(node.getClassName())
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addJavadoc(this.fieldGenerator.javadocGenerator().generateClassJavadoc(node));

        if (hasSuperClass(node)) {
            classBuilder.superclass(ClassName.get("", node.getSuperClassName()));
        } else {
            classBuilder.addSuperinterface(GeneratedRefs.FIELD_HOLDER);
        }

        ClassName selfClass = ClassName.get("", node.getClassName());

        for (FieldNode field : node.getFields().values()) {
            classBuilder.addField(this.fieldGenerator.generate(selfClass, field, this.mapper));
        }

        classBuilder.addField(buildSchemaField(node, selfClass));

        return classBuilder.build();
    }

    private FieldSpec buildSchemaField(EntityMetaNode node, ClassName selfClass) {
        CodeBlock.Builder initializer = CodeBlock.builder();
        initializer.add(buildSchemaBase(node));

        for (FieldNode field : node.getFields().values()) {
            initializer.add("\n.add($T.$L)", selfClass, field.getFieldName());
        }

        initializer.add("\n.build()$<");

        return FieldSpec.builder(GeneratedRefs.METADATA_SCHEMA, "SCHEMA")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(initializer.build())
                .build();
    }

    private CodeBlock buildSchemaBase(EntityMetaNode node) {
        if (!hasSuperClass(node)) {
            return CodeBlock.of("$T.builder($T.$L)$>", GeneratedRefs.METADATA_SCHEMA, GeneratedRefs.ENTITY_TYPES, "ENTITY");
        }

        ClassName superMetaProperties = ClassName.get("", node.getSuperClassName());
        String constantName = EntityTypeMapper.resolveConstantName(node.getClassName());

        if (!EntityTypesIndex.exists(constantName)) {
            return CodeBlock.of("$T.$N.extend($L)$> // TODO Entity Type need mappings", superMetaProperties, "SCHEMA", "null");
        }

        return CodeBlock.of("$T.$N.extend($T.$L)$>", superMetaProperties, "SCHEMA", GeneratedRefs.ENTITY_TYPES, constantName);
    }

    private boolean hasSuperClass(EntityMetaNode node) {
        return node.getSuperClassName() != null && !node.getSuperClassName().isEmpty();
    }

}
