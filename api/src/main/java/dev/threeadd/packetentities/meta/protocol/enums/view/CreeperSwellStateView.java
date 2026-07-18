package dev.threeadd.packetentities.meta.protocol.enums.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.enums.ProtocolEnum;
import dev.threeadd.packetentities.meta.protocol.enums.VarIntEnumView;

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
