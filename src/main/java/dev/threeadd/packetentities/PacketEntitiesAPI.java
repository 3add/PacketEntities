package dev.threeadd.packetentities;

import com.github.retrooper.packetevents.PacketEvents;
import dev.threeadd.packetentities.entity.EntityManager;
import dev.threeadd.packetentities.entity.viewer.ViewerManagerListener;
import dev.threeadd.packetentities.entity.meta.protocol.EntityTypeSchemas;
import dev.threeadd.packetentities.setting.PacketEntitiesAPISettings;

public class PacketEntitiesAPI {

    private final EntityManager entityManager;
    private final PacketEntitiesAPISettings settings;

    public PacketEntitiesAPI(PacketEntitiesAPISettings settings) {
        this.entityManager = new EntityManager();
        this.settings = settings;

        EntityTypeSchemas.init(); // load lazy suppliers
        PacketEvents.getAPI().getEventManager().registerListener(new ViewerManagerListener());
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public PacketEntitiesAPISettings getSettings() {
        return this.settings;
    }

}
