package dev.threeadd.packetentities.world;

import java.util.Objects;

public final class ProtocolWorld {

    private final String worldName;

    private ProtocolWorld(String worldName) {
        this.worldName = worldName;
    }

    public static ProtocolWorld of(String worldName) {
        return new ProtocolWorld(Objects.requireNonNull(worldName, "world id must not be null"));
    }

    public String getWorldName() {
        return this.worldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProtocolWorld)) return false;
        return Objects.equals(this.worldName, ((ProtocolWorld) o).worldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.worldName);
    }

    @Override
    public String toString() {
        return "ProtocolWorld[" + this.worldName + "]";
    }

}
