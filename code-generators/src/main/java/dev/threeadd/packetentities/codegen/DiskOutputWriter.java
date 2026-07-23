package dev.threeadd.packetentities.codegen;

import com.palantir.javapoet.JavaFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * {@link JavaFile#writeTo(Path)} doesn't let you post-process the emitted source, so this writes
 * it to a buffer first, runs {@link #formatClassBody(String)} over it, then writes it to disk
 * ourselves under {@code baseDir/<package/path>/<TypeName>.java}.
 */
public class DiskOutputWriter {

    private final Path baseDir;

    public DiskOutputWriter(Path baseDir) {
        this.baseDir = baseDir;
    }

    public void write(JavaFile javaFile) throws IOException {
        StringBuilder sb = new StringBuilder();
        javaFile.writeTo(sb);

        String source = formatClassBody(sb.toString());
        Path outputPath = resolveOutputPath(javaFile);

        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, source);
    }

    private Path resolveOutputPath(JavaFile javaFile) {
        Path outputDir = this.baseDir;

        if (!javaFile.packageName().isEmpty()) {
            for (String packageComponent : javaFile.packageName().split("\\.")) {
                outputDir = outputDir.resolve(packageComponent);
            }
        }

        return outputDir.resolve(javaFile.typeSpec().name() + ".java");
    }

    /**
     * JavaPoet emits fairly dense source with no blank lines around braces. These three passes
     * add them back in, purely for readability of the generated file:
     */
    private static String formatClassBody(String source) {
        // adds empty line after opening brace
        source = source.replaceAll("\\{\n(?!\\n)(\\s+\\S)", "{\n\n$1");

        // adds empty line before closing braces of methods/blocks
        source = source.replaceAll("(?<!\\n)\\n(\\s*\\}\\s*\\n)", "\n\n$1");

        // forces an empty line before the final closing brace of the class
        source = source.replaceAll("(\\s*\\})\\n\\}\\s*$", "$1\n\n}\n");

        return source;
    }

}
