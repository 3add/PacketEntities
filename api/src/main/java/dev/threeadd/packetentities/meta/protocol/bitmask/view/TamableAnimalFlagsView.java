package dev.threeadd.packetentities.meta.protocol.bitmask.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.bitmask.BitmaskView;

/**
 * Represents {@link EntityMetaFields.TamableAnimal#FLAGS}
 */
public class TamableAnimalFlagsView extends BitmaskView {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Tameable_Animal
    private static final int MASK_IS_SITTING = 0x01;
    // 0x02 unused
    private static final int MASK_IS_TAMED = 0x04;

    public TamableAnimalFlagsView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.TamableAnimal.FLAGS);
    }

    /**
     * @return {@code true} if the entity is sitting.
     */
    public boolean isSitting() {
        return hasMask(MASK_IS_SITTING);
    }

    /**
     * @param value the new sitting value for the entity.
     */
    public void setSitting(boolean value) {
        setMask(MASK_IS_SITTING, value);
    }

    /**
     * @return {@code true} if the entity is tamed.
     */
    public boolean isTamed() {
        return hasMask(MASK_IS_TAMED);
    }

    /**
     * @param value the new tamed value for the entity.
     */
    public void setTamed(boolean value) {
        setMask(MASK_IS_TAMED, value);
    }


}
