package dev.threeadd.packetentities.entity.viewer;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import dev.threeadd.packetentities.PacketEntities;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.entity.event.ViewerShowEntityEvent;
import dev.threeadd.packetentities.entity.event.ViewerHideEntityEvent;
import dev.threeadd.packetentities.event.Event;
import dev.threeadd.packetentities.event.EventBus;
import dev.threeadd.packetentities.event.EventSubscription;
import dev.threeadd.packetentities.util.PacketDispatcher;
import dev.threeadd.packetentities.world.ProtocolWorld;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

@ApiStatus.Internal
public class ViewerManager {

    protected final ProtocolEntity entity;

    // current viewers
    protected final Set<UUID> viewers = ConcurrentHashMap.newKeySet();
    // viewers that are offline/don't have the entity loaded
    protected final Set<UUID> unloadedViewers = ConcurrentHashMap.newKeySet();

    // explicit viewers, added using the addViewer method or the builder, which will always be viewers regardless of rules
    private final Set<UUID> explicitViewers = ConcurrentHashMap.newKeySet();
    private final List<Predicate<User>> dynamicRules = new CopyOnWriteArrayList<>();
    private final List<EventSubscription> triggerSubscriptions = new CopyOnWriteArrayList<>();

    ViewerManager(ProtocolEntity entity, List<Predicate<User>> rules, List<UUID> initialViewers) {
        this.entity = entity;
        this.dynamicRules.addAll(rules);
        this.explicitViewers.addAll(initialViewers);
    }

    public static ViewerManagerBuilder builder() {
        return new ViewerManagerBuilder();
    }

    public @UnmodifiableView Set<UUID> getViewers() {
        Set<UUID> snapshot = new HashSet<>(this.viewers.size() + this.unloadedViewers.size());
        snapshot.addAll(this.viewers);
        snapshot.addAll(this.unloadedViewers);
        return Collections.unmodifiableSet(snapshot);
    }

    public boolean isViewer(UUID uuid) {
        return this.viewers.contains(uuid) || this.unloadedViewers.contains(uuid);
    }

    public int getViewerCount() {
        return this.viewers.size() + this.unloadedViewers.size();
    }

    private static final boolean NEWER_OR_EQUALS_1_20_2 = PacketEvents.getAPI().getServerManager().getVersion().isNewerThanOrEquals(ServerVersion.V_1_20_2);

    public void addViewer(UUID playerUuid, boolean isChunkLoad) {
        if (this.viewers.contains(playerUuid)) return;

        if (!this.entity.isSpawned()) {
            this.unloadedViewers.add(playerUuid);
            return;
        }

        List<PacketWrapper<?>> defaultPackets = new ArrayList<>();
        defaultPackets.add(this.entity.getTrackedEntity().createSpawnPacket());
        /*
        In older versions, meta is included in the spawn packet or is irrelevant to the entity,
        in newer versions we have to send a follow-up metadata packet to apply meta.
         */
        if (NEWER_OR_EQUALS_1_20_2) {
            defaultPackets.add(this.entity.getMeta().createPacket(this.entity.getEntityId(), this.entity.getDataVersion()));
        }

        ViewerShowEntityEvent event = new ViewerShowEntityEvent(defaultPackets, playerUuid, isChunkLoad);
        this.entity.getEventBus().post(event);

        this.unloadedViewers.remove(playerUuid);
        if (event.isCancelled()) {
            return;
        }

        this.viewers.add(playerUuid);

        for (PacketWrapper<?> packet : event.packets()) {
            PacketDispatcher.sendPacket(playerUuid, packet);
        }
    }

    public void removeViewer(UUID playerUuid, boolean isChunkUnload) {
        boolean wasActive = this.viewers.contains(playerUuid);
        boolean wasUnloaded = this.unloadedViewers.contains(playerUuid);

        if (!wasActive && !wasUnloaded) return;

        if (!wasActive) {
            // They were only in unloadedViewers, no packet needed, safe to remove immediately
            this.unloadedViewers.remove(playerUuid);
            return;
        }

        List<PacketWrapper<?>> defaultPackets = new ArrayList<>();
        defaultPackets.add(new WrapperPlayServerDestroyEntities(this.entity.getEntityId()));

        ViewerHideEntityEvent event = new ViewerHideEntityEvent(defaultPackets, playerUuid, isChunkUnload);
        this.entity.getEventBus().post(event);
        if (event.isCancelled()) return;
        this.viewers.remove(playerUuid);

        if (isChunkUnload) {
            this.unloadedViewers.add(playerUuid);
        } else {
            for (PacketWrapper<?> packet : event.packets()) {
                PacketDispatcher.sendPacket(playerUuid, packet);
            }
        }
    }

    public void updateViewer(User user) {
        UUID playerUuid = user.getUUID();
        boolean isTracking = this.viewers.contains(playerUuid) || this.unloadedViewers.contains(playerUuid);

        if (this.shouldSee(user)) {
            boolean wasOffline = this.unloadedViewers.contains(playerUuid);
            this.addViewer(playerUuid, wasOffline);
        } else {
            if (isTracking) {
                this.removeViewer(playerUuid, false);
            }
        }
    }

    public RegisteredViewerRule addViewerRule(Predicate<User> rule) {
        this.dynamicRules.add(rule);
        return () -> this.dynamicRules.remove(rule);
    }

    public <T extends Event> RegisteredViewerRule addUpdateTrigger(EventBus bus, Class<T> eventClass, Function<T, Collection<User>> userExtractor) {
        EventSubscription sub = bus.subscribe(eventClass, event -> {
            Collection<User> usersToUpdate = userExtractor.apply(event);
            if (!usersToUpdate.isEmpty()) {
                usersToUpdate.forEach(this::updateViewer);
            }
        });

        this.triggerSubscriptions.add(sub);

        return () -> {
            sub.unsubscribe();
            this.triggerSubscriptions.remove(sub);
        };
    }

    private boolean shouldSee(User user) {
        // TODO hard coded rule, maybe make entities be able to be in multiple worlds in the future
        ProtocolWorld entityWorld = this.entity.getTrackedEntity().getWorldState().currentWorld();
        ProtocolWorld userWorld = PacketEntities.getPlatform().getWorldProvider().provide(user);
        if (!userWorld.equals(entityWorld)) {
            return false;
        }

        if (!this.explicitViewers.isEmpty() && !this.explicitViewers.contains(user.getUUID())) {
            return false;
        }

        for (Predicate<User> rule : this.dynamicRules) {
            if (!rule.test(user)) return false;
        }

        return true;
    }

    @SuppressWarnings("ConstantConditions")
    public void registerAll() {
        for (User user : PacketEvents.getAPI().getProtocolManager().getUsers()) {
            if (user.getUUID() == null) continue;
            if (!this.shouldSee(user)) continue;
            addViewer(user.getUUID(), false);
        }
    }

    public void unregisterAll() {
        Set<UUID> targets = new HashSet<>();
        targets.addAll(this.viewers);
        targets.addAll(this.unloadedViewers);

        for (UUID uuid : targets) {
            this.removeViewer(uuid, false);
        }
    }

    @SuppressWarnings("ConstantConditions")
    void handleLoad(User user) {
        if (user.getUUID() == null) return;
        this.updateViewer(user);
    }

    @SuppressWarnings("ConstantConditions")
    void handleUnload(User user) {
        UUID playerUuid = user.getUUID();
        if (playerUuid == null) return;
        removeViewer(playerUuid, true);
    }

    public void sendPacketsToViewers(PacketWrapper<?>... wrappers) {
        if (wrappers.length == 0 || this.viewers.isEmpty()) return;

        for (UUID uuid : this.viewers) {
            for (PacketWrapper<?> wrapper : wrappers) {
                PacketDispatcher.sendPacket(uuid, wrapper);
            }
        }
    }

    public void destroy() {
        this.viewers.clear();
        this.unloadedViewers.clear();

        for (EventSubscription sub : this.triggerSubscriptions) {
            sub.unsubscribe();
        }
        this.triggerSubscriptions.clear();
        this.dynamicRules.clear();
        this.explicitViewers.clear();
    }

}
