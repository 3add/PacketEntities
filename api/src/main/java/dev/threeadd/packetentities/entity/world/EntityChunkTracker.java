package dev.threeadd.packetentities.entity.world;

import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.util.ChunkKeyUtils;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ApiStatus.Internal
public class EntityChunkTracker {

    private final Long2ObjectMap<Set<ProtocolEntity>> entitiesByChunk = new Long2ObjectOpenHashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(ProtocolEntity entity, double x, double z) {
        long key = ChunkKeyUtils.toLongKey(x, z);
        this.lock.writeLock().lock();
        try {
            this.entitiesByChunk.computeIfAbsent(key, k -> ConcurrentHashMap.newKeySet()).add(entity);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @SuppressWarnings("ConstantConditions")
    public void remove(ProtocolEntity entity, double x, double z) {
        long key = ChunkKeyUtils.toLongKey(x, z);
        this.lock.writeLock().lock();
        try {
            Set<ProtocolEntity> chunkEntities = this.entitiesByChunk.get(key);
            if (chunkEntities == null) return;
            chunkEntities.remove(entity);
            if (chunkEntities.isEmpty()) this.entitiesByChunk.remove(key);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @SuppressWarnings("ConstantConditions")
    public void update(ProtocolEntity entity, double oldLocX, double oldLocZ, double newLocX, double newLocZ) {
        long oldKey = ChunkKeyUtils.toLongKey(oldLocX, oldLocZ);
        long newKey = ChunkKeyUtils.toLongKey(newLocX, newLocZ);

        if (oldKey == newKey) return;

        this.lock.writeLock().lock();
        try {
            Set<ProtocolEntity> old = this.entitiesByChunk.get(oldKey);
            if (old != null) {
                old.remove(entity);
                if (old.isEmpty()) this.entitiesByChunk.remove(oldKey);
            }
            this.entitiesByChunk.computeIfAbsent(newKey, k -> ConcurrentHashMap.newKeySet()).add(entity);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @SuppressWarnings("ConstantConditions")
    @UnmodifiableView
    public Collection<ProtocolEntity> getEntitiesInChunk(int chunkX, int chunkZ) {
        long key = ChunkKeyUtils.toLongKey(chunkX, chunkZ);

        this.lock.readLock().lock();
        try {
            Set<ProtocolEntity> entities = this.entitiesByChunk.get(key);
            return entities != null ? Collections.unmodifiableCollection(entities) : Collections.emptySet();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void clear() {
        this.lock.writeLock().lock();
        try {
            this.entitiesByChunk.clear();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

}
