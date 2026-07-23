package dev.threeadd.packetentities.event;

import dev.threeadd.packetentities.PacketEntities;
import it.unimi.dsi.fastutil.objects.*;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.logging.Level;

/**
 * A simple but performant event bus to fit PacketEntities' needs.
 */
public class EventBus {

    private static final SubscriptionImpl<?>[] NO_LISTENERS = new SubscriptionImpl<?>[0];

    private final Reference2ObjectMap<Class<?>, SubscriptionImpl<?>[]> registry = new Reference2ObjectOpenHashMap<>();
    private final Map<Class<?>, SubscriptionImpl<?>[]> postCache = new ConcurrentHashMap<>();

    public <T extends Event> EventBus on(Class<T> eventClass, Consumer<T> handler) {
        return on(eventClass, EventPriority.NORMAL, handler);
    }

    public <T extends Event> EventBus on(Class<T> eventClass, EventPriority priority, Consumer<T> handler) {
        subscribe(eventClass, priority, handler);
        return this;
    }

    public <T extends Event> EventSubscription subscribe(Class<T> eventClass, Consumer<T> handler) {
        return subscribe(eventClass, EventPriority.NORMAL, handler);
    }

    public <T extends Event> EventSubscription subscribe(Class<T> eventClass, EventPriority priority, Consumer<T> handler) {
        SubscriptionImpl<T> subscription = new SubscriptionImpl<>(eventClass, priority, handler);

        synchronized (this.registry) {
            SubscriptionImpl<?>[] current = this.registry.get(eventClass);
            SubscriptionImpl<?>[] updated;

            if (current == null) {
                updated = new SubscriptionImpl<?>[]{subscription};
            } else {
                updated = Arrays.copyOf(current, current.length + 1);
                updated[current.length] = subscription;
            }

            this.registry.put(eventClass, updated);
            invalidateCache(eventClass);
        }

        return subscription;
    }

    public void post(Event event) {
        Class<?> eventClass = event.getClass();
        SubscriptionImpl<?>[] listeners = this.postCache.get(eventClass);

        if (listeners == null) {
            listeners = bakeListeners(eventClass);
            this.postCache.put(eventClass, listeners);
        }

        if (listeners == NO_LISTENERS) return;

        for (SubscriptionImpl<?> listener : listeners) {
            try {
                listener.invoke(event);
            } catch (Throwable t) {
                PacketEntities.getPlatform().getLogger().log(Level.SEVERE, "A listener experienced an error: " + t);
            }
        }
    }

    @ApiStatus.Internal
    public void destroy() {
        synchronized (this.registry) {
            this.registry.clear();
            this.postCache.clear();
        }
    }

    private SubscriptionImpl<?>[] bakeListeners(Class<?> eventClass) {
        synchronized (this.registry) {
            ObjectArrayList<SubscriptionImpl<?>> compiledList = new ObjectArrayList<>();
            ReferenceSet<Class<?>> hierarchy = new ReferenceOpenHashSet<>();

            collectHierarchy(eventClass, hierarchy);

            for (Class<?> clazz : hierarchy) {
                SubscriptionImpl<?>[] exactListeners = this.registry.get(clazz);
                if (exactListeners != null) {
                    compiledList.addElements(compiledList.size(), exactListeners);
                }
            }

            if (compiledList.isEmpty()) {
                return NO_LISTENERS;
            }

            SubscriptionImpl<?>[] bakedArray = compiledList.toArray(new SubscriptionImpl<?>[0]);
            ObjectArrays.stableSort(bakedArray, Comparator.comparingInt(sub -> sub.priority().getSlot()));

            return bakedArray;
        }
    }

    private void collectHierarchy(@Nullable Class<?> clazz, Set<Class<?>> result) {
        if (clazz == null || clazz == Object.class) return;
        if (result.add(clazz)) {
            for (Class<?> iface : clazz.getInterfaces()) {
                collectHierarchy(iface, result);
            }
            collectHierarchy(clazz.getSuperclass(), result);
        }
    }

    private void invalidateCache(Class<?> modifiedClass) {
        this.postCache.keySet().removeIf(modifiedClass::isAssignableFrom);
    }

    private final class SubscriptionImpl<E extends Event> implements EventSubscription {

        private final Class<E> eventClass;
        private final EventPriority priority;
        private final Consumer<E> handler;

        public SubscriptionImpl(Class<E> eventClass, EventPriority priority, Consumer<E> handler) {
            this.eventClass = eventClass;
            this.priority = priority;
            this.handler = handler;
        }

        @Override
        public EventPriority priority() {
            return this.priority;
        }

        public void invoke(Event event) {
            this.handler.accept(this.eventClass.cast(event));
        }

        @Override
        public void unsubscribe() {
            synchronized (EventBus.this.registry) {
                SubscriptionImpl<?>[] current = EventBus.this.registry.get(this.eventClass);
                if (current == null) return;

                int index = -1;
                for (int i = 0; i < current.length; i++) {
                    if (current[i] == this) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    if (current.length == 1) {
                        EventBus.this.registry.remove(this.eventClass);
                    } else {
                        SubscriptionImpl<?>[] updated = new SubscriptionImpl<?>[current.length - 1];
                        System.arraycopy(current, 0, updated, 0, index);
                        System.arraycopy(current, index + 1, updated, index, current.length - index - 1);
                        EventBus.this.registry.put(this.eventClass, updated);
                    }

                    invalidateCache(this.eventClass);
                }
            }
        }

    }

}
