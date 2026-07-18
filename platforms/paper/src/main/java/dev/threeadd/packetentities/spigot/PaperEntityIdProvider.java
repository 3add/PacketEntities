package dev.threeadd.packetentities.spigot;

import dev.threeadd.packetentities.platform.EntityIdProvider;
import dev.threeadd.packetentities.world.ProtocolWorld;
import io.github.retrooper.packetevents.util.SpigotReflectionUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

public class PaperEntityIdProvider implements EntityIdProvider<Entity> {

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public int provide(ProtocolWorld world) {
        return SpigotReflectionUtil.generateEntityId(Bukkit.getWorld(world.getWorldName()));
    }

    @Override
    public int provide(Entity platformEntity) {
        return platformEntity.getEntityId();
    }

}
