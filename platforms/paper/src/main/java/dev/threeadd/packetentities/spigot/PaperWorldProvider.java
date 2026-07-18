package dev.threeadd.packetentities.spigot;

import com.github.retrooper.packetevents.protocol.player.User;
import dev.threeadd.packetentities.platform.WorldProvider;
import dev.threeadd.packetentities.world.ProtocolWorld;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PaperWorldProvider implements WorldProvider<World> {

    @Override
    public ProtocolWorld provide(User user) {
        Player player = Bukkit.getPlayer(user.getUUID());
        if (player == null) throw new IllegalStateException("Couldn't get player from packet events user " + user.getUUID());
        return ProtocolWorld.of(player.getWorld().getName());
    }

    @Override
    public ProtocolWorld provide(World platformWorld) {
        return ProtocolWorld.of(platformWorld.getName());
    }

    @Override
    public ProtocolWorld provideMainWorld() {
        return ProtocolWorld.of(Bukkit.getWorlds().get(0).getName());
    }

}

