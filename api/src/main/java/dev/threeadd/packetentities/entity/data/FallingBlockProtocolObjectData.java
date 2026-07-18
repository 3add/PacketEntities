package dev.threeadd.packetentities.entity.data;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;

public class FallingBlockProtocolObjectData implements ProtocolObjectData {

    private final WrappedBlockState blockState;

    public FallingBlockProtocolObjectData(WrappedBlockState blockState) {
        this.blockState = blockState;
    }

    @Override
    public int getObjectData(ClientVersion version) {
        return this.blockState.getGlobalId();
    }

    @Override
    public EntityType getBoundEntityType() {
        return EntityTypes.FALLING_BLOCK;
    }

}
