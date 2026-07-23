package dev.threeadd.packetentities.entity.objectdata.type;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import dev.threeadd.packetentities.entity.objectdata.EntityRefObjectData;

public class ProjectileObjectData extends EntityRefObjectData {

    public ProjectileObjectData(int owningEntityId) {
        super(EntityTypes.PROJECTILE_ABSTRACT, owningEntityId);
    }

}
