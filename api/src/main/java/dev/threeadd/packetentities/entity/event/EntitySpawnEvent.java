package dev.threeadd.packetentities.entity.event;

import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.event.CancellableEvent;

/**
 * Called when a {@link ProtocolEntity} is spawned,
 * to intercept the packet line look at {@link ViewerShowEntityEvent}
 */
public class EntitySpawnEvent extends CancellableEvent {

    public EntitySpawnEvent() {
        super();
    }

}
