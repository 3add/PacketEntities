package dev.threeadd.packetentities.setting;

public class PacketEntitiesAPISetting<T> {

    private final T defaultValue;
    private T value;

    public PacketEntitiesAPISetting(T defaultValue) {
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    public T get() {
        return this.value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T getDefault() {
        return this.defaultValue;
    }

    public void reset() {
        this.value = this.defaultValue;
    }

}
