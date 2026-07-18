package dev.threeadd.packetentities.meta.protocol.bitmask.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.bitmask.BitmaskView;

/**
 * Represents {@link EntityMetaFields.Bee#FLAGS}
 */
public class BeeFlagsView extends BitmaskView {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Bee
    // 0x01 unused
    private static final int MASK_IS_ANGRY = 0x02;
    private static final int MASK_HAS_STUNG = 0x04;
    private static final int MASK_HAS_NECTAR = 0x08;
    // rest unused

    public BeeFlagsView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Bee.FLAGS);
    }

    public boolean isAngry() {
        return hasMask(MASK_IS_ANGRY);
    }

    public void setAngry(boolean value) {
        setMask(MASK_IS_ANGRY, value);
    }

    public boolean hasStung() {
        return hasMask(MASK_HAS_STUNG);
    }

    public void setStung(boolean value) {
        setMask(MASK_HAS_STUNG, value);
    }

    public boolean hasNectar() {
        return hasMask(MASK_HAS_NECTAR);
    }

    public void setNectar(boolean value) {
        setMask(MASK_HAS_NECTAR, value);
    }

}
