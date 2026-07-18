package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.*;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.FieldNode;
import dev.threeadd.packetentities.codegen.data.mapping.DataTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.EntityTypesIndex;
import dev.threeadd.packetentities.codegen.data.mapping.FieldAliasMapper;

import javax.lang.model.element.Modifier;
import java.util.List;

public class MetaFieldClassGenerator {

    private final DataTypeMapper mapper;
    private final FieldGenerator fieldGenerator;

    public MetaFieldClassGenerator(DataTypeMapper mapper, JavadocGenerator javadocGenerator) {
        this.mapper = mapper;
        this.fieldGenerator = new FieldGenerator(javadocGenerator);
    }

    public JavaFile generate(List<EntityMetaNode> sortedEntities) {
        TypeSpec.Builder outerClassBuilder = TypeSpec.classBuilder(GeneratedRefs.OUTER_CLASS_NAME)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings.class)
                        .addMember("value", "$S", "unused")
                        .build())
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addJavadoc("Container for all auto-generated packet entity metadata schemas and fields.\n");

        for (EntityMetaNode node : sortedEntities) {
            FieldAliasMapper.mergeAliases(node);

            TypeSpec innerClass = generateInnerClass(node);
            outerClassBuilder.addType(innerClass);
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
                .addJavadoc(this.fieldGenerator.getJavadocGenerator().generateClassJavadoc(node));

        if (node.getSuperClassName() != null && !node.getSuperClassName().isEmpty()) {
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

        String constantName = EntityTypeMapper.resolveConstantName(node.getClassName());

        if (node.getSuperClassName() != null && !node.getSuperClassName().isEmpty()) {
            ClassName superMetaProperties = ClassName.get("", node.getSuperClassName());

            if (EntityTypesIndex.exists(constantName)) {
                initializer.add("$T.$N.extend($T.$L)$>", superMetaProperties, "SCHEMA", GeneratedRefs.ENTITY_TYPES, constantName);
            } else {
                initializer.add("$T.$N.extend($L)$> // TODO Entity Type need mappings", superMetaProperties, "SCHEMA", "null");
            }
        } else {
            initializer.add("$T.builder($T.$L)$>", GeneratedRefs.METADATA_SCHEMA, GeneratedRefs.ENTITY_TYPES, "ENTITY");
        }

        for (FieldNode field : node.getFields().values()) {
            initializer.add("\n.add($T.$L)", selfClass, field.getFieldName());
        }

        initializer.add("\n.build()$<");

        return FieldSpec.builder(GeneratedRefs.METADATA_SCHEMA, "SCHEMA")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .addJavadoc("""
                        The {@link $T} containing this meta's properties, combined with all
                        properties declared by its super classes.
                        """, GeneratedRefs.METADATA_SCHEMA)
                .initializer(initializer.build())
                .build();
    }

}
