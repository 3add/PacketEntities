package dev.threeadd.packetentities.event;

/**
 * Represents an active listener.
 *
 * @see #unsubscribe()
 */
public interface EventSubscription {

    /**
     * @return The priority of this subscription.
     */
    EventPriority priority();

    /**
     * Unregisters this specific listener from the event bus.
     */
    void unsubscribe();

}
