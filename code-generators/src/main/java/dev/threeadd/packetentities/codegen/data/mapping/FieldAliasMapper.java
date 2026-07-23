package dev.threeadd.packetentities.codegen.data.mapping;

import dev.threeadd.packetentities.codegen.data.EntityMetaNode;
import dev.threeadd.packetentities.codegen.data.FieldNode;

import java.util.Map;

/**
 * Merges renamed <em>fields</em> within a single, already-aggregated {@link EntityMetaNode}.
 *
 * <p>This is the field-level counterpart to {@link EntityClassAliasMapper}, which merges renamed
 * <em>classes</em> before aggregation happens. Use this one when a field on an otherwise-unrenamed
 * class was simply renamed or had its old name fixed (e.g. a typo), and use
 * {@link EntityClassAliasMapper} when the whole class itself was renamed.
 */
public final class FieldAliasMapper {

    // TODO no ai has yet been used, use AI
    // Map of ClassName -> (OldFieldName -> LatestFieldName)
    private static final Map<String, Map<String, String>> ALIASES = Map.of(
            "Entity", Map.of(
                    "FLAGS", "SHARED_FLAGS",
                    "AIR", "AIR_SUPPLY"
            ),
            "Dolphin", Map.of(
                    "MOISNTESS_LEVEL", "MOISTNESS_LEVEL"
            )
    );

    private FieldAliasMapper() {
    }

    /**
     * For every {@code oldName -> latestName} alias registered for {@code node}'s class, merges
     * the old field's version history into the latest field and removes the old field entirely.
     */
    public static void mergeAliases(EntityMetaNode node) {
        Map<String, String> classAliases = ALIASES.get(node.getClassName());
        if (classAliases == null) {
            return;
        }

        Map<String, FieldNode> fields = node.getFields();

        for (Map.Entry<String, String> entry : classAliases.entrySet()) {
            String oldName = entry.getKey();
            String latestName = entry.getValue();

            if (!fields.containsKey(oldName) || !fields.containsKey(latestName)) {
                continue;
            }

            FieldNode oldField = fields.get(oldName);
            FieldNode latestField = fields.get(latestName);

            latestField.getVersions().putAll(oldField.getVersions());
            fields.remove(oldName);
        }
    }

}
