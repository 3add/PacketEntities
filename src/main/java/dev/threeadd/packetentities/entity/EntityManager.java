package dev.threeadd.packetentities.entity;

import com.github.retrooper.packetevents.util.Vector3d;
import dev.threeadd.packetentities.world.ProtocolWorld;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A standard, thread safe manager for all meta lib created {@link ProtocolEntity}s
 */
public class EntityManager {

    private final Map<ProtocolWorld, Set<ProtocolEntity>> entitiesByWorld = new ConcurrentHashMap<>();
    private final Map<UUID, ProtocolEntity> entitiesByUuidMap = new ConcurrentHashMap<>();

    // handle with synchronized blocks, thread safety
    private final Int2ObjectMap<ProtocolEntity> entitiesByIdMap = new Int2ObjectOpenHashMap<>();

    private final EntityChunkTracker chunkTracker = new EntityChunkTracker();

    void addEntity(ProtocolEntity entity) {
        this.entitiesByUuidMap.put(entity.getUuid(), entity);

        synchronized (this.entitiesByIdMap) {
            this.entitiesByIdMap.put(entity.getEntityId(), entity);
        }

        Vector3d pos = entity.getWorldStateManager().getWorldState().currentPos();
        this.chunkTracker.add(entity, pos);
        this.entitiesByWorld.computeIfAbsent(entity.getWorldStateManager().getWorldState().currentWorld(), w -> ConcurrentHashMap.newKeySet())
                .add(entity);
    }

    void removeEntity(ProtocolEntity entity) {
        this.entitiesByUuidMap.remove(entity.getUuid());

        synchronized (this.entitiesByIdMap) {
            this.entitiesByIdMap.remove(entity.getEntityId());
        }

        Vector3d pos = entity.getWorldStateManager().getWorldState().currentPos();
        this.chunkTracker.remove(entity, pos);

        Set<ProtocolEntity> worldSet = this.entitiesByWorld.get(entity.getWorldStateManager().getWorldState().currentWorld());
        if (worldSet != null) {
            worldSet.remove(entity);
            if (worldSet.isEmpty())
                this.entitiesByWorld.remove(entity.getWorldStateManager().getWorldState().currentWorld());
        }
    }

    @ApiStatus.Internal
    public void destroy() {
        synchronized (this.entitiesByIdMap) {
            this.entitiesByIdMap.clear();
        }
        this.entitiesByUuidMap.clear();
        this.chunkTracker.destroy();
        this.entitiesByWorld.clear();
    }

    /**
     * This getter is O(1)
     *
     * @param uuid the {@link UUID} of the {@link ProtocolEntity} to retrieve
     * @return the entity or {@code null} if not found
     */
    public @Nullable ProtocolEntity getEntity(UUID uuid) {
        return this.entitiesByUuidMap.get(uuid);
    }

    /**
     * This getter is O(1)
     *
     * @param entityId the entity id of the {@link ProtocolEntity} to retrieve
     * @return the entity or {@code null} if not found
     */
    public @Nullable ProtocolEntity getEntity(int entityId) {
        synchronized (this.entitiesByIdMap) {
            return this.entitiesByIdMap.get(entityId);
        }
    }

    /**
     * This predicate is O(1)
     *
     * @param uuid the {@link UUID} of the {@link ProtocolEntity} to retrieve
     * @return {@link true} if the manager contains an entity with the provided uuid
     */
    public boolean containsEntity(UUID uuid) {
        return this.entitiesByUuidMap.containsKey(uuid);
    }

    /**
     * This predicate is O(1)
     *
     * @param entityId the entity id of the {@link ProtocolEntity} to retrieve
     * @return {@link true} if the manager contains an entity with the provided entity id
     */
    public boolean containsEntity(int entityId) {
        synchronized (this.entitiesByIdMap) {
            return this.entitiesByIdMap.containsKey(entityId);
        }
    }

    /**
     * @return a list of all entities
     */
    public @UnmodifiableView Collection<ProtocolEntity> getEntities() {
        synchronized (this.entitiesByIdMap) {
            return List.copyOf(this.entitiesByIdMap.values());
        }
    }

    /**
     * This getter is O(1)
     *
     * @param chunkX the x coordinate of the chunk
     * @param chunkZ the z coordinate of the chunk
     * @return all the entities in the chunk at the provided chunk coordinates
     */
    public @UnmodifiableView Collection<ProtocolEntity> getEntitiesInChunk(int chunkX, int chunkZ) {
        return this.chunkTracker.getEntitiesInChunk(chunkX, chunkZ);
    }

    /**
     * This getter is O(1)
     *
     * @param world the world of the entities
     * @return all the entities in the provided {@link ProtocolWorld}
     */
    public @UnmodifiableView Collection<ProtocolEntity> getEntitiesInWorld(ProtocolWorld world) {
        Set<ProtocolEntity> set = this.entitiesByWorld.get(world);
        return set != null ? Collections.unmodifiableCollection(set) : Collections.emptySet();
    }

    @ApiStatus.Internal
    public void updateEntityChunk(ProtocolEntity entity, Vector3d oldPosition, Vector3d newPosition) {
        this.chunkTracker.update(entity, oldPosition, newPosition);
    }

    @ApiStatus.Internal
    public void updateEntityWorld(ProtocolEntity entity,
                                  ProtocolWorld oldWorld, Vector3d oldPos,
                                  ProtocolWorld newWorld, Vector3d newPos) {
        Set<ProtocolEntity> oldSet = this.entitiesByWorld.get(oldWorld);
        if (oldSet != null) {
            oldSet.remove(entity);
            if (oldSet.isEmpty()) this.entitiesByWorld.remove(oldWorld);
        }
        this.entitiesByWorld.computeIfAbsent(newWorld, w -> ConcurrentHashMap.newKeySet())
                .add(entity);
        this.chunkTracker.remove(entity, oldPos);
        this.chunkTracker.add(entity, newPos);
    }

}
