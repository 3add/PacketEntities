package dev.threeadd.packetentities.meta.protocol.enums.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.enums.ChronologicalProtocolEnum;
import dev.threeadd.packetentities.meta.protocol.enums.VarIntEnumView;

/**
 * Represents {@link EntityMetaFields.Salmon#TYPE}
 */
public class SalmonTypeView extends VarIntEnumView<SalmonTypeView.Type> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Salmon
    public enum Type implements ChronologicalProtocolEnum {
        SMALL,
        MEDIUM,
        LARGE
    }

    public SalmonTypeView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Salmon.TYPE, Type.class, Type.MEDIUM);
    }

}
