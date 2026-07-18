package dev.threeadd.packetentities.velocity;

import com.github.retrooper.packetevents.protocol.player.User;
import dev.threeadd.packetentities.platform.WorldProvider;
import dev.threeadd.packetentities.world.ProtocolWorld;

public class VelocityWorldProvider implements WorldProvider<Object> {

    private final VelocityWorldTracker tracker;

    public VelocityWorldProvider(VelocityWorldTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public ProtocolWorld provide(User user) {
        return this.tracker.getWorld(user);
    }

    @Override
    public ProtocolWorld provide(Object platformWorld) {
        throw new UnsupportedOperationException("No platform world on velocity.");
    }

    @Override
    public ProtocolWorld provideMainWorld() {
        throw new UnsupportedOperationException("No main world on velocity.");
    }

}
