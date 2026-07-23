package dev.threeadd.packetentities.entity.meta;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import dev.threeadd.packetentities.entity.meta.field.EntityMetaField;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * Maps {@link EntityType}s to a {@link EntityMetaSchema} holding all the respective type's {@link EntityMetaField}s.
 */
public final class EntityMetaSchemaRegistry {

    private static final Map<EntityType, EntityMetaSchema> SCHEMAS = new ConcurrentHashMap<>();
    private static final Map<EntityType, Supplier<EntityMetaSchema>> LAZY_PROVIDERS = new ConcurrentHashMap<>();

    private EntityMetaSchemaRegistry() {
    }

    @ApiStatus.Internal
    public static void register(@Nullable EntityType type, EntityMetaSchema schema) {
        if (type == null) return;
        SCHEMAS.put(type, schema);
    }

    @ApiStatus.Internal
    public static void registerProvider(EntityType type, Supplier<EntityMetaSchema> provider) {
        LAZY_PROVIDERS.put(type, provider);
    }

    public static EntityMetaSchema getSchema(@Nullable EntityType type) {
        for (EntityType current = type; current != null; current = current.getParent().orElse(null)) {
            EntityMetaSchema schema = SCHEMAS.get(current);
            if (schema != null) return schema;

            Supplier<EntityMetaSchema> provider = LAZY_PROVIDERS.get(current);
            if (provider != null) {
                schema = provider.get();

                LAZY_PROVIDERS.remove(current);
                return schema;
            }
        }

        throw new IllegalArgumentException("No schema registered for EntityType " + type);
    }

    public static void loadAll() {
        for (EntityType type : LAZY_PROVIDERS.keySet()) {
            getSchema(type);
        }
    }

    public static Collection<EntityMetaSchema> getLoadedSchemas() {
        return SCHEMAS.values();
    }

}
