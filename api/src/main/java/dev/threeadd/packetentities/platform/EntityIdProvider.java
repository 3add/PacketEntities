package dev.threeadd.packetentities.platform;

import dev.threeadd.packetentities.world.ProtocolWorld;

public interface EntityIdProvider<T> {

    int provide(ProtocolWorld world);

    int provide(T platformEntity);

}
