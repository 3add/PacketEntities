package dev.threeadd.packetentities.velocity;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.event.UserDisconnectEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerJoinGame;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerRespawn;
import dev.threeadd.packetentities.world.ProtocolWorld;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class VelocityWorldTracker extends PacketListenerAbstract {

    private final Map<User, ProtocolWorld> userWorlds = new ConcurrentHashMap<>();

    @Override
    public void onPacketSend(PacketSendEvent event) {
        User user = event.getUser();

        if (event.getPacketType() == PacketType.Play.Server.JOIN_GAME) {
            WrapperPlayServerJoinGame joinGame = new WrapperPlayServerJoinGame(event);

            String worldName = joinGame.getWorldName();

            this.userWorlds.put(user, ProtocolWorld.of(worldName));

        } else if (event.getPacketType() == PacketType.Play.Server.RESPAWN) {
            WrapperPlayServerRespawn respawn = new WrapperPlayServerRespawn(event);

            Optional<String> worldName = respawn.getWorldName();

            // if the worldName is empty the world didn't change
            worldName.ifPresent(string -> this.userWorlds.put(user, ProtocolWorld.of(string)));
        }
    }

    @Override
    public void onUserDisconnect(UserDisconnectEvent event) {
        this.userWorlds.remove(event.getUser());
    }

    public ProtocolWorld getWorld(User user) {
        return this.userWorlds.get(user);
    }

}
