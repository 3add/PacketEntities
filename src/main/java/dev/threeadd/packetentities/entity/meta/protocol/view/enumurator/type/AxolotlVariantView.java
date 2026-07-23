package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ChronologicalProtocolEnum;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.VarIntEnumView;

/**
 * Represents {@link EntityMetaFields.Axolotl#VARIANT}
 */
public class AxolotlVariantView extends VarIntEnumView<AxolotlVariantView.Variant> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Axolotl
    public enum Variant implements ChronologicalProtocolEnum {
        LUCY,
        WILD,
        GOLD,
        CYAN,
        BLUE
    }

    public AxolotlVariantView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Axolotl.VARIANT, Variant.class, Variant.LUCY);
    }

}
