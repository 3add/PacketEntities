package dev.threeadd.packetentities.entity.data;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;

public interface ProtocolObjectData {

    int getObjectData(ClientVersion version);

    EntityType getBoundEntityType();

}
