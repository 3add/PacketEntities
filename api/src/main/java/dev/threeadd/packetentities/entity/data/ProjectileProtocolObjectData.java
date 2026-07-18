package dev.threeadd.packetentities.entity.data;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;

public class ProjectileProtocolObjectData extends OwnedEntityProtocolObjectData {

    public ProjectileProtocolObjectData(int owningEntityId) {
        super(EntityTypes.PROJECTILE_ABSTRACT, owningEntityId);
    }

}
