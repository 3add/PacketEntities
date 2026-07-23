package dev.threeadd.packetentities.event;

/**
 * A priority for {@link Event}s in the {@link EventBus}, in order of relevance
 * (lowest called first, highest called last).
 */
public enum EventPriority {
    HIGHEST(0),
    HIGH(1),
    NORMAL(2),
    LOW(3),
    LOWEST(4);

    private final int slot;

    EventPriority(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return this.slot;
    }
}
