package dev.threeadd.packetentities.meta.field;

import com.github.retrooper.packetevents.protocol.player.ClientVersion;

import java.util.NavigableMap;

/**
 * Represents a simple {@link EntityMetaField}
 *
 * @param <T> The protocol value type (and returned type)
 * @see ViewField
 */
public class SimpleField<T> extends EntityMetaField<T> {

    private SimpleField(NavigableMap<ClientVersion, VersionedMapping<T, ?>> versions) {
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
