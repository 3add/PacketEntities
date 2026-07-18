package dev.threeadd.packetentities.entity;

import com.github.retrooper.packetevents.manager.server.ServerManager;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateAttributes;
import dev.threeadd.packetentities.entity.data.EmptyProtocolObjectData;
import dev.threeadd.packetentities.entity.data.ProtocolObjectData;
import dev.threeadd.packetentities.entity.extension.ExtensionManager;
import dev.threeadd.packetentities.entity.extension.ExtensionManagerBuilder;
import dev.threeadd.packetentities.entity.viewer.ViewerManager;
import dev.threeadd.packetentities.entity.viewer.ViewerManagerBuilder;
import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.EntityMetaSchemaRegistry;
import dev.threeadd.packetentities.world.ProtocolWorld;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

public class ProtocolEntityBuilder {

    final @Nullable ExtensionManagerBuilder extensionManagerBuilder;
    @Nullable ViewerManagerBuilder viewerManagerBuilder;

    final EntityType entityType;
    @Nullable Integer entityId;
    @Nullable UUID uuid;
    @Nullable ProtocolObjectData protocolObjectData;
    @Nullable ProtocolEntityMeta meta;
    @Nullable ClientVersion metaDataVersion;

    // world state
    @UnknownNullability Location location; // set on build
    @Nullable Vector3d velocity;
    @Nullable Float verticalHeadRot;
    // on ground state, TODO expose to api? how should this be handled
    @UnknownNullability ProtocolWorld world; // set on build

    // attribute state
    @Nullable List<WrapperPlayServerUpdateAttributes.Property> attributes;

    private ProtocolEntityBuilder(EntityType entityType, @Nullable ExtensionManagerBuilder extensionManagerBuilder) {
        this.entityType = entityType;
        this.extensionManagerBuilder = extensionManagerBuilder;

        this.meta = new ProtocolEntityMeta(EntityMetaSchemaRegistry.getSchema(entityType));
    }

    static EntityTypeStep newBuilder() {
        return new EntityTypeStep();
    }

    /**
     * Set the view manager builder for the entity. If null,
     * an empty one will be provided for you on build.
     *
     * @param builder the {@link ViewerManagerBuilder} to set
     * @return this builder for chaining
     */
    public ProtocolEntityBuilder viewers(@Nullable ViewerManagerBuilder builder) {
        this.viewerManagerBuilder = builder;
        return this;
    }

    /**
     * Configure the viewer manager for this entity using {@link ViewerManagerBuilder}
     * If a manager was not set before this using {@link #viewers(ViewerManagerBuilder)},
     * a new empty {@link ViewerManagerBuilder} object will be created for you, which is then consumed.
     *
     * @param config the config for the {@link ViewerManagerBuilder}
     * @return this builder for chaining
     * @throws NullPointerException if the provided {@code config} is null
     */
    public ProtocolEntityBuilder viewers(Consumer<ViewerManagerBuilder> config) {
        if (this.viewerManagerBuilder == null) {
            this.viewerManagerBuilder = ViewerManager.builder();
        }
        Objects.requireNonNull(config, "config must not be null").accept(this.viewerManagerBuilder);
        return this;
    }

    /**
     * @param entityId the protocol entity id to use. If null,
     *                 one will be generated for you based on your platform.
     * @return this builder for chaining
     */
    public ProtocolEntityBuilder entityId(@Nullable Integer entityId) {
        this.entityId = entityId;
        return this;
    }

    /**
     * @param uuid the entity uuid to use. If null,
     *             this will default to {@link UUID#randomUUID()}
     * @return this builder for chaining
     */
    public ProtocolEntityBuilder uuid(@Nullable UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * @param protocolObjectData the <a href="https://minecraft.wiki/w/Java_Edition_protocol/Object_data">object data</a> of this entity
     *                   this will default to {@link EmptyProtocolObjectData}
     * @return this builder for chaining
     * @see dev.threeadd.packetentities.entity.data
     */
    public ProtocolEntityBuilder objectData(@Nullable ProtocolObjectData protocolObjectData) {
        this.protocolObjectData = protocolObjectData;
        return this;
    }

    /**
     * @param meta the entity meta for this entity to start with. If null,
     *             this will default to a new empty {@link ProtocolEntityMeta} object
     * @return this builder for chaining
     * @throws NullPointerException if the provided {@code meta} is null
     */
    public ProtocolEntityBuilder meta(@Nullable ProtocolEntityMeta meta) {
        this.meta = Objects.requireNonNull(meta, "EntityMetadata must not be null");
        return this;
    }

    /**
     * Configure the entity meta for this entity using {@link ProtocolEntityMeta}
     * If a meta was not set before this using {@link #meta(ProtocolEntityMeta)},
     * a new empty {@link ProtocolEntityMeta} object will be created for you, which is then consumed.
     *
     * @param config the config for the entity metadata
     * @return this builder for chaining
     * @throws NullPointerException if the provided {@code config} is null
     */
    public ProtocolEntityBuilder meta(Consumer<ProtocolEntityMeta> config) {
        if (this.meta == null) {
            this.meta = new ProtocolEntityMeta(EntityMetaSchemaRegistry.getSchema(this.entityType));
        }

        Objects.requireNonNull(config, "config must not be null").accept(this.meta);
        return this;
    }

    /**
     * @param version the version for the entity metadata to be encoded with, if null,
     *                this will default to {@link ServerManager#getVersion()} (then {@link ServerVersion#toClientVersion()})
     * @return this builder for chaining
     */
    public ProtocolEntityBuilder version(@Nullable ClientVersion version) {
        this.metaDataVersion = version;
        return this;
    }

    /**
     * @param velocity the starting velocity for the entity, this will also be applied on the spawn packet, if null,
     *                 then the entity will not have a velocity on spawn
     * @return this builder for chaining
     */
    public ProtocolEntityBuilder velocity(@Nullable Vector3d velocity) {
        this.velocity = velocity;
        return this;
    }

    /**
     * @param verticalHeadRot the vertical head rotation of the entity, if null,
     *                        this will default to {@code 0F}
     * @return this builder for chaining
     */
    public ProtocolEntityBuilder verticalHeadRot(@Nullable Float verticalHeadRot) {
        this.verticalHeadRot = verticalHeadRot;
        return this;
    }

    /**
     * @param attributes the starting attributes for the entity. If null,
     *                   it will start with no tracked attributes.
     * @return this builder for chaining
     */
    public ProtocolEntityBuilder attributes(@Nullable List<WrapperPlayServerUpdateAttributes.Property> attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Configure the initial attributes for this entity.
     * If attributes were not set before this, a new empty list will be created for you, which is then consumed.
     *
     * @param config the config for the attributes list
     * @return this builder for chaining
     * @throws NullPointerException if the provided {@code config} is null
     */
    public ProtocolEntityBuilder attributes(Consumer<List<WrapperPlayServerUpdateAttributes.Property>> config) {
        if (this.attributes == null) {
            this.attributes = new ArrayList<>();
        }
        Objects.requireNonNull(config, "config must not be null").accept(this.attributes);
        return this;
    }

    /**
     * Build the protocol entity.
     *
     * @param world    the world the entity starts in
     * @param location where to place the entity, used for initial tracking
     * @return the constructed {@link ProtocolEntity}
     * @throws NullPointerException if either argument is null
     * @throws IllegalArgumentException if the stored object data's bound entity type isn't a parent of this entity's type
     * @throws IllegalArgumentException if the stored metadata's schema's bound entity type isn't a parent of this entity's type
     */
    public ProtocolEntity build(ProtocolWorld world, Location location) {
        this.world = Objects.requireNonNull(world, "world must not be null");
        this.location = Objects.requireNonNull(location, "location must not be null");
        return new ProtocolEntity(this);
    }

    /**
     * Build the protocol entity and spawn it at a given location in a given world.
     *
     * @param world    the world the entity starts in
     * @param location where to place the entity
     * @return the constructed {@link ProtocolEntity}
     * @throws NullPointerException if either argument is null
     * @see ProtocolEntity#spawn()
     */
    public ProtocolEntity buildAndSpawn(ProtocolWorld world, Location location) {
        return build(world, location).spawn();
    }

    public static class EntityTypeStep {

        private EntityTypeStep() {
        }

        /**
         * @param entityType the entity type for the entity,
         *                   this is required to build the entity and can not be null
         * @return this builder for chaining
         * @throws NullPointerException if the provided {@code entityType} type is null
         */
        public ExtensionsStep entityType(EntityType entityType) {
            return new ExtensionsStep(Objects.requireNonNull(entityType, "EntityType must not be null"));
        }

    }

    public static class ExtensionsStep {

        private @Nullable ExtensionManagerBuilder extensionManagerBuilder;

        private final EntityType entityType;

        private ExtensionsStep(EntityType entityType) {
            this.entityType = entityType;
        }

        /**
         * Set the extension manager builder for the entity. If null,
         * an empty one will be provided for you on build.
         *
         * @param builder the {@link ExtensionManagerBuilder} to set
         * @return this builder for chaining
         * @throws NullPointerException if the provided {@code builder} is null
         */
        public ProtocolEntityBuilder extensions(ExtensionManagerBuilder builder) {
            this.extensionManagerBuilder = Objects.requireNonNull(builder, "builder must not be null");
            return new ProtocolEntityBuilder(this.entityType, this.extensionManagerBuilder);
        }

        /**
         * Configure the viewer manager for this entity using {@link ViewerManagerBuilder}
         * If a manager was not set before this using {@link #viewers(ViewerManagerBuilder)},
         * a new empty {@link ViewerManagerBuilder} object will be created for you, which is then consumed.
         *
         * @param config the manager config
         * @return this builder for chaining
         * @throws NullPointerException if the provided {@code config} is null
         */
        public ProtocolEntityBuilder extensions(Consumer<ExtensionManagerBuilder> config) {
            if (this.extensionManagerBuilder == null) {
                this.extensionManagerBuilder = ExtensionManager.builder();
            }
            Objects.requireNonNull(config, "config must not be null").accept(this.extensionManagerBuilder);
            return new ProtocolEntityBuilder(this.entityType, this.extensionManagerBuilder);
        }

        /**
         * Mark the entity as having no extensions.
         * This will use an empty extension manager builder instance.
         *
         * @return this builder for chaining
         */
        public ProtocolEntityBuilder noExtensions() {
            return new ProtocolEntityBuilder(this.entityType, ExtensionManager.builder());
        }

    }

}
