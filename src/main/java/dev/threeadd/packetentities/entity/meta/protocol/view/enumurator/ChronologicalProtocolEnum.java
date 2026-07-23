package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator;

/**
 * Represents a {@link ProtocolEnum} where the protocol value is just {@link Enum#ordinal()}
 */
public interface ChronologicalProtocolEnum extends ProtocolEnum {

    @Override
    default int getProtocolValue() {
        return ((Enum<?>) this).ordinal();
    }

}
