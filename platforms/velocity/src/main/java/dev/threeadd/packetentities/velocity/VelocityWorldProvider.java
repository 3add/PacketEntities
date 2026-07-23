package dev.threeadd.packetentities.velocity;

import com.github.retrooper.packetevents.protocol.player.User;
import dev.threeadd.packetentities.platform.WorldProvider;
import dev.threeadd.packetentities.world.ProtocolWorld;

/**
 * The velocity world provider represents worlds using their names,
 * as velocity does not have a concept of a world object.
 * The main world provider will throw {@link UnsupportedOperationException} because multiple servers means multiple main worlds.
 */
public class VelocityWorldProvider implements WorldProvider<String> {

    private final VelocityWorldTracker tracker;

    public VelocityWorldProvider(VelocityWorldTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public ProtocolWorld provide(User user) {
        return this.tracker.getWorld(user);
    }

    @Override
    public ProtocolWorld provide(String platformWorld) {
        return ProtocolWorld.of(platformWorld);
    }

    @Override
    public ProtocolWorld provideMainWorld() {
        throw new UnsupportedOperationException("No main world on velocity.");
    }

}
