package dev.threeadd.packetentities.meta.protocol.bitmask.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.bitmask.BitmaskView;

/**
 * Represents {@link EntityMetaFields.Vex#FLAGS}
 */
public class VexFlagsView extends BitmaskView {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Vex
    private static final int MASK_IS_ATTACKING = 0x01;
    // rest is unused, nice efficiency mojang

    public VexFlagsView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Vex.FLAGS);
    }

    public boolean isAttacking() {
        return hasMask(MASK_IS_ATTACKING);
    }

    public void setAttacking(boolean value) {
        setMask(MASK_IS_ATTACKING, value);
    }

}
