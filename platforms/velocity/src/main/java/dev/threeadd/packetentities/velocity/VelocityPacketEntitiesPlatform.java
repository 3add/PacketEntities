package dev.threeadd.packetentities.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
import dev.threeadd.packetentities.PacketEntitiesAPI;
import dev.threeadd.packetentities.platform.EntityIdProvider;
import dev.threeadd.packetentities.platform.Platform;
import dev.threeadd.packetentities.platform.TaskScheduler;
import dev.threeadd.packetentities.platform.WorldProvider;
import dev.threeadd.packetentities.setting.PacketEntitiesAPISettings;

import java.util.logging.Logger;

public class VelocityPacketEntitiesPlatform implements Platform {

    private final EntityIdProvider<?> entityIdProvider;
    private final WorldProvider<?> worldProvider;
    private final TaskScheduler taskScheduler;
    private final PacketEntitiesAPI api;

    public VelocityPacketEntitiesPlatform(ProxyServer server, Object plugin, PacketEntitiesAPISettings settings) {
        this.entityIdProvider = new VelocityEntityIdProvider();
        this.worldProvider = new VelocityWorldProvider(new VelocityWorldTracker());
        this.taskScheduler = new VelocityTaskScheduler(server, plugin);
        this.api = new PacketEntitiesAPI(settings);
    }

    @Override
    public Logger getLogger() {
        return Logger.getLogger("VelocityPacketEntities");
    }

    @Override
    public EntityIdProvider<?> getEntityIdProvider() {
        return this.entityIdProvider;
    }

    @Override
    public WorldProvider<?> getWorldProvider() {
        return this.worldProvider;
    }

    @Override
    public TaskScheduler getTaskScheduler() {
        return this.taskScheduler;
    }

    @Override
    public PacketEntitiesAPI getAPI() {
        return this.api;
    }

}
