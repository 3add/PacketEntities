package dev.threeadd.packetentities.codegen.generator;

import com.palantir.javapoet.*;
import dev.threeadd.packetentities.codegen.GeneratedRefs;
import dev.threeadd.packetentities.codegen.data.FieldNode;
import dev.threeadd.packetentities.codegen.data.fetch.FieldSnapshot;
import dev.threeadd.packetentities.codegen.data.mapping.DataTypeMapper;
import dev.threeadd.packetentities.codegen.data.mapping.DataTypeMapping;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Generates a single {@code SimpleField}/{@code ViewField} constant for one aggregated
 * {@link FieldNode}, together with its {@code .addVersionRange(...)} builder chain.
 */
public record FieldGenerator(JavadocGenerator javadocGenerator) {

    public FieldSpec generate(ClassName holderClass, FieldNode field, DataTypeMapper mapper) {
        FieldSnapshot latestData = getLatestVersionData(field);
        DataTypeMapping latestMapping = mapper.mapDataType(latestData.rawDataType());
        ClassName viewClass = mapper.getViewClass(holderClass.simpleName(), field.getFieldName());

        ParameterizedTypeName fieldType = resolveFieldType(latestMapping.typeName(), viewClass);
        CodeBlock initializer = buildInitializer(fieldType, field, latestMapping, latestData.rawDataType(), viewClass, mapper);
        CodeBlock javadoc = this.javadocGenerator.generateFieldJavadoc(field, viewClass);

        return FieldSpec.builder(fieldType, field.getFieldName())
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .addJavadoc(javadoc)
                .initializer(initializer)
                .build();
    }

    private ParameterizedTypeName resolveFieldType(TypeName innerType, ClassName viewClass) {
        if (viewClass != null) {
            return ParameterizedTypeName.get(GeneratedRefs.VIEW_FIELD, innerType, viewClass);
        }
        return ParameterizedTypeName.get(GeneratedRefs.SIMPLE_FIELD, innerType);
    }

    private CodeBlock buildInitializer(ParameterizedTypeName fieldType, FieldNode field, DataTypeMapping latestMapping,
                                       String latestRawType, ClassName viewClass, DataTypeMapper mapper) {
        CodeBlock.Builder builder = CodeBlock.builder();

        if (viewClass != null) {
            builder.add("$T.builder($T::new)$>\n", fieldType.rawType(), viewClass);
        } else {
            builder.add("$T.<$T>builder()$>\n", fieldType.rawType(), latestMapping.typeName());
        }

        for (VersionRange range : collapseIntoRanges(field.getVersions())) {
            appendVersionRangeMapping(builder, range, latestMapping, latestRawType, mapper);
        }

        return builder.add(".build()")
                .add("$<")
                .build();
    }

    /**
     * Collapses the per-version map into runs of consecutive versions that share the same field
     * index and raw data type, since a run like that only needs a single {@code addVersionRange}
     * call spanning its first and last version.
     */
    private List<VersionRange> collapseIntoRanges(Map<String, FieldSnapshot> versions) {
        List<VersionRange> ranges = new ArrayList<>();
        VersionRange current = null;

        for (Map.Entry<String, FieldSnapshot> entry : versions.entrySet()) {
            String version = entry.getKey();
            FieldSnapshot data = entry.getValue();

            if (current != null && current.canExtendWith(data)) {
                current.extendTo(version);
                continue;
            }

            current = new VersionRange(version, data);
            ranges.add(current);
        }

        return ranges;
    }

    private void appendVersionRangeMapping(CodeBlock.Builder builder, VersionRange range, DataTypeMapping latestMapping,
                                           String latestRawType, DataTypeMapper mapper) {
        DataTypeMapping versionMapping = mapper.mapDataType(range.data.rawDataType());
        boolean typesMatch = range.data.rawDataType().equals(latestRawType)
                || (versionMapping != null && latestMapping != null
                && Objects.equals(versionMapping.packetEventsDataType(), latestMapping.packetEventsDataType()));

        if (versionMapping == null || versionMapping.isExcluded() || !typesMatch) {
            builder.add("// TODO type changed from '$L' to '$L', converter required\n", range.data.rawDataType(), latestRawType);
            return;
        }

        builder.add(".addVersionRange($T.$L, $T.$L, $L, $T.$L)\n",
                GeneratedRefs.CLIENT_VERSION, range.startEnumName(), GeneratedRefs.CLIENT_VERSION, range.endEnumName(),
                range.data.index(), GeneratedRefs.ENTITY_DATA_TYPES, versionMapping.packetEventsDataType());
    }

    private FieldSnapshot getLatestVersionData(FieldNode field) {
        Map<String, FieldSnapshot> versions = field.getVersions();
        if (versions.isEmpty()) {
            throw new IllegalStateException("Empty versions map encountered during code generation for field '" + field.getFieldName() + "'.");
        }
        return versions.entrySet().stream().reduce((first, second) -> second).get().getValue();
    }

    /**
     * A run of consecutive versions sharing the same field index and raw data type.
     */
    private static final class VersionRange {

        private final String startVersion;
        private final FieldSnapshot data;
        private String endVersion;

        private VersionRange(String startVersion, FieldSnapshot data) {
            this.startVersion = startVersion;
            this.endVersion = startVersion;
            this.data = data;
        }

        private boolean canExtendWith(FieldSnapshot next) {
            return next.index() == this.data.index() && next.rawDataType().equals(this.data.rawDataType());
        }

        private void extendTo(String version) {
            this.endVersion = version;
        }

        private String startEnumName() {
            return toEnumName(this.startVersion);
        }

        private String endEnumName() {
            return toEnumName(this.endVersion);
        }

        private static String toEnumName(String version) {
            return "V_" + version.replace('.', '_');
        }

    }

}
