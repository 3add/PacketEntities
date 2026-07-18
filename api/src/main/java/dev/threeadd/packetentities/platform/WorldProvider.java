package dev.threeadd.packetentities.platform;

import com.github.retrooper.packetevents.protocol.player.User;
import dev.threeadd.packetentities.world.ProtocolWorld;

public interface WorldProvider<T> {

    ProtocolWorld provide(User user);

    ProtocolWorld provide(T platformWorld);

    ProtocolWorld provideMainWorld();

}
