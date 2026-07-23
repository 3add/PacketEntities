package dev.threeadd.packetentities.entity.event;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import dev.threeadd.packetentities.entity.ProtocolEntity;

import java.util.List;
import java.util.UUID;

/**
 * Called when a viewer is removed from a spawned {@link ProtocolEntity},
 * this is also called when a viewer unloads an entity.
 * (though it will sync on load unless removed manually, see {@link ViewerShowEntityEvent})
 * Cancelling this event is not recommended when {@link #isUnload()} is true because it can cause memory leaks.
 */
public class ViewerHideEntityEvent extends EntityPacketPipelineEvent {

    private final UUID viewer;
    private final boolean isUnload;

    public ViewerHideEntityEvent(List<PacketWrapper<?>> packets, UUID viewer, boolean isUnload) {
        super(packets);
        this.viewer = viewer;
        this.isUnload = isUnload;
    }

    public UUID viewer() {
        return this.viewer;
    }

    public boolean isUnload() {
        return this.isUnload;
    }

}
