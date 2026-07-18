package dev.threeadd.packetentities.entity.extension;

import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.entity.event.EntitySpawnEvent;
import dev.threeadd.packetentities.entity.extension.impl.PassengerExtension;
import dev.threeadd.packetentities.entity.extension.impl.PlayerExtension;

/**
 * Used to add additional features to {@link ProtocolEntity}
 *
 * @see PassengerExtension
 * @see PlayerExtension
 */
public interface EntityExtension {

    /**
     * Called right after the entity has been constructed and the extension was attached.
     * @param entity the entity that the extension attached to
     */
    default void onAttach(ProtocolEntity entity) {
    }

    /**
     * Called just before all the entity's data is cleared.
     * This is called after {@link EntitySpawnEvent}.
     * @param entity the entity that the extension detached from
     */
    default void onDetach(ProtocolEntity entity) {
    }

}
