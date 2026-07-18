package dev.threeadd.packetentities.entity.world;

import com.github.retrooper.packetevents.protocol.entity.EntityPositionData;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.world.ProtocolWorld;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

// record class, converted to java 8
/**
 * Represents a tracked {@link ProtocolEntity}'s state, this is used to determine whether a sync is needed
 * and has some nice utility methods
 */
@ApiStatus.Internal
public final class EntityWorldState {

    private final Vector3d currentPos;
    private final @Nullable Vector3d lastSyncedPos;
    private final float currentYaw;
    private final @Nullable Float lastSyncedYaw;
    private final float currentPitch;
    private final @Nullable Float lastSyncedPitch;
    private final float currentVerticalHeadRot;
    private final @Nullable Float lastSyncedVerticalHeadRot;
    private final boolean currentOnGround;
    private final @Nullable Boolean lastSyncedOnGround;
    private final @Nullable Vector3d currentVelocity;
    private final @Nullable Vector3d lastSyncedVelocity;
    private final ProtocolWorld currentWorld;
    private final @Nullable ProtocolWorld lastSyncedWorld;

    public EntityWorldState(
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
        this.currentPos = currentPos;
        this.lastSyncedPos = lastSyncedPos;
        this.currentYaw = currentYaw;
        this.lastSyncedYaw = lastSyncedYaw;
        this.currentPitch = currentPitch;
        this.lastSyncedPitch = lastSyncedPitch;
        this.currentVerticalHeadRot = currentVerticalHeadRot;
        this.lastSyncedVerticalHeadRot = lastSyncedVerticalHeadRot;
        this.currentOnGround = currentOnGround;
        this.lastSyncedOnGround = lastSyncedOnGround;
        this.currentVelocity = currentVelocity;
        this.lastSyncedVelocity = lastSyncedVelocity;
        this.currentWorld = currentWorld;
        this.lastSyncedWorld = lastSyncedWorld;
    }

    public Vector3d currentPos() {
        return this.currentPos;
    }

    public @Nullable Vector3d lastSyncedPos() {
        return this.lastSyncedPos;
    }

    public float currentYaw() {
        return this.currentYaw;
    }

    public @Nullable Float lastSyncedYaw() {
        return this.lastSyncedYaw;
    }

    public float currentPitch() {
        return this.currentPitch;
    }

    public @Nullable Float lastSyncedPitch() {
        return this.lastSyncedPitch;
    }

    public float currentVerticalHeadRot() {
        return this.currentVerticalHeadRot;
    }

    public @Nullable Float lastSyncedVerticalHeadRot() {
        return this.lastSyncedVerticalHeadRot;
    }

    public boolean currentOnGround() {
        return this.currentOnGround;
    }

    public @Nullable Boolean lastSyncedOnGround() {
        return this.lastSyncedOnGround;
    }

    public @Nullable Vector3d currentVelocity() {
        return this.currentVelocity;
    }

    public @Nullable Vector3d lastSyncedVelocity() {
        return this.lastSyncedVelocity;
    }

    public ProtocolWorld currentWorld() {
        return this.currentWorld;
    }

    public @Nullable ProtocolWorld lastSyncedWorld() {
        return this.lastSyncedWorld;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityWorldState that = (EntityWorldState) o;
        return Float.compare(that.currentYaw, this.currentYaw) == 0 &&
                Float.compare(that.currentPitch, this.currentPitch) == 0 &&
                Float.compare(that.currentVerticalHeadRot, this.currentVerticalHeadRot) == 0 &&
                this.currentOnGround == that.currentOnGround &&
                Objects.equals(this.currentPos, that.currentPos) &&
                Objects.equals(this.lastSyncedPos, that.lastSyncedPos) &&
                Objects.equals(this.lastSyncedYaw, that.lastSyncedYaw) &&
                Objects.equals(this.lastSyncedPitch, that.lastSyncedPitch) &&
                Objects.equals(this.lastSyncedVerticalHeadRot, that.lastSyncedVerticalHeadRot) &&
                Objects.equals(this.lastSyncedOnGround, that.lastSyncedOnGround) &&
                Objects.equals(this.currentVelocity, that.currentVelocity) &&
                Objects.equals(this.lastSyncedVelocity, that.lastSyncedVelocity) &&
                Objects.equals(this.currentWorld, that.currentWorld) &&
                Objects.equals(this.lastSyncedWorld, that.lastSyncedWorld);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currentPos, this.lastSyncedPos, this.currentYaw, this.lastSyncedYaw, this.currentPitch, this.lastSyncedPitch,
                this.currentVerticalHeadRot, this.lastSyncedVerticalHeadRot, this.currentOnGround, this.lastSyncedOnGround,
                this.currentVelocity, this.lastSyncedVelocity, this.currentWorld, this.lastSyncedWorld);
    }

    @Override
    public String toString() {
        return "EntityWorldState[" +
                "currentPos=" + this.currentPos + ", " +
                "lastSyncedPos=" + this.lastSyncedPos + ", " +
                "currentYaw=" + this.currentYaw + ", " +
                "lastSyncedYaw=" + this.lastSyncedYaw + ", " +
                "currentPitch=" + this.currentPitch + ", " +
                "lastSyncedPitch=" + this.lastSyncedPitch + ", " +
                "currentVerticalHeadRot=" + this.currentVerticalHeadRot + ", " +
                "lastSyncedVerticalHeadRot=" + this.lastSyncedVerticalHeadRot + ", " +
                "currentOnGround=" + this.currentOnGround + ", " +
                "lastSyncedOnGround=" + this.lastSyncedOnGround + ", " +
                "currentVelocity=" + this.currentVelocity + ", " +
                "lastSyncedVelocity=" + this.lastSyncedVelocity + ", " +
                "currentWorld=" + this.currentWorld + ", " +
                "lastSyncedWorld=" + this.lastSyncedWorld + ']';
    }

}
