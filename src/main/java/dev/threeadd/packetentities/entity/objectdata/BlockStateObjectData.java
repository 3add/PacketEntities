package dev.threeadd.packetentities.entity.objectdata;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;

/**
 * Represent an {@link ProtocolObjectData} where the object data {@code int} is a {@link WrappedBlockState}
 */
public abstract class BlockStateObjectData implements ProtocolObjectData {

    private final EntityType boundEntityType;
    private final WrappedBlockState blockState;

    public BlockStateObjectData(EntityType boundEntityType, WrappedBlockState blockState) {
        this.boundEntityType = boundEntityType;
        this.blockState = blockState;
    }

    @Override
    public int getObjectData(ServerVersion version) {
        return this.blockState.getGlobalId();
    }

    @Override
    public EntityType getBoundEntityType() {
        return this.boundEntityType;
    }

}
