package dev.threeadd.packetentities.entity.world;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import dev.threeadd.packetentities.PacketEntities;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.world.ProtocolWorld;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the required tracking logic for a {@link ProtocolEntity}
 * @see ProtocolEntity
 * @see EntityWorldState
 */
@ApiStatus.Internal
public class EntityWorldStateManager {

    private final ProtocolEntity entity;
    private EntityWorldState worldState;

    public EntityWorldStateManager(ProtocolEntity entity, Location initialLocation,
                                   @Nullable Vector3d initialVelocity, float initialVerticalHeadRot,
                                   boolean initialOnGround, ProtocolWorld initialWorld) {
        this.entity = entity;
        this.worldState = new EntityWorldState(
                initialLocation.getPosition(), null,
                initialLocation.getYaw(), null,
                initialLocation.getPitch(), null,
                initialVerticalHeadRot, null,
                initialOnGround, null,
                initialVelocity, null,
                initialWorld, null
        );
    }

    public EntityWorldState getWorldState() {
        return this.worldState;
    }

    public void teleport(Location location) {
        updatePosition(location.getPosition(), location.getYaw(), location.getPitch(),
                location.getYaw(), this.worldState.currentOnGround(),
                this.worldState.currentWorld());
    }

    public void setYaw(float yaw) {
        updatePosition(this.worldState.currentPos(), yaw, this.worldState.currentPitch(),
                yaw, this.worldState.currentOnGround(), this.worldState.currentWorld());
    }

    public void setPitch(float pitch) {
        updatePosition(this.worldState.currentPos(), this.worldState.currentYaw(), pitch,
                this.worldState.currentVerticalHeadRot(), this.worldState.currentOnGround(),
                this.worldState.currentWorld());
    }

    public void setVerticalHeadRot(float verticalHeadRot) {
        updatePosition(this.worldState.currentPos(), this.worldState.currentYaw(),
                this.worldState.currentPitch(), verticalHeadRot,
                this.worldState.currentOnGround(), this.worldState.currentWorld());
    }

    public void setOnGround(boolean onGround) {
        updatePosition(this.worldState.currentPos(), this.worldState.currentYaw(),
                this.worldState.currentPitch(), this.worldState.currentVerticalHeadRot(),
                onGround, this.worldState.currentWorld());
    }

    public void setVelocity(Vector3d velocity) {
        this.entity.sendPacketsToViewers(new WrapperPlayServerEntityVelocity(this.entity.getEntityId(), velocity));
        this.worldState = this.worldState.withVelocity(velocity);
    }

    public void setWorld(ProtocolWorld newWorld) {
        ProtocolWorld oldWorld = this.worldState.currentWorld();
        if (oldWorld.equals(newWorld)) return;

        boolean wasSpawned = this.entity.isSpawned();
        if (wasSpawned) {
            this.entity.getViewerManager().unregisterAll();
        }

        Vector3d pos = this.worldState.currentPos();

        PacketEntities.getAPI().getEntityManager().updateEntityWorld(this.entity, oldWorld, pos, newWorld, pos);

        this.worldState = this.worldState.withWorld(newWorld);

        if (!wasSpawned) return;
        this.entity.getViewerManager().registerAll();
    }

    public void lookAt(Vector3d target) {
        Vector3d pos = this.worldState.currentPos();
        double dx = target.getX() - pos.getX();
        double dy = target.getY() - pos.getY();
        double dz = target.getZ() - pos.getZ();
        double distanceXZ = Math.sqrt(dx * dx + dz * dz);

        float yaw = (float) Math.toDegrees(Math.atan2(-dx, dz));
        float pitch = (float) Math.toDegrees(Math.atan2(-dy, distanceXZ));

        this.worldState = this.worldState.syncWith(
                this.worldState.currentPos(),
                yaw, pitch, yaw,
                this.worldState.currentOnGround(),
                this.worldState.currentWorld()
        );

        dispatchMovementUpdates();
    }

    private void updatePosition(Vector3d position, float yaw, float pitch,
                                float verticalHeadRot, boolean onGround, ProtocolWorld world) {
        updatePosition(this.worldState.syncWith(position, yaw, pitch, verticalHeadRot, onGround, world));
    }

    private void updatePosition(EntityWorldState position) {
        Vector3d oldPos = this.worldState.currentPos();
        Vector3d newPos = position.currentPos();

        int oldChunkX = (int) Math.floor(oldPos.getX()) >> 4;
        int oldChunkZ = (int) Math.floor(oldPos.getZ()) >> 4;

        int newChunkX = (int) Math.floor(newPos.getX()) >> 4;
        int newChunkZ = (int) Math.floor(newPos.getZ()) >> 4;

        if (oldChunkX != newChunkX || oldChunkZ != newChunkZ) {
            PacketEntities.getAPI().getEntityManager().updateEntityChunk(this.entity, oldPos, newPos);
        }

        this.worldState = position;
        dispatchMovementUpdates();
    }

    private void dispatchMovementUpdates() {
        if (!this.entity.isSpawned() || this.entity.getViewerCount() == 0) {
            markSynced();
            return;
        }

        if (this.worldState.needsFullSync()) {
            this.entity.sendPacketsToViewers(
                    createTeleportPacket(),
                    new WrapperPlayServerEntityHeadLook(this.entity.getEntityId(),
                            this.worldState.currentVerticalHeadRot())
            );
            markSynced();
            return;
        }

        boolean positionChange = this.worldState.hasPositionChanged(0.0002);
        boolean pitchYawChange = this.worldState.hasPitchYawChanged(0.05f);
        boolean verticalHeadRotChange = this.worldState.hasVerticalHeadRotChanged(0.05f);
        boolean groundChanged = this.worldState.hasOnGroundChanged();

        if (!positionChange && !pitchYawChange && !verticalHeadRotChange && !groundChanged) {
            return;
        }

        int entityId = this.entity.getEntityId();

        if (this.worldState.hasPositionChanged(7.999755859375)) {
            this.entity.sendPacketsToViewers(createTeleportPacket());
        } else if (positionChange && pitchYawChange) {
            Vector3d deltaPos = this.worldState.deltaPosition();
            this.entity.sendPacketsToViewers(new WrapperPlayServerEntityRelativeMoveAndRotation(entityId,
                    deltaPos.getX(), deltaPos.getY(), deltaPos.getZ(),
                    this.worldState.currentYaw(), this.worldState.currentPitch(),
                    this.worldState.currentOnGround()
            ));
        } else if (positionChange) {
            // TODO verify this minestom issue
            // Minestom fix: Sending pure relative movement without rotation causes entities
            // spawning on the ground to visually break their rotation. We force rotation sync here.
            Vector3d deltaPos = this.worldState.deltaPosition();
            this.entity.sendPacketsToViewers(new WrapperPlayServerEntityRelativeMove(entityId,
                    deltaPos.getX(), deltaPos.getY(), deltaPos.getZ(), this.worldState.currentOnGround()
            ));
        } else if (pitchYawChange) {
            this.entity.sendPacketsToViewers(new WrapperPlayServerEntityRotation(entityId,
                    this.worldState.currentYaw(), this.worldState.currentPitch(), this.worldState.currentOnGround()
            ));
        }

        if (verticalHeadRotChange) {
            this.entity.sendPacketsToViewers(new WrapperPlayServerEntityHeadLook(entityId,
                    this.worldState.currentVerticalHeadRot()
            ));
        }

        markSynced();
    }

    public void markSynced() {
        this.worldState = this.worldState.sync();
    }

    // 1.14.4 wiki: http://minecraft.wiki/w/Java_Edition_protocol/Packets?oldid=2772459

    private static final boolean IS_NEWER_THAN_1_21_2 = PacketEvents.getAPI().getServerManager().getVersion().isNewerThan(ServerVersion.V_1_21_2);

    private PacketWrapper<?> createTeleportPacket() {
        if (IS_NEWER_THAN_1_21_2) {
            return new WrapperPlayServerEntityPositionSync(this.entity.getEntityId(),
                    this.worldState.asEntityPosData(), this.worldState.currentOnGround()
            );
        }

        // Flags are irrelevant under 1.21.2 https://minecraft.wiki/w/Java_Edition_protocol/Packets?oldid=2773397#Teleport_Entity
        return new WrapperPlayServerEntityTeleport(this.entity.getEntityId(),
                this.worldState.asLocation(), this.worldState.currentOnGround());
    }

    /*
    1.19+ marks the removal of
     - Spawn Global Entity (used for thunderbolts)
     - Spawn Mob (used for mobs)
     - Spawn Painting (used for paintings)
     */
    private static final boolean OLDER_1_19 = PacketEvents.getAPI().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_19);
    /*
    1.20.2+ marks the removal of
     - Spawn Player (used for players coming in view range) see Join Game for joins
     - Spawn Experience Orb (used for experience orbs)
     */
    private static final boolean NEWER_OR_EQUALS_1_20_2 = PacketEvents.getAPI().getServerManager().getVersion().isNewerThanOrEquals(ServerVersion.V_1_20_2);

    public PacketWrapper<?> createSpawnPacket() {
        if (NEWER_OR_EQUALS_1_20_2) {
            return createModernSpawnPacket();
        }

        if (this.entity.isSubtypeOf(EntityTypes.PLAYER)) {
            return new WrapperPlayServerSpawnPlayer(
                    this.entity.getEntityId(),
                    this.entity.getUuid(),
                    this.worldState.asLocation(),
                    this.entity.getEntityMeta().entityData(this.entity.getDataVersion().toClientVersion())
            );
        }

        if (this.entity.isSubtypeOf(EntityTypes.EXPERIENCE_ORB)) {
            Vector3d pos = this.worldState.currentPos();
            return new WrapperPlayServerSpawnExperienceOrb(
                    this.entity.getEntityId(),
                    pos.getX(),
                    pos.getY(),
                    pos.getZ(),
                    this.entity.getEntityMeta().getOptional(EntityMetaFields.ExperienceOrb.VALUE)
                            .orElseThrow(() -> new IllegalArgumentException("can't get xp from metadata for spawning an experience orb"))
                            .shortValue()
            );
        }

        if (OLDER_1_19) {
            Vector3d pos = this.worldState.currentPos();
            if (this.entity.isSubtypeOf(EntityTypes.LIGHTNING_BOLT)) {
                return new WrapperPlayServerSpawnWeatherEntity(
                        this.entity.getEntityId(),
                        (byte) 1, // TODO verify if 1.19- only has thunderbolt as 1
                        pos.getX(),
                        pos.getY(),
                        pos.getZ()
                );
            }

            if (this.entity.isSubtypeOf(EntityTypes.PAINTING)) {
//                return new WrapperPlayServerSpawnPainting(
//                        this.entity.getEntityId(),
//                        this.entity.getUuid().orElse(UUID.randomUUID()),
//                        this.entity.getMeta().get(PaintingMetaProperties.PAINTING_VARIANT), // TODO
//                        this.trackedPosition.currentPos(),
//                        this.entity.getMeta().get(PaintingMetaProperties.DIRECTION)  // TODO
//                );
                throw new UnsupportedOperationException("PAINTING entities are not yet supported on 1.19-");
            }

            if (this.entity.isSubtypeOf(EntityTypes.LIVINGENTITY)) {
                Vector3d velocity = this.worldState.velocity();
                return new WrapperPlayServerSpawnLivingEntity(
                        this.entity.getEntityId(),
                        this.entity.getUuid(),
                        this.entity.getEntityType(),
                        this.worldState.currentPos(),
                        this.worldState.currentYaw(),
                        this.worldState.currentPitch(),
                        this.worldState.currentVerticalHeadRot(),
                        velocity != null ? velocity : Vector3d.zero(),
                        this.entity.getEntityMeta().entityData(this.entity.getDataVersion().toClientVersion())
                );
            }
        }

        throw new IllegalStateException("Couldn't match a spawn packet for " + this.entity + " on " + PacketEvents.getAPI().getServerManager().getVersion());
    }

    private WrapperPlayServerSpawnEntity createModernSpawnPacket() {
        Vector3d velocity = this.worldState.velocity();
        return new WrapperPlayServerSpawnEntity(
                this.entity.getEntityId(),
                this.entity.getUuid(),
                this.entity.getEntityType(),
                this.worldState.asLocation(),
                this.worldState.currentVerticalHeadRot(),
                this.entity.getObjectData().getObjectData(this.entity.getDataVersion()),
                velocity != null ? velocity : Vector3d.zero()
        );
    }

}
