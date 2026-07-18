package dev.threeadd.packetentities.util;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import dev.threeadd.packetentities.PacketEntities;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public final class PacketDispatcher {

    private PacketDispatcher() {
    }

    /**
     * Sends a packet to the given player, if they are online and have a valid channel.
     * Does nothing if the wrapper is {@code null}.
     *
     * @param userId the user to send to
     * @param wrapper the packet
     */
    @SuppressWarnings("ConstantConditions")
    public static void sendPacket(UUID userId, @Nullable PacketWrapper<?> wrapper) {
        if (wrapper == null) return;

        // O(1) according to https://github.com/retrooper/packetevents/blob/3df6015486def869588e86653c29d0f9b63bddd7/api/src/main/java/com/github/retrooper/packetevents/manager/protocol/ProtocolManager.java#L38
        Object channel = PacketEvents.getAPI().getProtocolManager().getChannel(userId);
        if (channel == null) {
            PacketEntities.getPlatform().getLogger().warning("Failed to send packet to " + userId + " because the channel was null. They may be disconnected/not online.");
            return;
        }

        PacketEvents.getAPI().getProtocolManager().sendPacket(channel, wrapper);
    }

}
