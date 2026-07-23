package dev.threeadd.packetentities.entity.viewer;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.event.UserDisconnectEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerChunkData;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUnloadChunk;
import dev.threeadd.packetentities.PacketEntities;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;

@ApiStatus.Internal
public class ViewerManagerListener extends PacketListenerAbstract {

    @Override
    @SuppressWarnings("ConstantConditions")
    public void onUserDisconnect(UserDisconnectEvent event) {
        User user = event.getUser();
        if (user == null || user.getUUID() == null) return;

        for (ProtocolEntity entity : PacketEntities.getAPI().getEntityManager().getEntities()) {
            if (entity.isViewer(user.getUUID())) {
                entity.getViewerManager().handleUnload(user);
            }
        }
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void onPacketSend(PacketSendEvent event) {
        User user = event.getUser();
        if (user == null || user.getUUID() == null) return;

        if (event.getPacketType() == PacketType.Play.Server.CHUNK_DATA) {
            handleChunkLoad(event, user);
        } else if (event.getPacketType() == PacketType.Play.Server.UNLOAD_CHUNK) {
            handleChunkUnload(event, user);
        }
    }

    private void handleChunkLoad(PacketSendEvent event, User user) {
        WrapperPlayServerChunkData packet = new WrapperPlayServerChunkData(event);
        Collection<ProtocolEntity> entities = PacketEntities.getAPI().getEntityManager()
                .getEntitiesInChunk(packet.getColumn().getX(), packet.getColumn().getZ());

        if (entities.isEmpty()) return;

        event.getTasksAfterSend().add(() -> {
            for (ProtocolEntity entity : entities) {
                entity.getViewerManager().handleLoad(user);
            }
        });
    }

    private void handleChunkUnload(PacketSendEvent event, User user) {
        WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk(event);
        Collection<ProtocolEntity> entities = PacketEntities.getAPI().getEntityManager()
                .getEntitiesInChunk(packet.getChunkX(), packet.getChunkZ());

        if (entities.isEmpty()) return;

        for (ProtocolEntity entity : entities) {
            if (entity.isViewer(user.getUUID())) {
                entity.getViewerManager().handleUnload(user);
            }
        }
    }

}
