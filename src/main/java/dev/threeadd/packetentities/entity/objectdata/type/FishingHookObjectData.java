package dev.threeadd.packetentities.entity.objectdata.type;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import dev.threeadd.packetentities.entity.objectdata.EntityRefObjectData;

public class FishingHookObjectData extends EntityRefObjectData {

    public FishingHookObjectData(int owningEntityId) {
        super(EntityTypes.FISHING_BOBBER, owningEntityId);
    }

}
