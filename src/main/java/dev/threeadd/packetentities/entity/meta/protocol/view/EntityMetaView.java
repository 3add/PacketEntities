package dev.threeadd.packetentities.entity.meta.protocol.view;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.field.ViewField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A wrapper for a single {@link ViewField}'s value stored on {@link ProtocolEntityMeta},
 * extending "view" wrapper classes can get/set data using {@link #getRaw()} and {@link #setRaw(Object)}
 *
 * <p>A default {@link NotNull} value should be provided using {@link #getDefaultValue()}</p>
 *
 * @param <T> the raw type of the metadata field value
 */
public abstract class EntityMetaView<T> {

    private final ProtocolEntityMeta store;
    private final ViewField<T, ? extends EntityMetaView<T>> field;

    protected EntityMetaView(ProtocolEntityMeta store, ViewField<T, ? extends EntityMetaView<T>> field) {
        this.store = store;
        this.field = field;
    }

    /**
     * @return the underlying value this view wrapper represents
     */
    public final T getRaw() {
        T value = this.store.getRaw(this.field);
        return value != null ? value : getDefaultValue();
    }

    /**
     * Sets the underlying value this view wrapper represents
     * @param raw the raw value to set
     */
    public final void setRaw(T raw) {
        this.store.setRaw(this.field, raw);
    }

    public @Nullable EntityData<?> toEntityData(ServerVersion version) {
        return this.field.createData(version, getRaw());
    }

    protected abstract T getDefaultValue();

    protected final ProtocolEntityMeta getStore() {
        return this.store;
    }

    protected final ViewField<T, ? extends EntityMetaView<T>> getField() {
        return this.field;
    }

}
