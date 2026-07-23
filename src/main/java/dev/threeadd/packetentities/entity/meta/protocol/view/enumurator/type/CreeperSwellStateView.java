package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ProtocolEnum;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.VarIntEnumView;

/**
 * Represents {@link EntityMetaFields.Creeper#SWELL_DIR}
 */
public class CreeperSwellStateView extends VarIntEnumView<CreeperSwellStateView.State> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Creeper
    public enum State implements ProtocolEnum {
        IDLE(-1),
        FUSE(1);

        private final int value;

        State(int value) {
            this.value = value;
        }

        @Override
        public int getProtocolValue() {
            return this.value;
        }
    }

    public CreeperSwellStateView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Creeper.SWELL_DIR, State.class, State.IDLE);
    }

}
