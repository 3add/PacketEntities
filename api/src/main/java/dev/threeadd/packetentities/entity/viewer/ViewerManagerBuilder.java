package dev.threeadd.packetentities.entity.viewer;

import com.github.retrooper.packetevents.protocol.player.User;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import dev.threeadd.packetentities.event.Event;
import dev.threeadd.packetentities.event.EventBus;
import org.jetbrains.annotations.ApiStatus;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class ViewerManagerBuilder {

    private final List<Predicate<User>> rules = new ArrayList<>();
    private final List<UUID> initialViewers = new ArrayList<>();
    private final List<TriggerConfig<?>> pendingTriggers = new ArrayList<>();

    ViewerManagerBuilder() {
    }

    public ViewerManagerBuilder rule(Predicate<User> rule) {
        Objects.requireNonNull(rule, "The viewer rule must not be null");
        this.rules.add(rule);
        return this;
    }

    public ViewerManagerBuilder viewer(UUID viewerId) {
        Objects.requireNonNull(viewerId, "The viewer id must not be null");
        this.initialViewers.add(viewerId);
        return this;
    }

    public ViewerManagerBuilder viewers(Iterable<UUID> viewerIds) {
        Objects.requireNonNull(viewerIds, "The viewer ids must not be null");
        for (UUID id : viewerIds) {
            this.initialViewers.add(id);
        }
        return this;
    }

    public <T extends Event> ViewerManagerBuilder updateOn(EventBus bus, Class<T> eventClass, Function<T, Collection<User>> userExtractor) {
        Objects.requireNonNull(bus, "EventBus cannot be null");
        Objects.requireNonNull(eventClass, "Event class cannot be null");
        Objects.requireNonNull(userExtractor, "User extractor function cannot be null");

        this.pendingTriggers.add(new TriggerConfig<>(bus, eventClass, userExtractor));
        return this;
    }

    @ApiStatus.Internal
    public ViewerManager build(ProtocolEntity entity) {
        ViewerManager manager = new ViewerManager(entity, this.rules, this.initialViewers);

        for (TriggerConfig<?> trigger : this.pendingTriggers) {
            trigger.registerTo(manager);
        }

        return manager;
    }

    private record TriggerConfig<T extends Event>(EventBus bus, Class<T> eventClass,
                                                  Function<T, Collection<User>> userExtractor) {

        void registerTo(ViewerManager manager) {
                manager.addUpdateTrigger(this.bus, this.eventClass, this.userExtractor);
        }

    }

}
