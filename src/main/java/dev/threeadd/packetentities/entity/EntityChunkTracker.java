package dev.threeadd.packetentities.entity;

import com.github.retrooper.packetevents.util.Vector3d;
import dev.threeadd.packetentities.entity.world.EntityWorldStateManager;
import dev.threeadd.packetentities.util.ChunkKeyUtils;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A thread safe tracker for tracking entities by chunk, updated by {@link EntityWorldStateManager}
 * Used by {@link EntityManager} to track entities by chunk.
 */
@ApiStatus.Internal
public class EntityChunkTracker {

    /**
     * {@link ChunkKeyUtils} encoded chunk key to a {@link ConcurrentHashMap#newKeySet()} of {@link ProtocolEntity}s
     */
    private final Long2ObjectMap<Set<ProtocolEntity>> entitiesByChunk = new Long2ObjectOpenHashMap<>();

    void add(ProtocolEntity entity, Vector3d position) {
        long key = ChunkKeyUtils.toLongKey(position);
        synchronized (this.entitiesByChunk) {
            this.entitiesByChunk.computeIfAbsent(key, k -> ConcurrentHashMap.newKeySet()).add(entity);
        }
    }

    @SuppressWarnings("ConstantConditions")
    void remove(ProtocolEntity entity, Vector3d position) {
        long key = ChunkKeyUtils.toLongKey(position);
        synchronized (this.entitiesByChunk) {
            Set<ProtocolEntity> chunkEntities = this.entitiesByChunk.get(key);
            if (chunkEntities == null) return;
            chunkEntities.remove(entity);
            if (chunkEntities.isEmpty()) this.entitiesByChunk.remove(key);
        }
    }

    @SuppressWarnings("ConstantConditions")
    void update(ProtocolEntity entity, Vector3d oldPosition, Vector3d newPosition) {
        long oldKey = ChunkKeyUtils.toLongKey(oldPosition);
        long newKey = ChunkKeyUtils.toLongKey(newPosition);

        if (oldKey == newKey) return;

        synchronized (this.entitiesByChunk) {
            Set<ProtocolEntity> old = this.entitiesByChunk.get(oldKey);
            if (old != null) {
                old.remove(entity);
                if (old.isEmpty()) this.entitiesByChunk.remove(oldKey);
            }
            this.entitiesByChunk.computeIfAbsent(newKey, k -> ConcurrentHashMap.newKeySet()).add(entity);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @UnmodifiableView Collection<ProtocolEntity> getEntitiesInChunk(int chunkX, int chunkZ) {
        long key = ChunkKeyUtils.toLongKey(chunkX, chunkZ);

        synchronized (this.entitiesByChunk) {
            Set<ProtocolEntity> entities = this.entitiesByChunk.get(key);
            return entities != null ? List.copyOf(entities) : List.of();
        }
    }

    void destroy() {
        synchronized (this.entitiesByChunk) {
            this.entitiesByChunk.clear();
        }
    }

}
