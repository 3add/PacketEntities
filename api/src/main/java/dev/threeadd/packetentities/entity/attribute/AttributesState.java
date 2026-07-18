package dev.threeadd.packetentities.entity.attribute;

import com.github.retrooper.packetevents.protocol.attribute.Attribute;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateAttributes;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;

@ApiStatus.Internal
public record AttributesState(
        @UnmodifiableView Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> currentProperties,
        @UnmodifiableView @Nullable Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> lastSyncedProperties
) {

    public AttributesState {
        currentProperties = Object2ObjectMaps.unmodifiable(new Object2ObjectOpenHashMap<>(currentProperties));
        if (lastSyncedProperties != null) {
            lastSyncedProperties = Object2ObjectMaps.unmodifiable(new Object2ObjectOpenHashMap<>(lastSyncedProperties));
        }
    }

    public AttributesState(List<WrapperPlayServerUpdateAttributes.Property> initialProperties) {
        this(toMap(initialProperties), null);
    }

    private static Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> toMap(Iterable<WrapperPlayServerUpdateAttributes.Property> props) {
        Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> map = new Object2ObjectOpenHashMap<>();
        for (WrapperPlayServerUpdateAttributes.Property prop : props) {
            map.put(prop.getAttribute(), prop);
        }
        return map;
    }

    public AttributesState with(Attribute attribute, double value, List<WrapperPlayServerUpdateAttributes.PropertyModifier> modifiers) {
        Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new Object2ObjectOpenHashMap<>(this.currentProperties);
        newProperties.put(attribute, new WrapperPlayServerUpdateAttributes.Property(attribute, value, modifiers));
        return new AttributesState(newProperties, this.lastSyncedProperties);
    }

    public AttributesState with(Attribute attribute, double value, WrapperPlayServerUpdateAttributes.PropertyModifier modifier) {
        return with(attribute, value, Collections.singletonList(modifier));
    }

    public AttributesState with(Attribute attribute, double value) {
        return with(attribute, value, Collections.emptyList());
    }

    public AttributesState withAll(Iterable<WrapperPlayServerUpdateAttributes.Property> newProps) {
        Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new Object2ObjectOpenHashMap<>(this.currentProperties);
        for (WrapperPlayServerUpdateAttributes.Property newProp : newProps) {
            newProperties.put(newProp.getAttribute(), newProp);
        }
        return new AttributesState(newProperties, this.lastSyncedProperties);
    }

    public AttributesState withAll(WrapperPlayServerUpdateAttributes.Property... newProps) {
        return withAll(Arrays.asList(newProps));
    }

    @SuppressWarnings("ConstantConditions")
    public AttributesState without(Attribute attribute, WrapperPlayServerUpdateAttributes.PropertyModifier modifier) {
        WrapperPlayServerUpdateAttributes.Property existing = this.currentProperties.get(attribute);
        if (existing == null) return this;

        List<WrapperPlayServerUpdateAttributes.PropertyModifier> newModifiers = new ArrayList<>(existing.getModifiers());
        boolean removed = newModifiers.remove(modifier);

        if (!removed) return this;

        Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new Object2ObjectOpenHashMap<>(this.currentProperties);
        if (newModifiers.isEmpty()) {
            newProperties.remove(attribute);
        } else {
            newProperties.put(attribute, new WrapperPlayServerUpdateAttributes.Property(attribute, existing.getValue(), newModifiers));
        }

        return new AttributesState(newProperties, this.lastSyncedProperties);
    }

    public AttributesState without(Attribute attribute) {
        Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new Object2ObjectOpenHashMap<>(this.currentProperties);
        newProperties.remove(attribute);
        return new AttributesState(newProperties, this.lastSyncedProperties);
    }

    public AttributesState withoutAll(Collection<Attribute> attributesToRemove) {
        Object2ObjectMap<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new Object2ObjectOpenHashMap<>(this.currentProperties);
        for (Attribute attr : attributesToRemove) {
            newProperties.remove(attr);
        }
        return new AttributesState(newProperties, this.lastSyncedProperties);
    }

    public AttributesState withoutAll(Attribute... attributesToRemove) {
        return withoutAll(Arrays.asList(attributesToRemove));
    }

    public boolean needsFullSync() {
        return this.lastSyncedProperties == null;
    }

    public boolean hasChanged() {
        if (needsFullSync()) return true;
        if (this.currentProperties.size() != this.lastSyncedProperties.size()) return true;

        for (Object2ObjectMap.Entry<Attribute, WrapperPlayServerUpdateAttributes.Property> entry : this.currentProperties.object2ObjectEntrySet()) {
            WrapperPlayServerUpdateAttributes.Property synced = this.lastSyncedProperties.get(entry.getKey());
            if (!entry.getValue().equals(synced)) {
                return true;
            }
        }
        return false;
    }

    public List<WrapperPlayServerUpdateAttributes.Property> dirtyProperties() {
        if (needsFullSync()) {
            return new ArrayList<>(this.currentProperties.values());
        }

        List<WrapperPlayServerUpdateAttributes.Property> dirty = new ArrayList<>();
        for (Object2ObjectMap.Entry<Attribute, WrapperPlayServerUpdateAttributes.Property> entry : this.currentProperties.object2ObjectEntrySet()) {
            WrapperPlayServerUpdateAttributes.Property current = entry.getValue();
            WrapperPlayServerUpdateAttributes.Property synced = this.lastSyncedProperties.get(entry.getKey());

            if (!current.equals(synced)) {
                dirty.add(current);
            }
        }
        return dirty;
    }

    public AttributesState sync() {
        return new AttributesState(this.currentProperties, this.currentProperties);
    }

}
