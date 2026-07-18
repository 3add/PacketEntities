package dev.threeadd.packetentities.meta.protocol.bitmask.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.bitmask.BitmaskView;

/**
 * Represents {@link EntityMetaFields.ArmorStand#CLIENT_FLAGS}
 */
public class ArmorStandClientFlagsView extends BitmaskView {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Armor_Stand
    private static final int MASK_IS_SMALL = 0x01;
    // 0x02 unused
    private static final int MASK_HAS_ARMS = 0x04;
    private static final int MASK_HAS_NO_BASEPLATE = 0x08;
    private static final int MASK_IS_MARKER = 0x10;
    // rest unused

    public ArmorStandClientFlagsView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.ArmorStand.CLIENT_FLAGS);
    }

    public boolean isSmall() {
        return hasMask(MASK_IS_SMALL);
    }

    public void setIsSmall(boolean value) {
        setMask(MASK_IS_SMALL, value);
    }

    public boolean hasArms() {
        return hasMask(MASK_HAS_ARMS);
    }

    public void setHasArms(boolean value) {
        setMask(MASK_HAS_ARMS, value);
    }

    public boolean hasBasePlate() {
        return !hasMask(MASK_HAS_NO_BASEPLATE);
    }

    public void setHasBasePlate(boolean value) {
        setMask(MASK_HAS_NO_BASEPLATE, !value);
    }

    public boolean isMarker() {
        return hasMask(MASK_IS_MARKER);
    }

    public void setIsMarker(boolean value) {
        setMask(MASK_IS_MARKER, value);
    }

}
