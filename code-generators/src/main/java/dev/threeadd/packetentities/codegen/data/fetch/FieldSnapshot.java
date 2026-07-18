package dev.threeadd.packetentities.codegen.data.fetch;

import dev.threeadd.packetentities.codegen.data.FieldNode;

/**
 * Unparsed field data for a single version, view {@link FieldNode} for the
 * aggregated, cross-version instance
 */
public record FieldSnapshot(int index, String rawDataType) {
}
