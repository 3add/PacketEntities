package dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.BitmaskView;

/**
 * Represents {@link EntityMetaFields.Blaze#FLAGS}
 */
public class BlazeFlagsView extends BitmaskView {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Blaze
    private static final int MASK_IS_ON_FIRE = 0x01;
    // rest is unused, nice and efficient mojang

    public BlazeFlagsView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Blaze.FLAGS);
    }

    public boolean isOnFire() {
        return hasMask(MASK_IS_ON_FIRE);
    }

    public void setOnFire(boolean onFire) {
        setMask(MASK_IS_ON_FIRE, onFire);
    }

}
