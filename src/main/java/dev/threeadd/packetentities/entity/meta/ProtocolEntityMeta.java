package dev.threeadd.packetentities.entity.meta;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityMetadataProvider;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import dev.threeadd.packetentities.entity.meta.field.EntityMetaField;
import dev.threeadd.packetentities.entity.meta.field.SimpleField;
import dev.threeadd.packetentities.entity.meta.field.ViewField;
import dev.threeadd.packetentities.entity.meta.protocol.view.EntityMetaView;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A version-agnostic data store for <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata">entity metadata</a>
 */
public class ProtocolEntityMeta implements EntityMetadataProvider {

    private final EntityMetaSchema schema;
    private final Map<EntityMetaField<?>, Object> metadata = new ConcurrentHashMap<>();
    private final Map<ViewField<?, ?>, Object> views = new ConcurrentHashMap<>();

    /**
     * Create a new metadata store instance
     *
     * @param schema the {@link EntityMetaSchema}, you can create your own,
     *               PacketEntities' ensures there are no duplicate indices for one entity type
     * @throws NullPointerException if the provided {@code schema} is null
     */
    public ProtocolEntityMeta(EntityMetaSchema schema) {
        this.schema = Objects.requireNonNull(schema, "schema cannot be null");
    }

    /**
     * Create a new metadata store instance
     *
     * @param type the {@link EntityType} to use the default schema for
     * @throws NullPointerException if the provided {@code type} is null
     */
    public ProtocolEntityMeta(EntityType type) {
        this(EntityMetaSchemaRegistry.getSchema(Objects.requireNonNull(type, "type cannot be null")));
    }

    /**
     * Clears all stored data
     *
     * @return this meta for chaining
     */
    public ProtocolEntityMeta clear() {
        this.metadata.clear();
        this.views.clear();
        return this;
    }

    /**
     * @return the schema this meta holds
     */
    public EntityMetaSchema getSchema() {
        return this.schema;
    }

    /**
     * Stores a value for a simple (non-wrapped) metadata field.
     *
     * @param field the simple field to set
     * @param <T>   the type of the field
     * @param value the new value
     * @return this entity meta for chaining
     */
    public <T> ProtocolEntityMeta set(SimpleField<T> field, @Nullable T value) {
        return this.setRaw(field, value);
    }

    /**
     * @param field the simple field to get
     * @param <T>   the type of the field
     * @return the current value of a simple metadata field, or {@code null}
     * if the field has not been set.
     */
    public <T> @Nullable T get(SimpleField<T> field) {
        return this.getRaw(field);
    }

    /**
     * @param field the simple field to get
     * @param <T>   the type of the field
     * @return the current value of a simple metadata field, or {@code null}
     * if the field has not been set.
     */
    @SuppressWarnings("unchecked")
    public <T> Optional<T> getOptional(SimpleField<T> field) {
        return Optional.ofNullable((T) this.metadata.get(field));
    }

    /**
     * @param field the view field to get
     * @param <V>   the type of the view
     * @param <T>   the type of the underlying value
     * @return the {@link EntityMetaView} for a view field.
     *
     * <p>The view itself reads from and writes to this
     * store, so no separate "set" call is needed, mutate the view directly.
     */
    @SuppressWarnings({"unchecked"})
    public <T, V extends EntityMetaView<T>> V get(ViewField<T, V> field) {
        return (V) this.views.computeIfAbsent(field, k -> field.createView(this));
    }

    /**
     * @param field the field to check for
     * @return {@code true} if this store has a value for the given field
     */
    public boolean has(EntityMetaField<?> field) {
        return this.metadata.containsKey(field);
    }

    /**
     * Stores a raw value for any field.
     * {@link #set(SimpleField, Object)} or the {@link ViewField} setters should be by api users.
     *
     * @param field the field to set
     * @param value the value to set, or {@code null} to remove the field
     * @param <R>   the type of the field
     * @return this meta for chaining
     */
    @ApiStatus.Internal
    public <R> ProtocolEntityMeta setRaw(EntityMetaField<R> field, @Nullable R value) {
        if (value == null) {
            this.metadata.remove(field);
            return this;
        }

        if (!this.schema.contains(field)) {
            throw new IllegalArgumentException(String.format(
                    "Field '%s' is not valid for entity type: %s", field, this.schema.getBoundEntityType()
            ));
        }

        this.metadata.put(field, value);
        return this;
    }

    /**
     * @param field the field to get the raw value for
     * @param <R>   the type of the field
     * @return the raw stored value for any field.
     * {@link #getOptional(SimpleField)} or {@link #get(SimpleField)} should be by api users
     */
    @SuppressWarnings("unchecked")
    @ApiStatus.Internal
    public <R> @Nullable R getRaw(EntityMetaField<R> field) {
        return (R) this.metadata.get(field);
    }

    /**
     * Copies all metadata values from this store into {@code target}, replacing
     * any values already present in {@code target}.
     *
     * @param target the target to copy to
     * @return this meta for chaining (which is updated)
     */
    public ProtocolEntityMeta copyTo(ProtocolEntityMeta target) {
        target.metadata.putAll(this.metadata);
        // views are tied to their parent store, they must not be copied
        // each store maintains its own view instances pointing back to itself
        target.views.clear();
        return this;
    }

    /**
     * Stores all the data from a packet in this meta wrapper.
     *
     * @param packet  the packet
     * @param version the version of the data inside the packet (probably just your server version)
     * @return this meta for chaining
     */
    public ProtocolEntityMeta setDataFromPacket(WrapperPlayServerEntityMetadata packet, ServerVersion version) {
        this.schema.applyPacketToStore(packet, this, version);
        return this;
    }

    /**
     * Creates a {@link WrapperPlayServerEntityMetadata} packet from the current
     * held metadata for the given entity id and version for the data.
     *
     * @param entityId the entity id include in the packet
     * @param version  the version to encode the data for
     * @return a new {@link WrapperPlayServerEntityMetadata} packet with the current data
     */
    public WrapperPlayServerEntityMetadata createPacket(int entityId, ServerVersion version) {
        return new WrapperPlayServerEntityMetadata(entityId, entityData(version.toClientVersion())); // TODO, see below
    }

    @SuppressWarnings("deprecation") // TODO inspect in packetevents, this arg should be ServerVersion?
    @Override
    public List<EntityData<?>> entityData(ClientVersion version) {
        List<EntityData<?>> resolved = new ArrayList<>(this.metadata.size());

        for (Map.Entry<EntityMetaField<?>, Object> entry : this.metadata.entrySet()) {
            @SuppressWarnings("unchecked")
            EntityMetaField<Object> field = (EntityMetaField<Object>) entry.getKey();
            EntityData<?> data = field.createData(version.toServerVersion(), entry.getValue());

            if (data != null) resolved.add(data);
        }

        resolved.sort(Comparator.comparingInt(EntityData::getIndex));
        return resolved;
    }

    @Override
    public String toString() {
        return "ProtocolEntityMeta{" +
                "data=" + this.metadata +
                '}';
    }

}
