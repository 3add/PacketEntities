package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator;

/**
 * Represents an enum that is used in the minecraft protocol,
 * the value (which is not always ordinal) serialized will always be a varint or a byte.
 *
 * @see ChronologicalProtocolEnum
 * @see EnumView
 */
public interface ProtocolEnum {

    /**
     * @return the protocol value used by the protocol for this enum constant (most likely but not always {@link Enum#ordinal()}).
     */
    int getProtocolValue();

}
