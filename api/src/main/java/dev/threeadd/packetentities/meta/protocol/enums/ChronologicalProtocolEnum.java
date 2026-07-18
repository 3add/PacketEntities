package dev.threeadd.packetentities.meta.protocol.enums;

/**
 * Represents a {@link ProtocolEnum} where the protocol value is just {@link Enum#ordinal()}
 */
public interface ChronologicalProtocolEnum extends ProtocolEnum {

    @Override
    default int getProtocolValue() {
        return ((Enum<?>) this).ordinal();
    }

}
