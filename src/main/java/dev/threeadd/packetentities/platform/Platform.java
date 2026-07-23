package dev.threeadd.packetentities.platform;

import dev.threeadd.packetentities.PacketEntitiesAPI;

import java.util.logging.Logger;

public interface Platform {

    Logger getLogger();

    EntityIdProvider<?> getEntityIdProvider();

    WorldProvider<?> getWorldProvider();

    TaskScheduler getTaskScheduler();

    PacketEntitiesAPI getAPI();

}
