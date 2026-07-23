package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator;

import com.github.retrooper.packetevents.PacketEvents;
import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.field.ViewField;
import dev.threeadd.packetentities.entity.meta.protocol.view.EntityMetaView;

/**
 * A {@link EntityMetaView} that represents a {@link ProtocolEnum},
 * 2 inherits implementing both serialization methods (varint and byte)
 *
 * @see ByteEnumView
 * @see VarIntEnumView
 */
public abstract class EnumView<E extends Enum<E> & ProtocolEnum, T extends Number> extends EntityMetaView<T> {

    private final E[] enumConstants;
    private final E defaultValue;

    protected EnumView(ProtocolEntityMeta store, ViewField<T, ? extends EnumView<E, T>> key, Class<E> enumType, E defaultValue) {
        super(store, key);
        this.enumConstants = enumType.getEnumConstants();
        this.defaultValue = defaultValue;
    }

    @Override
    protected final T getDefaultValue() {
        return fromInt(this.defaultValue.getProtocolValue());
    }

    /**
     * Gets the constant in this wrapper or the default if no value present
     *
     * @return the current stored enum constant
     * @throws IllegalStateException if no enum can be mapped on this protocol version,
     * if this happens on the latest protocol version, please report it as a bug.
     */
    public E get() {
        T raw = getRaw();
        int protocolValue = toInt(raw);

        for (E constant : this.enumConstants) {
            if (constant.getProtocolValue() == protocolValue) {
                return constant;
            }
        }

        throw new IllegalStateException("Failed to find protocol enum with value " + protocolValue + " on version server protocol "
                + PacketEvents.getAPI().getServerManager().getVersion().getProtocolVersion());
    }

    /**
     * Sets the enum constant in this wrapper
     *
     * @param value the new value
     * @return this view for chaining
     */
    public EnumView<E, T> set(E value) {
        setRaw(fromInt(value.getProtocolValue()));
        return this;
    }

    /**
     * Converts the raw metadata type (byte or varint) to {@link ProtocolEnum#getProtocolValue()}.
     *
     * @param raw the raw value (already int or byte) to convert to int
     * @return the converted int
     */
    protected abstract int toInt(T raw);

    /**
     * Converts {@link ProtocolEnum#getProtocolValue()} to the raw metadata type (byte or varint).
     *
     * @param protocolValue the value to convert
     * @return the raw metadata type (as a byte or varint)
     */
    protected abstract T fromInt(int protocolValue);

}
