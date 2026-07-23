package dev.threeadd.packetentities.entity.objectdata;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;

/**
 * Represent an {@link ProtocolObjectData} where the object data {@code int} is
 * referencing an existing entity (and thus returns that entity's entity id)
 */
public abstract class EntityRefObjectData implements ProtocolObjectData {

    private final EntityType boundEntityType;
    private final int objectData;

    public EntityRefObjectData(EntityType boundEntityType, int entityId) {
        this.boundEntityType = boundEntityType;
        this.objectData = entityId;
    }

    @Override
    public int getObjectData(ServerVersion version) {
        return this.objectData;
    }

    @Override
    public EntityType getBoundEntityType() {
        return this.boundEntityType;
    }

}
