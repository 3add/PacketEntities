package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ChronologicalProtocolEnum;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.VarIntEnumView;

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
