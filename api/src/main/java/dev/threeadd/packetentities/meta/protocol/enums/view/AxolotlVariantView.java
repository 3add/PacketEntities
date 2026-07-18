package dev.threeadd.packetentities.meta.protocol.enums.view;

import dev.threeadd.packetentities.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.meta.protocol.enums.ChronologicalProtocolEnum;
import dev.threeadd.packetentities.meta.protocol.enums.VarIntEnumView;

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

