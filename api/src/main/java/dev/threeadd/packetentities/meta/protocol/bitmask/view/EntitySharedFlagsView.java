package dev.threeadd.packetentities.meta.protocol.bitmask.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.bitmask.BitmaskView;

/**
 * Represents {@link EntityMetaFields.Entity#SHARED_FLAGS}
 */
public class EntitySharedFlagsView extends BitmaskView {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Entity
    private static final int MASK_ON_FIRE = 0x01;
    private static final int MASK_SNEAKING = 0x02;
    // 0x04 is unused/reserved (irrelevant to 1.14.4+)
    private static final int MASK_SPRINTING = 0x08;
    private static final int MASK_SWIMMING = 0x10;
    private static final int MASK_INVISIBLE = 0x20;
    private static final int MASK_GLOWING = 0x40;
    private static final int MASK_FALL_FLYING = 0x80;

    public EntitySharedFlagsView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Entity.SHARED_FLAGS);
    }

    /**
     * @return {@code true} if the entity is on fire.
     */
    public boolean isOnFire() {
        return hasMask(MASK_ON_FIRE);
    }

    /**
     * Sets whether the entity is on fire.
     *
     * @param value the new value
     * @return this view for chaining
     */
    public EntitySharedFlagsView setOnFire(boolean value) {
        setMask(MASK_ON_FIRE, value);
        return this;
    }

    /**
     * @return {@code true} if the entity is sneaking/crouching.
     */
    public boolean isSneaking() {
        return hasMask(MASK_SNEAKING);
    }

    /**
     * Sets whether the entity is sneaking/crouching.
     *
     * @param value the new value
     * @return this view for chaining
     */
    public EntitySharedFlagsView setSneaking(boolean value) {
        setMask(MASK_SNEAKING, value);
        return this;
    }

    /**
     * @return {@code true} if the entity is sprinting.
     */
    public boolean isSprinting() {
        return hasMask(MASK_SPRINTING);
    }

    /**
     * Sets whether the entity is sprinting.
     * @param value the new value
     * @return this view for chaining
     */
    public EntitySharedFlagsView setSprinting(boolean value) {
        setMask(MASK_SPRINTING, value);
        return this;
    }

    /**
     * @return {@code true} if the entity is swimming.
     */
    public boolean isSwimming() {
        return hasMask(MASK_SWIMMING);
    }

    /**
     * Sets whether the entity is swimming.
     * @param value the new value
     * @return this view for chaining
     */
    public EntitySharedFlagsView setSwimming(boolean value) {
        setMask(MASK_SWIMMING, value);
        return this;
    }

    /**
     * @return {@code true} if the entity is invisible.
     */
    public boolean isInvisible() {
        return hasMask(MASK_INVISIBLE);
    }

    /**
     * Sets whether the entity is invisible.
     * @param value the new value
     * @return this view for chaining
     */
    public EntitySharedFlagsView setInvisible(boolean value) {
        setMask(MASK_INVISIBLE, value);
        return this;
    }

    /**
     * @return {@code true} if the entity has the glowing effect.
     */
    public boolean isGlowing() {
        return hasMask(MASK_GLOWING);
    }

    /**
     * Sets whether the entity has the glowing effect.
     * @param value the new value
     * @return this view for chaining
     */
    public EntitySharedFlagsView setGlowing(boolean value) {
        setMask(MASK_GLOWING, value);
        return this;
    }

    /**
     * @return {@code true} if the entity is elytra flying (fall flying).
     */
    public boolean isFallFlying() {
        return hasMask(MASK_FALL_FLYING);
    }

    /**
     * Sets whether the entity is elytra flying (fall flying).
     * @param value the new value
     * @return this view for chaining
     */
    public EntitySharedFlagsView setFallFlying(boolean value) {
        setMask(MASK_FALL_FLYING, value);
        return this;
    }

}
