package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ChronologicalProtocolEnum;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.VarIntEnumView;

/**
 * Represents {@link EntityMetaFields.Parrot#VARIANT}
 */
public class ParrotVariantView extends VarIntEnumView<ParrotVariantView.Variant> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Parrot
    public enum Variant implements ChronologicalProtocolEnum {
        RED_BLUE,
        BLUE,
        GREEN,
        YELLO_BLUE,
        GREY
    }

    public ParrotVariantView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Parrot.VARIANT, Variant.class, Variant.RED_BLUE);
    }

}
