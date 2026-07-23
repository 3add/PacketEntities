package dev.threeadd.packetentities.entity.meta.protocol.view.bitmask;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.field.ViewField;
import dev.threeadd.packetentities.entity.meta.protocol.view.EntityMetaView;

public abstract class BitmaskView extends EntityMetaView<Byte> {

    protected BitmaskView(ProtocolEntityMeta store, ViewField<Byte, ? extends BitmaskView> field) {
        super(store, field);
    }

    @Override
    protected Byte getDefaultValue() {
        return (byte) 0;
    }

    /**
     * Returns whether the bitmask is present in the current raw byte.
     *
     * @param mask the bitmask to check (e.g., 0x02)
     * @return {@code true} if the bitmask is present, {@code false} otherwise
     */
    protected final boolean hasMask(int mask) {
        assertMask(mask);
        return (getRaw() & mask) != 0;
    }

    /**
     * Sets or clears the bits defined by the mask.
     *
     * @param mask  the bitmask to modify
     * @param value {@code true} to set the bits, {@code false} to clear them
     */
    protected final void setMask(int mask, boolean value) {
        assertMask(mask);
        byte current = getRaw();
        byte updated = value ? (byte) (current | mask)
                : (byte) (current & ~mask);
        setRaw(updated);
    }

    private static void assertMask(int mask) {
        // ensures the mask doesn't exceed a single byte's capacity (0x00 - 0xFF)
        if ((mask & ~0xFF) != 0) {
            throw new IllegalArgumentException(
                    String.format("Mask must fit within a single byte (0x00 - 0xFF), got: 0x%02X", mask)
            );
        }
    }

}
