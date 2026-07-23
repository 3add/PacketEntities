package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ChronologicalProtocolEnum;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.VarIntEnumView;

/**
 * Represents {@link EntityMetaFields.EnderDragon#PHASE}
 */
public class EnderDragonPhaseView extends VarIntEnumView<EnderDragonPhaseView.Phase> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ender_Dragon
    public enum Phase implements ChronologicalProtocolEnum {
        CIRCLING,
        STRAFING,
        FLYING_TO_PORTAL,
        TAKING_OFF_FROM_PORTAL,
        LANDED_PERFORM_ATTACK,
        LANDED_LOOKING_FOR_PLAYER,
        LANDED_ROAR,
        CHARGING_PLAYER,
        FLYING_TO_PORTAL_TO_DIE,
        HOVERING_NO_AI
    }

    public EnderDragonPhaseView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.EnderDragon.PHASE, Phase.class, Phase.HOVERING_NO_AI);
    }

}
