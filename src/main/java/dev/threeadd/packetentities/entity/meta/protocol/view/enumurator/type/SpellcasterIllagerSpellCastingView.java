package dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type;

import dev.threeadd.packetentities.entity.meta.ProtocolEntityMeta;
import dev.threeadd.packetentities.entity.meta.protocol.EntityMetaFields;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ByteEnumView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.ChronologicalProtocolEnum;

/**
 * Represents {@link EntityMetaFields.SpellcasterIllager#SPELL_CASTING}
 */
public class SpellcasterIllagerSpellCastingView extends ByteEnumView<SpellcasterIllagerSpellCastingView.Spell> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Spellcaster_Illager
    public enum Spell implements ChronologicalProtocolEnum {
        NONE,
        SUMMON_VEX,
        ATTACK,
        WOLOLO,
        DISAPPEAR,
        BLINDNESS
    }

    public SpellcasterIllagerSpellCastingView(ProtocolEntityMeta store) {
        super(store, EntityMetaFields.SpellcasterIllager.SPELL_CASTING, Spell.class, Spell.NONE);
    }

}
