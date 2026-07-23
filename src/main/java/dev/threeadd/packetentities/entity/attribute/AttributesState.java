package dev.threeadd.packetentities.entity.attribute;

import com.github.retrooper.packetevents.protocol.attribute.Attribute;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateAttributes;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

/**
 * Represents the state of an entity's attributes, including the current properties and the last synced properties.
 * Attributes are stored using maps for O(1) access and modification.
 */
@ApiStatus.Internal
public record AttributesState(
        @Unmodifiable Map<Attribute, WrapperPlayServerUpdateAttributes.Property> currentProperties,
        @Unmodifiable @Nullable Map<Attribute, WrapperPlayServerUpdateAttributes.Property> lastSyncedProperties
) {

    public AttributesState(List<WrapperPlayServerUpdateAttributes.Property> initialProperties) {
        this(toMap(initialProperties), null);
    }

    private static Map<Attribute, WrapperPlayServerUpdateAttributes.Property> toMap(Iterable<WrapperPlayServerUpdateAttributes.Property> props) {
        Map<Attribute, WrapperPlayServerUpdateAttributes.Property> map = new HashMap<>();
        for (WrapperPlayServerUpdateAttributes.Property prop : props) {
            map.put(prop.getAttribute(), prop);
        }
        return map;
    }

    public AttributesState with(Attribute attribute, double value, List<WrapperPlayServerUpdateAttributes.PropertyModifier> modifiers) {
        Map<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new HashMap<>(this.currentProperties);
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
        Map<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new HashMap<>(this.currentProperties);
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
        @Nullable WrapperPlayServerUpdateAttributes.Property existing = this.currentProperties.get(attribute);
        if (existing == null) return this;

        List<WrapperPlayServerUpdateAttributes.PropertyModifier> newModifiers = new ArrayList<>(existing.getModifiers());
        boolean removed = newModifiers.remove(modifier);

        if (!removed) return this;

        Map<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new HashMap<>(this.currentProperties);
        if (newModifiers.isEmpty()) {
            newProperties.remove(attribute);
        } else {
            newProperties.put(attribute, new WrapperPlayServerUpdateAttributes.Property(attribute, existing.getValue(), newModifiers));
        }

        return new AttributesState(newProperties, this.lastSyncedProperties);
    }

    public AttributesState without(Attribute attribute) {
        Map<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new HashMap<>(this.currentProperties);
        newProperties.remove(attribute);
        return new AttributesState(newProperties, this.lastSyncedProperties);
    }

    public AttributesState withoutAll(Collection<Attribute> attributes) {
        Map<Attribute, WrapperPlayServerUpdateAttributes.Property> newProperties = new HashMap<>(this.currentProperties);
        for (Attribute attr : attributes) {
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

        for (Map.Entry<Attribute, WrapperPlayServerUpdateAttributes.Property> entry : this.currentProperties.entrySet()) {
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
        for (Map.Entry<Attribute, WrapperPlayServerUpdateAttributes.Property> entry : this.currentProperties.entrySet()) {
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
