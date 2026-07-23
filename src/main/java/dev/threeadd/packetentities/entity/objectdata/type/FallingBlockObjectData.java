package dev.threeadd.packetentities.entity.objectdata.type;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import dev.threeadd.packetentities.entity.objectdata.BlockStateObjectData;

public class FallingBlockObjectData extends BlockStateObjectData {

    public FallingBlockObjectData(WrappedBlockState blockState) {
        super(EntityTypes.FALLING_BLOCK, blockState);
    }

}
