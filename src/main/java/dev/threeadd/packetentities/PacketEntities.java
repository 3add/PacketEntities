package dev.threeadd.packetentities;

import dev.threeadd.packetentities.platform.Platform;
import org.jetbrains.annotations.Nullable;

public class PacketEntities {

    private static @Nullable Platform platform;

    private PacketEntities() {
    }

    public static void enable(Platform platform) {
        if (PacketEntities.platform != null) {
            throw new IllegalStateException("PacketEntities is already initialized!");
        }

        PacketEntities.platform = platform;
    }

    public static void disable() {
        if (platform == null) {
            throw new IllegalStateException("PacketEntities has not been initialized");
        }
        platform.getAPI().getEntityManager().destroy();
        platform = null;
    }

    public static PacketEntitiesAPI getAPI() {
        if (platform == null) {
            throw new IllegalStateException("PacketEntities has not been initialized");
        }
        return platform.getAPI();
    }

    public static Platform getPlatform() {
        if (platform == null) {
            throw new IllegalStateException("PacketEntities has not been initialized");
        }
        return platform;
    }

}
