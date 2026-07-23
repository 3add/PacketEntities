package dev.threeadd.packetentities.entity.meta.field;

import com.github.retrooper.packetevents.manager.server.ServerVersion;

import java.util.NavigableMap;

/**
 * Represents a simple {@link EntityMetaField}
 *
 * @param <T> The protocol value type (and returned type)
 * @see ViewField
 */
public class SimpleField<T> extends EntityMetaField<T> {

    private SimpleField(NavigableMap<ServerVersion, VersionedMapping<T, ?>> versions) {
        super(versions);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> extends BaseBuilder<T, Builder<T>> {

        @Override
        public SimpleField<T> build() {
            return new SimpleField<>(this.versions);
        }

    }

}
