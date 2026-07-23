package dev.threeadd.packetentities.setting;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PacketEntitiesAPISettings {

    private final Map<PacketEntitiesAPISetting<?>, Object> settings = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T get(PacketEntitiesAPISetting<T> setting) {
        return (T) this.settings.getOrDefault(setting, setting.getDefault());
    }

    public <T> PacketEntitiesAPISettings set(PacketEntitiesAPISetting<T> setting, T value) {
        this.settings.put(setting, value);
        return this;
    }

    public <T> PacketEntitiesAPISettings reset(PacketEntitiesAPISetting<T> setting) {
        this.settings.remove(setting);
        return this;
    }

}
