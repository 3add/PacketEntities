package dev.threeadd.packetentities.entity.data;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;

public class FishingHookProtocolObjectData extends OwnedEntityProtocolObjectData {

    public FishingHookProtocolObjectData(int owningEntityId) {
        super(EntityTypes.FISHING_BOBBER, owningEntityId);
    }

}
