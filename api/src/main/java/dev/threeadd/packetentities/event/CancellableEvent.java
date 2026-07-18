package dev.threeadd.packetentities.event;

public abstract class CancellableEvent implements Event {

    private boolean isCancelled;

    public CancellableEvent() {
        this.isCancelled = false;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Boolean isCancelled() {
        return this.isCancelled;
    }

}
