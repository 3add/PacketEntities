package dev.threeadd.packetentities.entity.event;

import dev.threeadd.packetentities.event.Event;

import java.util.Objects;

public final class EntityTickEvent implements Event {

    private final long currentTickCount;

    public EntityTickEvent(long currentTickCount) {
        this.currentTickCount = currentTickCount;
    }

    public long currentTickCount() {
        return this.currentTickCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityTickEvent that = (EntityTickEvent) o;
        return this.currentTickCount == that.currentTickCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currentTickCount);
    }

    @Override
    public String toString() {
        return "EntityTickEvent[" +
                "currentTickCount=" + this.currentTickCount +
                ']';
    }

}
