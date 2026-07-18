package dev.threeadd.packetentities.meta.field;

import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.MetadataView;

import java.util.NavigableMap;
import java.util.function.Function;

/**
 * Represent a {@link EntityMetaField} where the value is a {@link MetadataView}
 *
 * @param <T> The type of data the view represents
 * @param <V> The view wrapper type
 * @see SimpleField
 */
public final class ViewField<T, V extends MetadataView<T>> extends EntityMetaField<T> {

    private final Function<ProtocolEntityMeta, V> viewFactory;

    private ViewField(NavigableMap<ClientVersion, VersionedMapping<T, ?>> versions, Function<ProtocolEntityMeta, V> viewFactory) {
        super(versions);
        this.viewFactory = viewFactory;
    }

    /**
     * Creates a new wrapper instance bound to the given metadata store.
     *
     * @param store the handle entity, to apply data to when using the setters or get data from using the getters
     * @return the view
     * @throws IllegalStateException if no factory was provided at build time
     */
    public V createView(ProtocolEntityMeta store) {
        return this.viewFactory.apply(store);
    }

    @Override
    public String toString() {
        return "ViewField{" +
                "maxIndex=" + getMaxIndex() +
                '}';
    }

    public static <T, V extends MetadataView<T>> Builder<T, V> builder(Function<ProtocolEntityMeta, V> wrapperFactory) {
        return new Builder<>(wrapperFactory);
    }

    public static class Builder<T, V extends MetadataView<T>> extends BaseBuilder<T, Builder<T, V>> {

        private final Function<ProtocolEntityMeta, V> wrapperFactory;

        public Builder(Function<ProtocolEntityMeta, V> wrapperFactory) {
            this.wrapperFactory = wrapperFactory;
        }

        @Override
        public ViewField<T, V> build() {
            return new ViewField<>(this.versions, this.wrapperFactory);
        }

    }

}
