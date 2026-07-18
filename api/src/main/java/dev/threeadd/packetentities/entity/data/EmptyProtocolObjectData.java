package dev.threeadd.packetentities.entity.data;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;

public class EmptyProtocolObjectData implements ProtocolObjectData {

    @Override
    public int getObjectData(ClientVersion version) {
        return 0;
    }

    @Override
    public EntityType getBoundEntityType() {
        return EntityTypes.ENTITY;
    }

}
