package dev.threeadd.packetentities.entity.viewer;

@FunctionalInterface
public interface RegisteredViewerRule {

    /**
     * Unregisters the associated rule.
     */
    void unregister();

}
