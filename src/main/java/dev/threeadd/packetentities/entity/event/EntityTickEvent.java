package dev.threeadd.packetentities.entity.event;

import dev.threeadd.packetentities.event.Event;

public record EntityTickEvent(long currentTickCount) implements Event {
}
