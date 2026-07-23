package dev.threeadd.packetentities.entity.world;

import com.github.retrooper.packetevents.protocol.entity.EntityPositionData;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.world.ProtocolWorld;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a tracked {@link ProtocolEntity}'s state, this is used to determine whether a sync is needed
 * and has some nice utility methods
 */
@ApiStatus.Internal
public record EntityWorldState(
        Vector3d currentPos,
        @Nullable Vector3d lastSyncedPos,
        float currentYaw,
        @Nullable Float lastSyncedYaw,
        float currentPitch,
        @Nullable Float lastSyncedPitch,
        float currentVerticalHeadRot,
        @Nullable Float lastSyncedVerticalHeadRot,
        boolean currentOnGround,
        @Nullable Boolean lastSyncedOnGround,
        @Nullable Vector3d currentVelocity,
        @Nullable Vector3d lastSyncedVelocity,
        ProtocolWorld currentWorld,
        @Nullable ProtocolWorld lastSyncedWorld
) {

    public @Nullable Vector3d velocity() {
        return this.currentVelocity;
    }

    public EntityPositionData asEntityPosData() {
        return new EntityPositionData(this.currentPos, deltaPosition(), this.currentYaw, this.currentPitch);
    }

    public Location asLocation() {
        return new Location(this.currentPos, this.currentYaw, this.currentPitch);
    }

    public EntityWorldState withVelocity(@Nullable Vector3d velocity) {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                velocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState withPosition(Vector3d position) {
        return new EntityWorldState(
                position, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState withYaw(float yaw) {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                yaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState withPitch(float pitch) {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                pitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState withVerticalHeadRot(float verticalHeadRot) {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                verticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState withOnGround(boolean onGround) {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                onGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState withWorld(ProtocolWorld world) {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                world, this.lastSyncedWorld
        );
    }

    public boolean needsFullSync() {
        return this.lastSyncedPos == null
                || this.lastSyncedYaw == null
                || this.lastSyncedPitch == null
                || this.lastSyncedVerticalHeadRot == null
                || this.lastSyncedOnGround == null
                || this.lastSyncedWorld == null;
    }

    public EntityWorldState syncWith(Vector3d newPos, float newYaw, float newPitch,
                                     float newHeadRot, boolean newIsOnGround,
                                     ProtocolWorld newWorld) {
        return new EntityWorldState(
                newPos, this.currentPos,
                newYaw, this.currentYaw,
                newPitch, this.currentPitch,
                newHeadRot, this.currentVerticalHeadRot,
                newIsOnGround, this.currentOnGround,
                this.currentVelocity, this.currentVelocity, // carry velocity through unchanged
                newWorld, this.currentWorld
        );
    }

    public EntityWorldState sync() {
        return new EntityWorldState(
                this.currentPos, this.currentPos,
                this.currentYaw, this.currentYaw,
                this.currentPitch, this.currentPitch,
                this.currentVerticalHeadRot, this.currentVerticalHeadRot,
                this.currentOnGround, this.currentOnGround,
                this.currentVelocity, this.currentVelocity,
                this.currentWorld, this.currentWorld
        );
    }

    public EntityWorldState syncPosition() {
        return new EntityWorldState(
                this.currentPos, this.currentPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.currentWorld
        );
    }

    public EntityWorldState syncYawPitch() {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.currentYaw,
                this.currentPitch, this.currentPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState syncVerticalHeadRot() {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.currentVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState syncOnGround() {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.currentOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState syncVelocity() {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.currentVelocity,
                this.currentWorld, this.lastSyncedWorld
        );
    }

    public EntityWorldState syncWorld() {
        return new EntityWorldState(
                this.currentPos, this.lastSyncedPos,
                this.currentYaw, this.lastSyncedYaw,
                this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot,
                this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity,
                this.currentWorld, this.currentWorld
        );
    }

    public Vector3d deltaPosition() {
        if (this.lastSyncedPos == null) {
            return new Vector3d(0, 0, 0);
        }
        return new Vector3d(
                this.currentPos.getX() - this.lastSyncedPos.getX(),
                this.currentPos.getY() - this.lastSyncedPos.getY(),
                this.currentPos.getZ() - this.lastSyncedPos.getZ()
        );
    }

    public double distanceSqToLastSynced() {
        if (this.lastSyncedPos == null) return 0.0;
        double dx = this.currentPos.getX() - this.lastSyncedPos.getX();
        double dy = this.currentPos.getY() - this.lastSyncedPos.getY();
        double dz = this.currentPos.getZ() - this.lastSyncedPos.getZ();
        return dx * dx + dy * dy + dz * dz;
    }

    public boolean hasPositionChanged(double blockThreshold) {
        if (this.lastSyncedPos == null) return true;
        return distanceSqToLastSynced() > (blockThreshold * blockThreshold);
    }

    public boolean hasPitchYawChanged(float degreeThreshold) {
        if (this.lastSyncedYaw == null || this.lastSyncedPitch == null) return true;
        return Math.abs(this.currentYaw - this.lastSyncedYaw) > degreeThreshold
                || Math.abs(this.currentPitch - this.lastSyncedPitch) > degreeThreshold;
    }

    public boolean hasVerticalHeadRotChanged(float degreeThreshold) {
        if (this.lastSyncedVerticalHeadRot == null) return true;
        return Math.abs(this.currentVerticalHeadRot - this.lastSyncedVerticalHeadRot) > degreeThreshold;
    }

    public boolean hasOnGroundChanged() {
        if (this.lastSyncedOnGround == null) return true;
        return this.currentOnGround != this.lastSyncedOnGround;
    }

    public boolean hasVelocityChanged() {
        if (this.currentVelocity == null && this.lastSyncedVelocity == null) return false;
        if (this.currentVelocity == null || this.lastSyncedVelocity == null) return true;
        return !this.currentVelocity.equals(this.lastSyncedVelocity);
    }

    public boolean hasWorldChanged() {
        if (this.lastSyncedWorld == null) return true;
        return !this.currentWorld.equals(this.lastSyncedWorld);
    }

}
