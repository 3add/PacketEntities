package dev.threeadd.packetentities.entity.objectdata.type;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import dev.threeadd.packetentities.entity.objectdata.ProtocolObjectData;

public enum WardenObjectData implements ProtocolObjectData {
    NONE(0),
    EMERGING_POSE(1);

    private final int objectData;

    WardenObjectData(int objectData) {
        this.objectData = objectData;
    }

    @Override
    public int getObjectData(ServerVersion version) {
        return this.objectData;
    }

    @Override
    public EntityType getBoundEntityType() {
        return EntityTypes.WARDEN;
    }

}
