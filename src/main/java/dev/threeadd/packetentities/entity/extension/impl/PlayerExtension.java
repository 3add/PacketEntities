package dev.threeadd.packetentities.entity.extension.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoRemove;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoUpdate;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.entity.event.ViewerHideEntityEvent;
import dev.threeadd.packetentities.entity.event.ViewerShowEntityEvent;
import dev.threeadd.packetentities.entity.extension.EntityExtension;
import dev.threeadd.packetentities.event.EventBus;
import dev.threeadd.packetentities.event.EventPriority;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class PlayerExtension implements EntityExtension {

    private UserProfile profile;
    private GameMode gameMode;
    private int ping;
    private boolean listTab;
    private @Nullable Component customTabName;
    private @Nullable ProtocolEntity entity;

    public PlayerExtension(UserProfile profile, GameMode gameMode, int ping, boolean listTab, @Nullable Component customTabName) {
        this.profile = profile;
        this.gameMode = gameMode;
        this.ping = ping;
        this.listTab = listTab;
        this.customTabName = customTabName;
    }

    public PlayerExtension profile(UserProfile profile) {
        this.profile = profile;
        if (this.entity == null) return this;

        this.entity.despawn();
        this.entity.spawn();
        return this;
    }

    public UserProfile profile() {
        return this.profile;
    }

    public PlayerExtension gameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        if (this.entity == null) return this;

        this.entity.sendPacketsToViewers(createUpdatePacket(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_GAME_MODE,
                WrapperPlayServerPlayerInfo.Action.UPDATE_GAME_MODE));
        return this;
    }

    public GameMode gameMode() {
        return this.gameMode;
    }

    public PlayerExtension ping(int ping) {
        this.ping = ping;
        if (this.entity == null) return this;

        this.entity.sendPacketsToViewers(createUpdatePacket(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LATENCY,
                WrapperPlayServerPlayerInfo.Action.UPDATE_LATENCY));
        return this;
    }

    public int ping() {
        return this.ping;
    }

    public PlayerExtension listedTab(boolean listTab) {
        this.listTab = listTab;
        if (this.entity == null) return this;

        this.entity.sendPacketsToViewers(createUpdatePacket(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LISTED,
                null)); // no equivalent
        return this;
    }

    public boolean listedTab() {
        return this.listTab;
    }

    /**
     * Sets a custom display name for the tab list and updates viewers.
     *
     * @param customTabName the new value
     * @return this extension for chaining
     */
    public PlayerExtension customTabName(@Nullable Component customTabName) {
        this.customTabName = customTabName;
        if (this.entity == null) return this;

        this.entity.sendPacketsToViewers(createUpdatePacket(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_DISPLAY_NAME,
                WrapperPlayServerPlayerInfo.Action.UPDATE_DISPLAY_NAME));
        return this;
    }

    public @Nullable Component customTabName() {
        return this.customTabName;
    }

    @Override
    public void onAttach(ProtocolEntity entity) {
        if (entity.getEntityType() != EntityTypes.PLAYER) {
            throw new IllegalArgumentException("PlayerExtension can only be attached to entities of type PLAYER.");
        }

        this.entity = entity;

        EventBus bus = entity.getEventBus();
        bus.on(ViewerShowEntityEvent.class, EventPriority.HIGHEST,
                        event -> event.addPacketFirst(createUpdatePacket(WrapperPlayServerPlayerInfoUpdate.Action.ADD_PLAYER, WrapperPlayServerPlayerInfo.Action.ADD_PLAYER)))
                .on(ViewerHideEntityEvent.class, event -> event.addPacketLast(createRemovePacket()));
    }

    /*
    1.19.3+ changed the player info packet to a new one that supports multiple actions at once
     */
    private static final boolean NEWER_OR_EQUALS_1_19_3 = PacketEvents.getAPI().getServerManager().getVersion().isNewerThanOrEquals(ServerVersion.V_1_19_3);

    private PacketWrapper<?> createUpdatePacket(WrapperPlayServerPlayerInfoUpdate.Action modernAction, @Nullable WrapperPlayServerPlayerInfo.Action legacyAction) {
        if (NEWER_OR_EQUALS_1_19_3) {
            return new WrapperPlayServerPlayerInfoUpdate(
                    EnumSet.of(modernAction, WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LISTED),
                    new WrapperPlayServerPlayerInfoUpdate.PlayerInfo(getModernPlayerInfoData())
            );
        }

        if (legacyAction == null)
            throw new IllegalArgumentException(modernAction.name() + " is not supported in versions older than 1.19.3");

        return new WrapperPlayServerPlayerInfo(legacyAction, getLegacyPlayerInfoData());
    }

    private WrapperPlayServerPlayerInfo.PlayerData getLegacyPlayerInfoData() {
        return new WrapperPlayServerPlayerInfo.PlayerData(this.customTabName,
                this.profile, this.gameMode, this.ping);
    }

    private WrapperPlayServerPlayerInfoUpdate.PlayerInfo getModernPlayerInfoData() {
        return new WrapperPlayServerPlayerInfoUpdate.PlayerInfo(this.profile, true,
                this.ping, this.gameMode, this.customTabName,
                null // should be good for player entities that don't have a client
        );
    }

    private PacketWrapper<?> createRemovePacket() {
        if (NEWER_OR_EQUALS_1_19_3) {
            return new WrapperPlayServerPlayerInfoRemove(this.profile.getUUID());
        }

        return new WrapperPlayServerPlayerInfo(WrapperPlayServerPlayerInfo.Action.REMOVE_PLAYER, getLegacyPlayerInfoData());
    }

}
