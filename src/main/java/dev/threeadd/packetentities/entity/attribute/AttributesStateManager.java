package dev.threeadd.packetentities.entity.attribute;

import com.github.retrooper.packetevents.protocol.attribute.Attribute;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateAttributes;
import dev.threeadd.packetentities.entity.ProtocolEntity;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;
import java.util.List;

@ApiStatus.Internal
public class AttributesStateManager {

    private final ProtocolEntity entity;
    private AttributesState attributesState;

    public AttributesStateManager(ProtocolEntity entity, List<WrapperPlayServerUpdateAttributes.Property> initialProperties) {
        this.entity = entity;
        this.attributesState = new AttributesState(initialProperties);
    }

    public AttributesState getAttributesState() {
        return this.attributesState;
    }

    public void setAttribute(Attribute attribute, double value, List<WrapperPlayServerUpdateAttributes.PropertyModifier> modifiers) {
        updateState(this.attributesState.with(attribute, value, modifiers));
    }

    public void setAttribute(Attribute attribute, double value, WrapperPlayServerUpdateAttributes.PropertyModifier modifier) {
        updateState(this.attributesState.with(attribute, value, modifier));
    }

    public void setAttribute(Attribute attribute, double value) {
        updateState(this.attributesState.with(attribute, value));
    }

    public void setAttributes(Iterable<WrapperPlayServerUpdateAttributes.Property> properties) {
        updateState(this.attributesState.withAll(properties));
    }

    public void removeModifier(Attribute attribute, WrapperPlayServerUpdateAttributes.PropertyModifier modifier) {
        updateState(this.attributesState.without(attribute, modifier));
    }

    public void removeAttribute(Attribute attribute) {
        updateState(this.attributesState.without(attribute));
    }

    public void removeAttributes(Collection<Attribute> attributes) {
        updateState(this.attributesState.withoutAll(attributes));
    }

    private void updateState(AttributesState newState) {
        this.attributesState = newState;
        dispatchAttributeUpdates();
    }

    private void dispatchAttributeUpdates() {
        if (!this.entity.isSpawned() || this.entity.getViewerCount() == 0) {
            markSynced();
            return;
        }

        if (!this.attributesState.hasChanged()) {
            return;
        }

        List<WrapperPlayServerUpdateAttributes.Property> dirtyProperties = this.attributesState.dirtyProperties();

        if (!dirtyProperties.isEmpty()) {
            this.entity.sendPacketsToViewers(new WrapperPlayServerUpdateAttributes(
                    this.entity.getEntityId(),
                    dirtyProperties
            ));
        }

        markSynced();
    }

    public void markSynced() {
        this.attributesState = this.attributesState.sync();
    }

}
