package dev.threeadd.packetentities.entity.data;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;

public enum ItemFrameProtocolObjectData implements ProtocolObjectData {
    DOWN(0),
    UP(1),
    NORTH(2),
    SOUTH(3),
    WEST(4),
    EAST(5);

    private final int objectData;

    ItemFrameProtocolObjectData(int objectData) {
        this.objectData = objectData;
    }

    @Override
    public int getObjectData(ClientVersion version) {
        return this.objectData;
    }

    @Override
    public EntityType getBoundEntityType() {
        return EntityTypes.ITEM_FRAME;
    }

}
