package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.*;
import dev.threeadd.packetentities.codegen.data.FieldNode;
import dev.threeadd.packetentities.codegen.data.fetch.FieldSnapshot;
import dev.threeadd.packetentities.codegen.data.mapping.DataTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.DataTypeMapping;

import javax.lang.model.element.Modifier;
import java.util.Map;
import java.util.Objects;

public class FieldGenerator {

    private static final ClassName SIMPLE_FIELD = ClassName.get("dev.threeadd.packetentities.meta.field", "SimpleField");
    private static final ClassName VIEW_FIELD = ClassName.get("dev.threeadd.packetentities.meta.field", "ViewField");
    private static final ClassName CLIENT_VERSION = ClassName.get("com.github.retrooper.packetevents.manager.server", "ServerVersion");
    private static final ClassName ENTITY_DATA_TYPES = ClassName.get("com.github.retrooper.packetevents.protocol.entity.data", "EntityDataTypes");

    private final JavadocGenerator javadocGenerator;

    public FieldGenerator(JavadocGenerator javadocGenerator) {
        this.javadocGenerator = javadocGenerator;
    }

    public JavadocGenerator getJavadocGenerator() {
        return this.javadocGenerator;
    }

    public FieldSpec generate(ClassName holderClass, FieldNode field, DataTypeMapper mapper) {
        FieldSnapshot latestData = getLatestVersionData(field.getVersions());
        DataTypeMapping latestMapping = mapper.mapDataType(latestData.rawDataType());

        ClassName viewClass = mapper.getViewClass(holderClass.simpleName(), field.getFieldName());
        ParameterizedTypeName fieldType = resolveFieldType(latestMapping.typeName(), viewClass);

        CodeBlock initBlock = buildInitializer(fieldType, field, latestMapping, latestData.rawDataType(), viewClass, mapper);
        CodeBlock javadocComment = this.javadocGenerator.generateFieldJavadoc(field, viewClass);

        return FieldSpec.builder(fieldType, field.getFieldName())
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .addJavadoc(javadocComment)
                .initializer(initBlock)
                .build();
    }

    private ParameterizedTypeName resolveFieldType(TypeName innerType, ClassName viewClass) {
        if (viewClass != null) {
            return ParameterizedTypeName.get(VIEW_FIELD, innerType, viewClass);
        }

        return ParameterizedTypeName.get(SIMPLE_FIELD, innerType);
    }

    private CodeBlock buildInitializer(ParameterizedTypeName fieldType, FieldNode field, DataTypeMapping latestMapping, String latestRawType, ClassName viewClass, DataTypeMapper mapper) {

        CodeBlock.Builder builder = CodeBlock.builder();

        if (viewClass != null) {
            builder.add("$T.builder($T::new)$>\n", fieldType.rawType(), viewClass);
        } else {
            builder.add("$T.<$T>builder()$>\n", fieldType.rawType(), latestMapping.typeName());
        }

        String startVersion = null;
        String endVersion = null;
        FieldSnapshot currentData = null;

        for (Map.Entry<String, FieldSnapshot> entry : field.getVersions().entrySet()) {
            String version = entry.getKey();
            FieldSnapshot data = entry.getValue();

            if (currentData == null) {
                startVersion = version;
                endVersion = version;
                currentData = data;
            } else if (data.index() == currentData.index() && data.rawDataType().equals(currentData.rawDataType())) {
                endVersion = version;
            } else {
                appendVersionRangeMapping(builder, startVersion, endVersion, currentData, latestMapping, latestRawType, mapper);
                startVersion = version;
                endVersion = version;
                currentData = data;
            }
        }

        if (currentData != null) {
            appendVersionRangeMapping(builder, startVersion, endVersion, currentData, latestMapping, latestRawType, mapper);
        }

        return builder.add(".build()")
                .add("$<")
                .build();
    }

    private void appendVersionRangeMapping(CodeBlock.Builder builder, String startVersion, String endVersion, FieldSnapshot data, DataTypeMapping latestMapping, String latestRawType, DataTypeMapper mapper) {
        String enumStartVersion = "V_" + startVersion.replace('.', '_');
        String enumEndVersion = "V_" + endVersion.replace('.', '_');
        DataTypeMapping versionMapping = mapper.mapDataType(data.rawDataType());

        boolean typesMatch = data.rawDataType().equals(latestRawType) ||
                (versionMapping != null && latestMapping != null &&
                        Objects.equals(versionMapping.packetEventsDataType(), latestMapping.packetEventsDataType()));

        if (versionMapping != null && !versionMapping.isExcluded() && typesMatch) {
            builder.add(".addVersionRange($T.$L, $T.$L, $L, $T.$L)\n",
                    CLIENT_VERSION, enumStartVersion, CLIENT_VERSION, enumEndVersion, data.index(), ENTITY_DATA_TYPES, versionMapping.packetEventsDataType());
        } else {
            builder.add("// TODO type changed from '$L' to '$L', converter required\n",
                    data.rawDataType(), latestRawType);
        }
    }

    private FieldSnapshot getLatestVersionData(Map<String, FieldSnapshot> versions) {
        if (versions.isEmpty()) {
            throw new IllegalStateException("Empty versions map encountered during code generation.");
        }
        return versions.entrySet().stream().reduce((first, second) -> second).get().getValue();
    }

}
