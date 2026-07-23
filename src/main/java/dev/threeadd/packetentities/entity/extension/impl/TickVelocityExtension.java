package dev.threeadd.packetentities.entity.extension.impl;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3f;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.entity.event.EntityTickEvent;
import dev.threeadd.packetentities.entity.extension.EntityExtension;
import org.jetbrains.annotations.UnknownNullability;

/**
 * An extension to manage velocity of an entity by applying drag every tick.
 * The velocity has to be set using {@link ProtocolEntity#setVelocity(Vector3d)}, after that this extension
 * will keep sending the future position of the entity to clients, applying drag to the velocity value until it's 0.
 */
public class TickVelocityExtension implements EntityExtension {

    private @UnknownNullability ProtocolEntity owner;
    private Vector3f drag;

    public TickVelocityExtension() {
        this(new Vector3f(0.91F, 0.98F, 0.91F));
    }

    /**
     * Creates a new velocity extension that manages velocity.
     *
     * @param drag                The drag of the velocity (xDrag, yDrag, zDrag)
     *                            the drag is the amount of momentum a coordinate loses every tick
     */
    public TickVelocityExtension(Vector3f drag) {
        this.drag = drag;
    }

    public TickVelocityExtension drag(Vector3f drag) {
        this.drag = drag;
        return this;
    }

    @Override
    public void onAttach(ProtocolEntity entity) {
        this.owner = entity;

        if (!entity.hasExtension(TickExtension.class)) {
            throw new IllegalStateException("Tried attaching tick velocity extension with tick extension.");
        }

        entity.getEventBus().on(EntityTickEvent.class, event -> tick());
    }

    private void tick() {
        if (this.owner == null || !this.owner.isSpawned()) return;

        Vector3d velocity = this.owner.getVelocity();
        if (velocity.getX() == 0 && velocity.getY() == 0 && velocity.getZ() == 0) {
            return;
        }

        Location currentLoc = this.owner.getLocation();
        Location newLoc = new Location(
                currentLoc.getPosition().add(velocity),
                currentLoc.getYaw(), currentLoc.getPitch()
        );

        this.owner.teleport(newLoc);

        double newX = velocity.getX() * this.drag.getX();
        double newY = velocity.getY() * this.drag.getY();
        double newZ = velocity.getZ() * this.drag.getZ();

        this.owner.setVelocity(new Vector3d(newX, newY, newZ));
    }

}
