package dev.threeadd.packetentities.entity;

import com.github.retrooper.packetevents.util.Vector3d;
import dev.threeadd.packetentities.entity.world.EntityChunkTracker;
import dev.threeadd.packetentities.world.ProtocolWorld;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A standard manager for all meta lib created {@link ProtocolEntity}s
 */
public class EntityManager {

    private final Map<ProtocolWorld, Set<ProtocolEntity>> entitiesByWorld = new ConcurrentHashMap<>();
    private final Map<UUID, ProtocolEntity> entitiesByUuidMap = new ConcurrentHashMap<>();

    private final Int2ObjectMap<ProtocolEntity> entitiesByIdMap = new Int2ObjectOpenHashMap<>();
    private final ReentrantReadWriteLock idMapLock = new ReentrantReadWriteLock();

    private final EntityChunkTracker chunkTracker = new EntityChunkTracker();

    public void addEntity(ProtocolEntity entity) {
        this.entitiesByUuidMap.put(entity.getUuid(), entity);

        this.idMapLock.writeLock().lock();
        try {
            this.entitiesByIdMap.put(entity.getEntityId(), entity);
        } finally {
            this.idMapLock.writeLock().unlock();
        }

        Vector3d pos = entity.getTrackedEntity().getWorldState().currentPos();
        this.chunkTracker.add(entity, pos.getX(), pos.getZ());
        this.entitiesByWorld
                .computeIfAbsent(entity.getTrackedEntity().getWorldState().currentWorld(), w -> ConcurrentHashMap.newKeySet())
                .add(entity);
    }

    public void removeEntity(ProtocolEntity entity, boolean despawn) {
        this.entitiesByUuidMap.remove(entity.getUuid());

        this.idMapLock.writeLock().lock();
        try {
            this.entitiesByIdMap.remove(entity.getEntityId());
        } finally {
            this.idMapLock.writeLock().unlock();
        }

        Vector3d pos = entity.getTrackedEntity().getWorldState().currentPos();
        this.chunkTracker.remove(entity, pos.getX(), pos.getZ());

        Set<ProtocolEntity> worldSet = this.entitiesByWorld.get(entity.getTrackedEntity().getWorldState().currentWorld());
        if (worldSet != null) {
            worldSet.remove(entity);
            if (worldSet.isEmpty()) this.entitiesByWorld.remove(entity.getTrackedEntity().getWorldState().currentWorld());
        }

        if (despawn) entity.despawn();
    }


    public void removeEntity(int entityId, boolean despawn) {
        ProtocolEntity entity = getEntity(entityId);
        if (entity != null) {
            removeEntity(entity, despawn);
        }
    }

    public void removeEntity(UUID uuid, boolean despawn) {
        ProtocolEntity entity = this.entitiesByUuidMap.get(uuid);
        if (entity != null) {
            removeEntity(entity, despawn);
        }
    }

    public void clearEntities(boolean despawn) {
        this.idMapLock.writeLock().lock();
        try {
            if (despawn) this.entitiesByIdMap.values().forEach(ProtocolEntity::despawn);
            this.entitiesByIdMap.clear();
        } finally {
            this.idMapLock.writeLock().unlock();
        }

        this.entitiesByUuidMap.clear();
        this.chunkTracker.clear();
        this.entitiesByWorld.clear();
    }

    public @Nullable ProtocolEntity getEntity(UUID uuid) {
        return this.entitiesByUuidMap.get(uuid);
    }

    public @Nullable ProtocolEntity getEntity(int entityId) {
        this.idMapLock.readLock().lock();
        try {
            return this.entitiesByIdMap.get(entityId);
        } finally {
            this.idMapLock.readLock().unlock();
        }
    }

    public boolean containsEntity(UUID uuid) {
        return this.entitiesByUuidMap.containsKey(uuid);
    }

    public boolean containsEntity(int entityId) {
        this.idMapLock.readLock().lock();
        try {
            return this.entitiesByIdMap.containsKey(entityId);
        } finally {
            this.idMapLock.readLock().unlock();
        }
    }

    public @UnmodifiableView Collection<ProtocolEntity> getEntities() {
        this.idMapLock.readLock().lock();
        try {
            return List.copyOf(this.entitiesByIdMap.values());
        } finally {
            this.idMapLock.readLock().unlock();
        }
    }

    public @UnmodifiableView Collection<ProtocolEntity> getEntitiesInChunk(int chunkX, int chunkZ) {
        return this.chunkTracker.getEntitiesInChunk(chunkX, chunkZ);
    }

    public @UnmodifiableView Collection<ProtocolEntity> getEntitiesInWorld(ProtocolWorld world) {
        Set<ProtocolEntity> set = this.entitiesByWorld.get(world);
        return set != null ? Collections.unmodifiableCollection(set) : Collections.emptySet();
    }

    @ApiStatus.Internal
    public void updateEntityChunk(ProtocolEntity entity, double oldX, double oldZ, double newX, double newZ) {
        this.chunkTracker.update(entity, oldX, oldZ, newX, newZ);
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
        this.entitiesByWorld
                .computeIfAbsent(newWorld, w -> ConcurrentHashMap.newKeySet())
                .add(entity);
        this.chunkTracker.remove(entity, oldPos.getX(), oldPos.getZ());
        this.chunkTracker.add(entity, newPos.getX(), newPos.getZ());
    }

}
