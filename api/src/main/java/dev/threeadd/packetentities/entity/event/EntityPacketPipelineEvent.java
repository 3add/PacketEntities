package dev.threeadd.packetentities.entity.event;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import dev.threeadd.packetentities.event.CancellableEvent;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class EntityPacketPipelineEvent extends CancellableEvent {

    private final List<PacketWrapper<?>> packets;

    protected EntityPacketPipelineEvent(List<PacketWrapper<?>> defaultPackets) {
        this.packets = new ArrayList<>(defaultPackets);
    }

    /**
     * @return the packets involved in this pipeline event as an unmodifiable list
     * @see #addPacketFirst(PacketWrapper)
     * @see #addPacketLast(PacketWrapper)
     */
    public @UnmodifiableView List<PacketWrapper<?>> packets() {
        return Collections.unmodifiableList(this.packets);
    }

    /**
     * Adds a packet at the beginning of the pipeline.
     * This means it will be sent before all other current packets in the list.
     *
     * @param packet the packet to add to the start of the list
     * @return this event for chaining
     */
    public EntityPacketPipelineEvent addPacketFirst(PacketWrapper<?> packet) {
        this.packets.addFirst(packet);
        return this;
    }

    /**
     * Adds a packet at the end of the pipeline.
     * This means it will be sent after all other current packets in the list.
     *
     * @param packet the packet to add to the end
     * @return this event for chaining
     */
    public EntityPacketPipelineEvent addPacketLast(PacketWrapper<?> packet) {
        this.packets.add(packet);
        return this;
    }

}
