package dev.threeadd.packetentities.entity.extension.impl;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSetPassengers;
import dev.threeadd.packetentities.PacketEntities;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.entity.event.EntityDespawnEvent;
import dev.threeadd.packetentities.entity.event.EntitySpawnEvent;
import dev.threeadd.packetentities.entity.event.ViewerShowEntityEvent;
import dev.threeadd.packetentities.entity.extension.EntityExtension;
import dev.threeadd.packetentities.util.PacketDispatcher;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * An {@link EntityExtension} adding passenger wrapping for entities.
 */
public class PassengerExtension implements EntityExtension {

    private final Set<Integer> passengers = ConcurrentHashMap.newKeySet();
    private @Nullable ProtocolEntity entity;
    private @Nullable Location preRidingLocation;
    private int riding = -1;

    @Override
    public void onAttach(ProtocolEntity entity) {
        this.entity = entity;

        entity.getEventBus().on(EntitySpawnEvent.class, this::handleSpawn)
                .on(ViewerShowEntityEvent.class, this::handleAddViewer)
                .on(EntityDespawnEvent.class, this::handleDespawn);
    }

    private void handleSpawn(EntitySpawnEvent event) {
        if (this.entity == null) return;

        if (!this.passengers.isEmpty()) {
            WrapperPlayServerSetPassengers passengerPacket = createPassengerPacket();
            if (passengerPacket != null) {
                this.entity.sendPacketsToViewers(passengerPacket);
            }
        }

        if (this.riding == -1) return;

        ProtocolEntity vehicle = PacketEntities.getAPI().getEntityManager().getEntity(this.riding);
        if (vehicle == null || !vehicle.hasExtension(PassengerExtension.class)) {
            this.entity.sendPacketsToViewers(new WrapperPlayServerSetPassengers(this.riding, new int[]{this.entity.getEntityId()}));
        }
    }

    private void handleAddViewer(ViewerShowEntityEvent event) {
        if (this.entity == null) return;

        if (!this.passengers.isEmpty()) {
            WrapperPlayServerSetPassengers passengerPacket = createPassengerPacket();
            if (passengerPacket != null) {
                PacketDispatcher.sendPacket(event.viewer(), passengerPacket);
            }
        }

        if (this.riding == -1) return;

        ProtocolEntity vehicle = PacketEntities.getAPI().getEntityManager().getEntity(this.riding);
        if (vehicle == null || !vehicle.hasExtension(PassengerExtension.class)) {
            PacketDispatcher.sendPacket(event.viewer(), new WrapperPlayServerSetPassengers(this.riding, new int[]{this.entity.getEntityId()}));
        }
    }

    private void handleDespawn(EntityDespawnEvent event) {
        stopRiding();
        for (int passengerId : this.passengers) {
            ProtocolEntity passenger = PacketEntities.getAPI().getEntityManager().getEntity(passengerId);
            if (passenger != null) {
                passenger.editExtension(PassengerExtension.class, PassengerExtension::stopRiding);
            }
        }

        this.passengers.clear();
        this.riding = -1;
        this.preRidingLocation = null;
    }

    /**
     * @return the entity ID this entity is currently riding, or {@code -1} if none.
     */
    public int getRiding() {
        return this.riding;
    }

    /**
     * @return {@code true} if this entity is currently riding another entity.
     */
    public boolean isRiding() {
        return this.riding != -1;
    }

    /**
     * Makes this entity ride the vehicle with the given entity ID.
     *
     * @param vehicleId the protocol entity ID of the vehicle to ride
     * @return this extension for chaining
     */
    public PassengerExtension startRiding(int vehicleId) {
        if (this.entity == null) return this;
        if (this.riding != -1) {
            stopRiding();
        }

        this.preRidingLocation = this.entity.getLocation();
        this.riding = vehicleId;

        ProtocolEntity vehicle = PacketEntities.getAPI().getEntityManager().getEntity(vehicleId);
        if (vehicle != null && vehicle.hasExtension(PassengerExtension.class)) {
            vehicle.editExtension(PassengerExtension.class, ext -> ext.addPassenger(this.entity.getEntityId()));
        } else {
            this.entity.sendPacketsToViewers(new WrapperPlayServerSetPassengers(vehicleId, new int[]{this.entity.getEntityId()}));
        }
        return this;
    }

    /**
     * Dismounts this entity from its current vehicle.
     *
     * @return this extension for chaining
     */
    public PassengerExtension stopRiding() {
        if (this.entity == null) return this;
        if (this.riding == -1) return this;

        int vehicleId = this.riding;
        this.riding = -1;

        ProtocolEntity vehicle = PacketEntities.getAPI().getEntityManager().getEntity(vehicleId);
        if (vehicle != null && vehicle.hasExtension(PassengerExtension.class)) {
            vehicle.editExtension(PassengerExtension.class, ext -> ext.removePassenger(this.entity.getEntityId()));
        } else {
            this.entity.sendPacketsToViewers(new WrapperPlayServerSetPassengers(vehicleId, new int[0]));
        }

        if (this.preRidingLocation != null) {
            this.entity.teleport(this.preRidingLocation);
            this.preRidingLocation = null;
        }
        return this;
    }

    public PassengerExtension addPassenger(int passengerEntityId) {
        this.passengers.add(passengerEntityId);
        if (this.entity == null) return this;

        WrapperPlayServerSetPassengers packet = createPassengerPacket();
        if (packet != null) {
            this.entity.sendPacketsToViewers(packet);
        }
        return this;
    }

    /**
     * Removes a passenger from this entity and broadcasts the updated passenger list.
     *
     * @param passengerEntityId the entity ID of the passenger to remove
     * @return this extension for chaining
     */
    public PassengerExtension removePassenger(int passengerEntityId) {
        this.passengers.remove(passengerEntityId);
        if (this.entity == null) return this;

        WrapperPlayServerSetPassengers packet = createPassengerPacket();
        if (packet != null) {
            this.entity.sendPacketsToViewers(packet);
        }
        return this;
    }

    /**
     * @return an unmodifiable snapshot of the current passenger entity IDs.
     */
    public @UnmodifiableView Set<Integer> getPassengers() {
        return Collections.unmodifiableSet(this.passengers);
    }

    /**
     * @param passengerEntityId the entity to check
     * @return {@code true} if the given entity ID is currently a passenger.
     */
    public boolean hasPassenger(int passengerEntityId) {
        return this.passengers.contains(passengerEntityId);
    }

    private @Nullable WrapperPlayServerSetPassengers createPassengerPacket() {
        if (this.entity == null) return null;

        return new WrapperPlayServerSetPassengers(this.entity.getEntityId(),
                this.passengers.stream().mapToInt(i -> i).toArray());
    }

}
