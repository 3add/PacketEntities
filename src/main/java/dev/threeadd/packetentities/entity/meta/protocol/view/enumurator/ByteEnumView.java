package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.field.ViewField;

/**
 * Represents a {@link EnumView} whose {@link ProtocolEnum#getProtocolValue()} is serialized as a byte
 */
public class ByteEnumView<E extends Enum<E> & ProtocolEnum> extends EnumView<E, Byte> {

    public ByteEnumView(ProtocolEntityMeta store, ViewField<Byte, ? extends EnumView<E, Byte>> key, Class<E> enumType, E defaultValue) {
        super(store, key, enumType, defaultValue);
    }

    @Override
    protected int toInt(Byte raw) {
        return raw.intValue() & 0xFF;
    }

    @Override
    protected Byte fromInt(int protocolValue) {
        if (protocolValue < -128 || protocolValue > 255) { // both unsigned and signed supported
            throw new IllegalArgumentException("Protocol value " + protocolValue + " out of valid byte range");
        }
        return (byte) protocolValue;
    }

}
