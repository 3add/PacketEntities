package dev.threeadd.packetentities.entity.event;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import dev.threeadd.packetentities.entity.ProtocolEntity;

import java.util.List;
import java.util.UUID;

/**
 * Called when a viewer is added to a spawned {@link ProtocolEntity}
 * This is also called when a viewer that unloaded an entity reloads an entity and should be resynced.
 */
public class ViewerShowEntityEvent extends EntityPacketPipelineEvent {

    private final UUID viewer;
    private final boolean isLoad;

    public ViewerShowEntityEvent(List<PacketWrapper<?>> packets, UUID viewer, boolean isLoad) {
        super(packets);
        this.viewer = viewer;
        this.isLoad = isLoad;
    }

    public UUID viewer() {
        return this.viewer;
    }

    public boolean isLoad() {
        return this.isLoad;
    }

}
