package dev.threeadd.packetentities.spigot;

import dev.threeadd.packetentities.PacketEntitiesAPI;
import dev.threeadd.packetentities.platform.Platform;
import dev.threeadd.packetentities.setting.PacketEntitiesAPISettings;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PaperPacketEntitiesPlatform implements Platform {

    private final Logger logger;
    private final dev.threeadd.packetentities.platform.EntityIdProvider<Entity> entityIdProvider;
    private final dev.threeadd.packetentities.platform.WorldProvider<World> worldProvider;
    private final dev.threeadd.packetentities.platform.TaskScheduler taskScheduler;
    private final PacketEntitiesAPI api;

    public PaperPacketEntitiesPlatform(JavaPlugin plugin, PacketEntitiesAPISettings settings) {
        this.logger = plugin.getLogger();
        this.entityIdProvider = new PaperEntityIdProvider();
        this.worldProvider = new PaperWorldProvider();
        this.taskScheduler = new PaperTaskScheduler(plugin);
        this.api = new PacketEntitiesAPI(settings);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public dev.threeadd.packetentities.platform.EntityIdProvider<Entity> getEntityIdProvider() {
        return this.entityIdProvider;
    }

    @Override
    public dev.threeadd.packetentities.platform.WorldProvider<World> getWorldProvider() {
        return this.worldProvider;
    }

    @Override
    public dev.threeadd.packetentities.platform.TaskScheduler getTaskScheduler() {
        return this.taskScheduler;
    }

    @Override
    public PacketEntitiesAPI getAPI() {
        return this.api;
    }

}
