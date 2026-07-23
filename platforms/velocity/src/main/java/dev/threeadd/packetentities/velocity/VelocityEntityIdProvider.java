package dev.threeadd.packetentities.velocity;

import dev.threeadd.packetentities.platform.EntityIdProvider;
import dev.threeadd.packetentities.world.ProtocolWorld;

import java.util.concurrent.atomic.AtomicInteger;

public class VelocityEntityIdProvider implements EntityIdProvider<Object> {

    // start high to avoid conflicts with backends
    private static final AtomicInteger nextId = new AtomicInteger(100000);

    @Override
    public int provide(ProtocolWorld ignored) {
        return nextId.getAndIncrement();
    }

    @Override
    public int provide(Object platformEntity) {
        throw new UnsupportedOperationException("No platform entity tracking on velocity");
    }

}
