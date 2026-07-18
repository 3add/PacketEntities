package dev.threeadd.packetentities.entity;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.attribute.Attribute;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.sound.Sound;
import com.github.retrooper.packetevents.protocol.sound.SoundCategory;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntitySoundEffect;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityStatus;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateAttributes;
import dev.threeadd.packetentities.PacketEntities;
import dev.threeadd.packetentities.entity.attribute.AttributesStateManager;
import dev.threeadd.packetentities.entity.data.EmptyProtocolObjectData;
import dev.threeadd.packetentities.entity.data.ProtocolObjectData;
import dev.threeadd.packetentities.entity.event.EntityDespawnEvent;
import dev.threeadd.packetentities.entity.event.EntitySpawnEvent;
import dev.threeadd.packetentities.entity.extension.EntityExtension;
import dev.threeadd.packetentities.entity.extension.ExtensionManager;
import dev.threeadd.packetentities.entity.extension.ExtensionManagerBuilder;
import dev.threeadd.packetentities.entity.extension.impl.TickVelocityExtension;
import dev.threeadd.packetentities.entity.world.EntityWorldStateManager;
import dev.threeadd.packetentities.entity.world.EntityWorldState;
import dev.threeadd.packetentities.entity.viewer.RegisteredViewerRule;
import dev.threeadd.packetentities.entity.viewer.ViewerManager;
import dev.threeadd.packetentities.entity.viewer.ViewerManagerBuilder;
import dev.threeadd.packetentities.event.Event;
import dev.threeadd.packetentities.event.EventBus;
import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.world.ProtocolWorld;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Represents any entity in the minecraft protocol, the {@link #builder()} method should be used to create entities.
 * When an entity should no longer be held on the server you should call {@link #destroy()}
 */
public class ProtocolEntity {

    // logic managers
    private final EventBus eventBus;
    private final ExtensionManager extensionManager;
    private final ViewerManager viewerManager;
    private final EntityWorldStateManager worldStateManager;
    private final AttributesStateManager attributesStateManager;

    // state
    private final EntityType entityType;
    private final UUID uuid;
    private final int entityId;
    private final ProtocolObjectData protocolObjectData;
    private ProtocolEntityMeta meta;
    private ClientVersion dataVersion;
    private volatile boolean isSpawned;

    ProtocolEntity(ProtocolEntityBuilder builder) {
        this.eventBus = new EventBus();

        ExtensionManagerBuilder extensions = builder.extensionManagerBuilder != null ? builder.extensionManagerBuilder : ExtensionManager.builder();
        this.extensionManager = extensions.build();
        ViewerManagerBuilder viewers = builder.viewerManagerBuilder != null ? builder.viewerManagerBuilder : ViewerManager.builder();
        this.viewerManager = viewers.build(this);

        this.entityType = builder.entityType;
        this.uuid = builder.uuid != null ? builder.uuid : UUID.randomUUID();
        this.entityId = builder.entityId != null ? builder.entityId : PacketEntities.getPlatform().getEntityIdProvider().provide(builder.world);
        this.protocolObjectData = builder.protocolObjectData != null ? builder.protocolObjectData : new EmptyProtocolObjectData();
        this.meta = builder.meta != null ? builder.meta : new ProtocolEntityMeta(this.entityType);
        this.dataVersion = builder.metaDataVersion != null ? builder.metaDataVersion : PacketEvents.getAPI().getServerManager().getVersion().toClientVersion();
        this.worldStateManager = new EntityWorldStateManager(this, builder.location, builder.velocity, builder.verticalHeadRot != null ? builder.verticalHeadRot : 0, false, builder.world);
        this.attributesStateManager = new AttributesStateManager(this, builder.attributes != null ? builder.attributes : Collections.emptyList());
        this.extensionManager.attachAll(this);

        if (!this.entityType.isInstanceOf(this.protocolObjectData.getBoundEntityType())) {
            throw new IllegalArgumentException("Entity type " + this.entityType +
                    " is not compatible with object data type " + this.protocolObjectData.getBoundEntityType());
        }

        if (!this.entityType.isInstanceOf(this.meta.getSchema().getBoundEntityType())) {
            throw new IllegalArgumentException("Entity type " + this.entityType +
                    " is not compatible with metadata schema bound entity type " + this.meta.getSchema().getBoundEntityType());
        }

        PacketEntities.getAPI().getEntityManager().addEntity(this);
    }

    /**
     * Creates a new protocol entity builder
     *
     * @return the builder
     */
    public static ProtocolEntityBuilder.EntityTypeStep builder() {
        return ProtocolEntityBuilder.newBuilder();
    }

    /**
     * @return the {@link EventBus} linked to this entity.
     * This should be used by {@link EntityExtension}s to add features.
     * @see dev.threeadd.packetentities.entity.event
     * @see dev.threeadd.packetentities.entity.extension
     */
    public EventBus getEventBus() {
        return this.eventBus;
    }

    /**
     * @return The uuid of this entity
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * @return The protocol entity id of this entity
     */
    public int getEntityId() {
        return this.entityId;
    }

    /**
     * @return The {@link ProtocolObjectData} of this entity
     */
    public ProtocolObjectData getObjectData() {
        return this.protocolObjectData;
    }

    /**
     * @return The entity type of this entity
     */
    public EntityType getEntityType() {
        return this.entityType;
    }

    /**
     * Applying changes to the returned entity meta will not update for viewers.
     * To update for viewers you can either get and set using {@link #setMeta(ProtocolEntityMeta)}
     * or alternatively you can use {@link #editMeta(Consumer)}.
     *
     * @return this entity's meta
     */
    public ProtocolEntityMeta getMeta() {
        return this.meta;
    }

    /**
     * Sets the entity's meta and updates for viewers if spawned.
     *
     * @param meta the new meta
     * @return this entity for chaining
     */
    public ProtocolEntity setMeta(ProtocolEntityMeta meta) {
        this.meta = meta;

        if (this.isSpawned) {
            this.viewerManager.sendPacketsToViewers(this.meta.createPacket(this.entityId, this.dataVersion));
        }
        return this;
    }

    /**
     * Consumes an entity meta and updates for viewers if spawned.
     *
     * @param editor the meta editor
     * @return this entity for chaining
     */
    public ProtocolEntity editMeta(Consumer<ProtocolEntityMeta> editor) {
        editor.accept(this.meta);

        if (this.isSpawned) {
            this.viewerManager.sendPacketsToViewers(this.meta.createPacket(this.entityId, this.dataVersion));
        }
        return this;
    }

    /**
     * @return The data version of this entity,
     * this represents the version in which the metadata and object data will be encoded when sent to players.
     * @see ProtocolEntityMeta
     * @see ProtocolObjectData
     */
    public ClientVersion getDataVersion() {
        return this.dataVersion;
    }

    /**
     * Sets the data version of this entity,
     * this represents the version in which the metadata and object data will be encoded when sent to players.
     *
     * @param version the new version
     * @return this entity for chaining
     * @see ProtocolEntityMeta
     * @see ProtocolObjectData
     */
    public ProtocolEntity setDataVersion(ClientVersion version) {
        this.dataVersion = version;
        return this;
    }

    @ApiStatus.Internal
    public EntityWorldStateManager getTrackedEntity() {
        return this.worldStateManager;
    }

    /**
     * @return a copy of the location of the entity
     */
    public Location getLocation() {
        EntityWorldState position = this.worldStateManager.getWorldState();
        return position.asLocation();
    }

    /**
     * Teleport the entity to a location
     *
     * @param location the new location
     * @return this entity for chaining
     */
    public ProtocolEntity teleport(Location location) {
        this.worldStateManager.teleport(location);
        return this;
    }

    /**
     * @return the yaw of the entity
     */
    public float getYaw() {
        EntityWorldState position = this.worldStateManager.getWorldState();
        return position.currentYaw();
    }

    /**
     * Set the yaw of the entity
     *
     * @param yaw the new yaw
     * @return this entity for chaining
     */
    public ProtocolEntity setYaw(float yaw) {
        this.worldStateManager.setYaw(yaw);
        return this;
    }

    /**
     * @return the pitch of the entity
     */
    public float getPitch() {
        EntityWorldState position = this.worldStateManager.getWorldState();
        return position.currentPitch();
    }

    /**
     * Set the pitch of the entity
     *
     * @param pitch the new pitch
     * @return this entity for chaining
     */
    public ProtocolEntity setPitch(float pitch) {
        this.worldStateManager.setPitch(pitch);
        return this;
    }

    /**
     * Make the entity look at a location in 3d space represented by a {@link Vector3d}
     *
     * @param position the position to look at
     * @return this entity for chaining
     * @see Location#getPosition()
     */
    public ProtocolEntity lookAt(Vector3d position) {
        this.worldStateManager.lookAt(position);
        return this;
    }

    /**
     * @return the vertical head rotation of the entity
     */
    public float getVerticalHeadRot() {
        EntityWorldState position = this.worldStateManager.getWorldState();
        return position.currentVerticalHeadRot();
    }

    /**
     * Set the vertical head rotation of the entity
     *
     * @param verticalHeadRot the new vertical head rotation
     * @return this entity for chaining
     */
    public ProtocolEntity setVerticalHeadRot(float verticalHeadRot) {
        this.worldStateManager.setVerticalHeadRot(verticalHeadRot);
        return this;
    }

    /**
     * @return Whether the entity is on ground
     */
    public boolean isOnGround() {
        EntityWorldState position = this.worldStateManager.getWorldState();
        return position.currentOnGround();
    }

    /**
     * Set whether the entity is on ground
     *
     * @param onGround the new on ground state
     * @return this entity for chaining
     */
    // TODO should expose to api?
    public ProtocolEntity setOnGround(boolean onGround) {
        this.worldStateManager.setOnGround(onGround);
        return this;
    }

    /**
     * @return The velocity of this entity
     */
    public Vector3d getVelocity() {
        EntityWorldState position = this.worldStateManager.getWorldState();
        Vector3d velocity = position.velocity();
        return velocity != null ? velocity : Vector3d.zero();
    }

    /**
     * Set the velocity of this entity, note that since velocity on itself doesn't do much you probably want something
     * handling the velocity. For velocity to be applied on clients the future position has to be sent to clients.
     *
     * @param velocity the new velocity
     * @return this entity for chaining
     * @see TickVelocityExtension
     */
    public ProtocolEntity setVelocity(Vector3d velocity) {
        this.worldStateManager.setVelocity(velocity);
        return this;
    }

    /**
     * Set the world of this entity, the stored {@link Location} will be the location in the new world.
     * This will destroy the entity for viewers not in the new world.
     *
     * @param world the new world
     * @return this entity for chaining
     */
    public ProtocolEntity setWorld(ProtocolWorld world) {
        this.worldStateManager.setWorld(world);
        return this;
    }

    /**
     * Set an attribute on the entity and update viewers if spawned.
     *
     * @param attribute the attribute to modify
     * @param value the new base value
     * @return this entity for chaining
     */
    public ProtocolEntity setAttribute(Attribute attribute, double value) {
        this.attributesStateManager.setAttribute(attribute, value);
        return this;
    }

    /**
     * Set an attribute with a single modifier on the entity and update viewers if spawned.
     *
     * @param attribute the attribute to modify
     * @param value the new base value
     * @param modifier the property modifier
     * @return this entity for chaining
     */
    public ProtocolEntity setAttribute(Attribute attribute, double value, WrapperPlayServerUpdateAttributes.PropertyModifier modifier) {
        this.attributesStateManager.setAttribute(attribute, value, modifier);
        return this;
    }

    /**
     * Set an attribute with multiple modifiers on the entity and update viewers if spawned.
     *
     * @param attribute the attribute to modify
     * @param value the new base value
     * @param modifiers the list of property modifiers
     * @return this entity for chaining
     */
    public ProtocolEntity setAttribute(Attribute attribute, double value, List<WrapperPlayServerUpdateAttributes.PropertyModifier> modifiers) {
        this.attributesStateManager.setAttribute(attribute, value, modifiers);
        return this;
    }

    /**
     * Removes an attribute from the entity and updates viewers if spawned.
     *
     * @param attribute the attribute to remove
     * @return this entity for chaining
     */
    public ProtocolEntity removeAttribute(Attribute attribute) {
        this.attributesStateManager.removeAttribute(attribute);
        return this;
    }

    /**
     * Removes multiple attributes from the entity and updates viewers if spawned.
     *
     * @param attributes the collection of attributes to remove
     * @return this entity for chaining
     */
    public ProtocolEntity removeAttributes(Collection<Attribute> attributes) {
        this.attributesStateManager.removeAttributes(attributes);
        return this;
    }

    /**
     * Sends a {@link WrapperPlayServerEntityAnimation} to viewers
     *
     * @param animation the {@link WrapperPlayServerEntityAnimation.EntityAnimationType} to include in the packet
     * @return this entity for chaining
     */
    public ProtocolEntity playAnimation(WrapperPlayServerEntityAnimation.EntityAnimationType animation) {
        return sendPacketsToViewers(new WrapperPlayServerEntityAnimation(this.entityId, animation));
    }

    // TODO add status wrappers according to https://minecraft.wiki/w/Java_Edition_protocol/Entity_statuses
    public ProtocolEntity playStatus(int status) {
        return sendPacketsToViewers(new WrapperPlayServerEntityStatus(this.entityId, status));
    }

    /**
     * Sends a {@link WrapperPlayServerEntitySoundEffect} packet to viewers, with a random seed.
     *
     * @param sound the {@link Sound}
     * @param category the {@link SoundCategory}
     * @param volume the volume of the sound
     * @param pitch the pitch of the sound
     * @return this entity for chaining
     */
    public ProtocolEntity playSound(Sound sound, SoundCategory category, float volume, float pitch) {
        return sendPacketsToViewers(new WrapperPlayServerEntitySoundEffect(sound, category, this.entityId, volume, pitch));
    }

    @ApiStatus.Internal
    public ViewerManager getViewerManager() {
        return this.viewerManager;
    }

    /**
     * @return All current viewers' {@link UUID}s wrapped in a {@link Collections#unmodifiableSet(Set)},
     * note that not all viewers can necessarily see the entity as the entity could be in an unloaded chunk.
     */
    public @UnmodifiableView Set<UUID> getViewers() {
        return this.viewerManager.getViewers();
    }

    /**
     * @param playerId The uuid of the player you want to check
     * @return Whether the target uuid is in the viewer list,
     * note that this doesn't necessarily mean they can see the entity as the entity could be
     * in an unloaded chunk.
     */
    public boolean isViewer(UUID playerId) {
        return this.viewerManager.isViewer(playerId);
    }

    /**
     * @return The amount of all viewers of this entity,
     * note that not all viewers can necessarily see the entity as the entity could be in an unloaded chunk.
     */
    public int getViewerCount() {
        return this.viewerManager.getViewerCount();
    }

    /**
     * @param playerUuid The uuid of the player you want to add to the viewers of the entity
     * @return this entity for chaining
     * @throws NullPointerException if the provided {code playerUuid} is null
     */
    public ProtocolEntity addViewer(UUID playerUuid) {
        Objects.requireNonNull(playerUuid, "playerUuid cannot be null");

        this.viewerManager.addViewer(playerUuid, false);
        return this;
    }

    /**
     * @param playerUuid The uuid of the player you want to remove from the viewers of the entity
     * @return this entity for chaining
     * @throws NullPointerException if the provided {code playerUuid} is null
     */
    public ProtocolEntity removeViewer(UUID playerUuid) {
        Objects.requireNonNull(playerUuid, "playerUuid cannot be null");

        this.viewerManager.addViewer(playerUuid, false);
        return this;
    }

    /**
     * Applies all the current registered {@link RegisteredViewerRule}s to the given user,
     * adding or removing them as a viewer if necessary.
     *
     * @param user the user to update
     * @return this entity for chaining
     */
    public ProtocolEntity updateViewer(User user) {
        this.viewerManager.updateViewer(user);
        return this;
    }

    /**
     * @param rule The rule to register, this will not automatically update for all viewers.
     * @return A {@link RegisteredViewerRule} instance that can be used to unregister the rule.
     */
    public RegisteredViewerRule addViewerRule(Predicate<User> rule) {
        return this.viewerManager.addViewerRule(rule);
    }

    /**
     * Adds an update trigger that when triggered will call {@link #updateViewer(User)} for all users in the extractor function
     *
     * @param eventBus      The event bus to listen to (doesn't have to be the same as this entity's event bus)
     * @param eventClass    The class of the event to listen to
     * @param userExtractor A function that takes the event and returns a collection of users to update
     * @param <T>           The type of the event to listen to
     * @return A {@link RegisteredViewerRule} instance that can be used to unregister the
     */
    public <T extends Event> RegisteredViewerRule addUpdateTrigger(EventBus eventBus, Class<T> eventClass, Function<T, Collection<User>> userExtractor) {
        return this.viewerManager.addUpdateTrigger(eventBus, eventClass, userExtractor);
    }

    /**
     * Spawns this entity at the location defined in the {@link ProtocolEntityBuilder},
     * this will check all current online players against rules/explicit viewers and display the entity accordingly.
     * After this you will have to implement updating using {@link #addUpdateTrigger(EventBus, Class, Function)} or manually using {@link #updateViewer(User)}.
     *
     * <p>For versions under {@code 1.20.2}</p>
     * <ul>
     *     <li>Advice: Set metadata before spawning a living entity to save a packet (later mojang removed the entity meta field on the spawn packet)</li>
     * </ul>
     *
     * @return this entity for chaining
     * @throws IllegalArgumentException if spawning a {@link EntityTypes#EXPERIENCE_ORB} on {@code 1.20.2-} without a set {@link EntityMetaFields.ExperienceOrb#VALUE}
     * (manually retrieved even though only used in meta as of {@code 1.21.5+})
     * @throws UnsupportedOperationException if spawning a painting entity on 1.19- due to a bad packet events implementation
     */
    public ProtocolEntity spawn() {
        if (this.isSpawned) return this;

        EntitySpawnEvent event = new EntitySpawnEvent();
        this.eventBus.post(event);

        if (event.isCancelled()) return this;

        this.isSpawned = true;

        this.viewerManager.registerAll(); // adding all viewers set in the builder
        this.worldStateManager.markSynced();

        List<WrapperPlayServerUpdateAttributes.Property> currentProps = new ArrayList<>(this.attributesStateManager.getAttributesState().currentProperties().values());
        if (!currentProps.isEmpty()) {
            sendPacketsToViewers(new WrapperPlayServerUpdateAttributes(this.entityId, currentProps));
        }
        this.attributesStateManager.markSynced();

        return this;
    }

    /**
     * Despawn this entity, removing it for all viewers.
     * You should use {@link #destroy()} if the entity will never be spawned again.
     *
     * @return this entity for chaining
     */
    public ProtocolEntity despawn() {
        if (!this.isSpawned) return this;

        EntityDespawnEvent event = new EntityDespawnEvent();
        this.eventBus.post(event);
        if (event.isCancelled()) return this;

        this.isSpawned = false;
        this.viewerManager.unregisterAll();
        return this;
    }

    /**
     * Completely destroys the entity, despawning it for all viewers,
     * clearing its extensions (and calling {@link EntityExtension#onDetach(ProtocolEntity)}),
     * view manager, event bus, and removing it from the {@link EntityManager}.
     */
    public void destroy() {
        this.despawn();
        this.extensionManager.detachAll(this);

        this.viewerManager.destroy();
        this.eventBus.destroy();
        this.extensionManager.destroy();

        PacketEntities.getAPI().getEntityManager().removeEntity(this, false);
    }

    public boolean isSpawned() {
        return this.isSpawned;
    }

    /**
     * @param clazz the extension class
     * @param <E>   the type of the extension
     * @return the extension instance of the given class attached to this entity, or {@code null}
     * if no such extension was added when building this entity.
     */
    public <E extends EntityExtension> @Nullable E getExtension(Class<E> clazz) {
        return this.extensionManager.getExtension(clazz);
    }

    /**
     * Looks up the extension of the given class and, if present, passes it to the editor.
     *
     * @param clazz  the extension class
     * @param editor the consumer that will edit the extension
     * @param <E>    the type of the extension
     * @return this protocol entity for chaining
     */
    public <E extends EntityExtension> ProtocolEntity editExtension(Class<E> clazz, Consumer<E> editor) {
        this.extensionManager.editExtension(clazz, editor);
        return this;
    }

    /**
     * @param clazz the extension class
     * @return {@code true} if this entity has an extension of the given class.
     */
    public boolean hasExtension(Class<? extends EntityExtension> clazz) {
        return this.extensionManager.hasExtension(clazz);
    }

    /**
     * @return an unmodifiable view of all extensions attached to this entity.
     */
    public @UnmodifiableView Collection<EntityExtension> getAllExtensions() {
        return this.extensionManager.getAllExtensions();
    }

    /**
     * @return an unmodifiable view of the extensions attached to this entity.
     */
    @UnmodifiableView
    Collection<Class<? extends EntityExtension>> getExtensionClasses() {
        return this.extensionManager.getExtensionClasses();
    }

    /**
     * Sends a packet to all current viewers of this entity.
     *
     * @param packets the packets to send
     * @return this protocol entity for chaining
     */
    public ProtocolEntity sendPacketsToViewers(PacketWrapper<?>... packets) {
        this.viewerManager.sendPacketsToViewers(packets);
        return this;
    }

    @Override
    public String toString() {
        EntityWorldState current = this.worldStateManager.getWorldState();
        return String.format(
                """
                        ProtocolEntity{
                        entityId=%s,
                        entityType=%s,
                        uuid=%s,
                        isSpawned=%s,
                        positionData=%s,
                        viewerCount=%d,
                        extensions=%s,
                        meta=%s,
                        attributesCount=%s
                        }""",
                this.entityId,
                this.entityType.getName().getKey(),
                this.uuid,
                this.isSpawned,
                current,
                this.viewerManager.getViewerCount(),
                this.extensionManager.getExtensionClasses().stream().map(Class::getSimpleName).collect(Collectors.toList()),
                this.meta,
                this.attributesStateManager.getAttributesState().currentProperties().size()
        );
    }

}
