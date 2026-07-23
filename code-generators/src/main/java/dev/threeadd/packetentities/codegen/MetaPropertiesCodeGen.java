package dev.threeadd.packetentities.codegen;

import com.palantir.javapoet.JavaFile;
import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.fetch.EntityMetaFetcher;
import dev.threeadd.packetentities.codegen.data.mapping.DataTypeMapper;
import dev.threeadd.packetentities.codegen.generator.JavadocGenerator;
import dev.threeadd.packetentities.codegen.generator.MetaFieldClassGenerator;
import dev.threeadd.packetentities.codegen.generator.SchemaRegistryGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Entry point for the code generator: fetches entity metadata for every supported Minecraft
 * version, aggregates it (merging renamed classes/fields), topologically sorts it by
 * inheritance, then emits the unified {@code EntityMetaFields} class and the schema registry.
 */
public class MetaPropertiesCodeGen {

    public static final String VERSIONS_PATH = "/entity-data/versions.json";
    public static final String DATA_PATH_FORMAT = "/entity-data/%s.json";
    private static final Set<String> EXCLUDED_VERSIONS = Set.of();

    public static final Comparator<String> VERSION_COMPARATOR = (v1, v2) -> {
        String[] p1 = v1.split("\\.");
        String[] p2 = v2.split("\\.");
        int length = Math.max(p1.length, p2.length);
        for (int i = 0; i < length; i++) {
            int n1 = i < p1.length ? Integer.parseInt(p1[i]) : 0;
            int n2 = i < p2.length ? Integer.parseInt(p2[i]) : 0;
            if (n1 != n2) return Integer.compare(n1, n2);
        }
        return 0;
    };

    public static void main(String[] args) {
        String rawOutputDir = (args.length > 0) ? args[0] : "output";
        Path baseDir = Paths.get(System.getProperty("user.dir"))
                .resolve(rawOutputDir)
                .toAbsolutePath()
                .normalize();

        System.out.println("Starting MetaProperties code generator. Outputting to base directory: " + baseDir);

        DiskOutputWriter outputWriter = new DiskOutputWriter(baseDir);
        DataTypeMapper mapper = new DataTypeMapper();

        try {
            EntityMetaFetcher fetcher = new EntityMetaFetcher(VERSIONS_PATH, DATA_PATH_FORMAT, EXCLUDED_VERSIONS);

            List<String> fullVersions = fetcher.fetchVersions();
            fullVersions.sort(VERSION_COMPARATOR);

            Map<String, EntityMetaNode> metas = fetcher.fetchAndAggregateMetas(fullVersions);

            JavadocGenerator javadocGenerator = new JavadocGenerator(fullVersions);
            MetaFieldClassGenerator classGenerator = new MetaFieldClassGenerator(mapper, javadocGenerator);

            List<EntityMetaNode> sortedEntities = getTopologicallySortedEntities(metas);

            System.out.println("Generating unified class file with nested inner classes...");
            writeUnifiedClass(outputWriter, classGenerator, sortedEntities);

            System.out.println("Generating schema registry...");
            SchemaRegistryGenerator registryGenerator = new SchemaRegistryGenerator();
            outputWriter.write(registryGenerator.generate(metas));

            System.out.println("All meta properties generated cleanly.");

        } catch (IOException e) {
            throw new IllegalStateException("Something failed whilst trying to generate the classes", e);
        }
    }

    private static void writeUnifiedClass(DiskOutputWriter outputWriter, MetaFieldClassGenerator classGenerator,
                                           List<EntityMetaNode> sortedEntities) throws IOException {
        try {
            JavaFile compiledJavaFile = classGenerator.generate(sortedEntities);
            outputWriter.write(compiledJavaFile);
        } catch (Exception e) {
            System.err.println("Failed to write single unified EntityMetaProperties class: " + e.getMessage());
            throw e;
        }
    }

    /** Orders entities so that every superclass appears before its subclasses. */
    private static List<EntityMetaNode> getTopologicallySortedEntities(Map<String, EntityMetaNode> aggregatedEntities) {
        List<EntityMetaNode> sortedResult = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        List<String> sortedKeys = aggregatedEntities.keySet().stream().sorted().toList();
        for (String className : sortedKeys) {
            visitNode(className, aggregatedEntities, visited, sortedResult);
        }

        return sortedResult;
    }

    private static void visitNode(String className, Map<String, EntityMetaNode> map, Set<String> visited, List<EntityMetaNode> result) {
        if (className == null || visited.contains(className)) return;

        EntityMetaNode node = map.get(className);
        if (node == null) return;

        if (node.getSuperClassName() != null) {
            visitNode(node.getSuperClassName(), map, visited, result);
        }

        visited.add(className);
        result.add(node);
    }

}
