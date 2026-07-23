package dev.threeadd.packetentities.entity.meta.field;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.function.Function;

/**
 * A versioned mapping between a logical value type {@code R} and the
 * PacketEvents protocol representation {@code W}.
 *
 * <p>Properties are immutable after construction and safe to hold as {@code static final}
 * constants.
 *
 * @param <T> the logical value type read and written by library user code
 * @see SimpleField
 * @see ViewField
 */
public abstract class EntityMetaField<T> {

    private final NavigableMap<ServerVersion, VersionedMapping<T, ?>> versions;

    protected EntityMetaField(NavigableMap<ServerVersion, VersionedMapping<T, ?>> versions) {
        this.versions = versions;
    }

    public int getIndex(@Nullable ServerVersion version) {
        if (version == null) return -1;
        Map.Entry<ServerVersion, VersionedMapping<T, ?>> entry = this.versions.floorEntry(version);
        if (entry != null && version.compareTo(entry.getValue().end) <= 0) {
            return entry.getValue().index;
        }
        return -1;
    }

    /**
     * Returns the highest packet metadata index assigned to this field
     * across all registered versions
     *
     * @return the maximum metadata index found, or {@code -1} if no
     * version mappings are defined
     */
    public int getMaxIndex() {
        int max = -1;
        for (VersionedMapping<T, ?> mapping : this.versions.values()) {
            if (mapping.index > max) max = mapping.index;
        }
        return max;
    }

    public @Nullable EntityDataType<?> getDataType(@Nullable ServerVersion version) {
        if (version == null) return null;
        Map.Entry<ServerVersion, VersionedMapping<T, ?>> entry = this.versions.floorEntry(version);
        if (entry != null && version.compareTo(entry.getValue().end) <= 0) {
            return entry.getValue().type;
        }
        return null;
    }

    public @Nullable T parse(@Nullable ServerVersion version, @Nullable EntityData<?> data) {
        if (data == null || version == null) return null;
        Map.Entry<ServerVersion, VersionedMapping<T, ?>> entry = this.versions.floorEntry(version);
        if (entry == null || version.compareTo(entry.getValue().end) > 0) return null;
        return entry.getValue().deserialize(data.getValue());
    }

    public @Nullable EntityData<?> createData(@Nullable ServerVersion version, T rawValue) {
        if (version == null) return null;
        Map.Entry<ServerVersion, VersionedMapping<T, ?>> entry = this.versions.floorEntry(version);
        if (entry == null || version.compareTo(entry.getValue().end) > 0) return null;
        return entry.getValue().createData(rawValue);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "maxIndex=" + getMaxIndex() +
                ", registeredVersions=" + this.versions.keySet() +
                '}';
    }

    /**
     * An abstract builder providing shared version mapping logic
     *
     * @param <T> The logical value type
     * @param <B> The concrete builder implementation type
     */
    public abstract static class BaseBuilder<T, B extends BaseBuilder<T, B>> {

        protected final NavigableMap<ServerVersion, VersionedMapping<T, ?>> versions = new TreeMap<>();

        @SuppressWarnings("unchecked")
        protected final B self() {
            return (B) this;
        }

        public B addVersionRange(ServerVersion start, ServerVersion end, int index, EntityDataType<T> type) {
            this.versions.put(start, new VersionedMapping<>(end, index, type, Function.identity(), Function.identity()));
            return self();
        }

        public <N> B addVersionRange(ServerVersion start, ServerVersion end, int index, EntityDataType<N> type, Function<T, N> serializer, Function<N, T> deserializer) {
            this.versions.put(start, new VersionedMapping<>(end, index, type, serializer, deserializer));
            return self();
        }

        public abstract EntityMetaField<T> build();

    }

    protected static class VersionedMapping<T, P> {

        final ServerVersion end;
        final int index;
        final EntityDataType<P> type;
        private final Function<T, P> serializer;
        private final Function<P, T> deserializer;

        VersionedMapping(ServerVersion end, int index, EntityDataType<P> type, Function<T, P> serializer, Function<P, T> deserializer) {
            this.end = end;
            this.index = index;
            this.type = type;
            this.serializer = serializer;
            this.deserializer = deserializer;
        }

        EntityData<P> createData(T logicalValue) {
            return new EntityData<>(this.index, this.type, this.serializer.apply(logicalValue));
        }

        @SuppressWarnings("unchecked")
        T deserialize(Object packetEventsValue) {
            return this.deserializer.apply((P) packetEventsValue);
        }

        @Override
        public String toString() {
            return "Mapping{end=" + this.end + ", index=" + this.index + ", type=" + this.type + "}";
        }

    }

}
