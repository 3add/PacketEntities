package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ByteEnumView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ChronologicalProtocolEnum;

/**
 * Represents {@link EntityMetaFields.Display#BILLBOARD_RENDER_CONSTRAINTS}
 */
public class DisplayBillboardView extends ByteEnumView<DisplayBillboardView.Constraints> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Display
    public enum Constraints implements ChronologicalProtocolEnum {
        /**
         * No automatic rotation, orientation is fully manual
         */
        FIXED,
        /**
         * The display rotates freely on both axes to always face the camera.
         */
        CENTER,
        /**
         * Rotates only around the vertical (Y) axis to face the camera.
         */
        VERTICAL,
        /**
         * Rotates only around the horizontal axis to face the camera.
         */
        HORIZONTAL
    }

    public DisplayBillboardView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.Display.BILLBOARD_RENDER_CONSTRAINTS, Constraints.class, Constraints.FIXED);
    }

}
