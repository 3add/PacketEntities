package dev.threeadd.packetentities.entity.data;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;

public enum WardenProtocolObjectData implements ProtocolObjectData {
    NONE(0),
    EMERGING_POSE(1);

    private final int objectData;

    WardenProtocolObjectData(int objectData) {
        this.objectData = objectData;
    }

    @Override
    public int getObjectData(ClientVersion version) {
        return this.objectData;
    }

    @Override
    public EntityType getBoundEntityType() {
        return EntityTypes.WARDEN;
    }

}
