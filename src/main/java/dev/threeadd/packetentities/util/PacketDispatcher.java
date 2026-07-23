package dev.threeadd.packetentities.util;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import dev.threeadd.packetentities.PacketEntities;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public final class PacketDispatcher {

    private PacketDispatcher() {
    }

    public static void sendPackets(@Nullable UUID userId, @Nullable Collection<@Nullable PacketWrapper<?>> packets) {
        if (packets == null) return;
        sendPackets(userId, packets.toArray(new PacketWrapper[0]));
    }

    /**
     * Sends a packet to the given player, if they are online and have a valid channel.
     * Does nothing if any of the arguments are {@code null} or the length of the packet array is {@code 0}.
     *
     * @param userId the user to send to
     * @param packets the packets to send
     */
    @SuppressWarnings("ConstantConditions")
    public static void sendPackets(@Nullable UUID userId, @Nullable PacketWrapper<?>... packets) {
        if (userId == null | packets == null || packets.length == 0) return;

        // O(1) according to https://github.com/retrooper/packetevents/blob/3df6015486def869588e86653c29d0f9b63bddd7/api/src/main/java/com/github/retrooper/packetevents/manager/protocol/ProtocolManager.java#L38
        @Nullable Object channel = PacketEvents.getAPI().getProtocolManager().getChannel(userId);
        if (channel == null) {
            PacketEntities.getPlatform().getLogger().warning("Failed to send packet to " + userId + " because the channel was null. They may be disconnected/not online.");
            return;
        }

        for (@Nullable PacketWrapper<?> packet : packets) {
            if (packet == null) continue;
            PacketEvents.getAPI().getProtocolManager().sendPacket(channel, packet);
        }
    }

}
