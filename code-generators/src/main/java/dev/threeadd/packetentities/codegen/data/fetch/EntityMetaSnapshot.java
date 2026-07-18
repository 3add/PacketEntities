package dev.threeadd.packetentities.codegen.data.fetch;

import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import org.jetbrains.annotations.Nullable;
import java.util.Map;

/**
 * Unparsed metadata for a specific single version, view {@link EntityMetaNode}
 * for the aggregated, cross-version instance
 */
public record EntityMetaSnapshot(@Nullable String rawSuperClassName, Map<String, FieldSnapshot> fields) {

    public EntityMetaSnapshot {
        fields = Map.copyOf(fields);
    }

}
