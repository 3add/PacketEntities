package dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.BitmaskView;

/**
 * Represents {@link EntityMetaFields.Bat#FLAGS}
 */
public class BatFlagsView extends BitmaskView {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Bat
    private static final int MASK_IS_HANGING = 0x01;
    // rest is unused, nice and efficient mojang

    public BatFlagsView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Bat.FLAGS);
    }

    public boolean isHanging() {
        return hasMask(MASK_IS_HANGING);
    }

    public void setHanging(boolean hanging) {
        setMask(MASK_IS_HANGING, hanging);
    }

}
