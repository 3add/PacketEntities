package dev.threeadd.packetentities.meta.protocol.enums;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.field.ViewField;

/**
 * Represents a {@link EnumView} whose {@link ProtocolEnum#getProtocolValue()} is serialized as varint
 */
public class VarIntEnumView<E extends Enum<E> & ProtocolEnum> extends EnumView<E, Integer> {

    public VarIntEnumView(ProtocolEntityMeta store, ViewField<Integer, ? extends EnumView<E, Integer>> key, Class<E> enumClass, E defaultValue) {
        super(store, key, enumClass, defaultValue);
    }

    @Override
    protected int toInt(Integer raw) {
        return raw;
    }

    @Override
    protected Integer fromInt(int protocolValue) {
        return protocolValue;
    }

}
