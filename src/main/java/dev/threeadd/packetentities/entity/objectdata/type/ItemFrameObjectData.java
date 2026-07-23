package dev.threeadd.packetentities.entity.objectdata.type;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import dev.threeadd.packetentities.entity.objectdata.ProtocolObjectData;

public enum ItemFrameObjectData implements ProtocolObjectData {
    DOWN(0),
    UP(1),
    NORTH(2),
    SOUTH(3),
    WEST(4),
    EAST(5);

    private final int objectData;

    ItemFrameObjectData(int objectData) {
        this.objectData = objectData;
    }

    @Override
    public int getObjectData(ServerVersion version) {
        return this.objectData;
    }

    @Override
    public EntityType getBoundEntityType() {
        return EntityTypes.ITEM_FRAME;
    }

}
