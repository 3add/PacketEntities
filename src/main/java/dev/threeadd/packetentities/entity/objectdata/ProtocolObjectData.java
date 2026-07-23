package dev.threeadd.packetentities.entity.objectdata;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;

/*
 this is an interface because enums can't extend abstract classes
 I already changed this to an abstract class 2 times during development lol, don't change again.
 */
public interface ProtocolObjectData {

    ProtocolObjectData EMPTY = new ProtocolObjectData() {

        @Override
        public int getObjectData(ServerVersion version) {
            return 0;
        }

        @Override
        public EntityType getBoundEntityType() {
            return EntityTypes.ENTITY;
        }

    };

    int getObjectData(ServerVersion version);

    EntityType getBoundEntityType();

}
