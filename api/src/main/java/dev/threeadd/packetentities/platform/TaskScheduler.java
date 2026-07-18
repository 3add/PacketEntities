package dev.threeadd.packetentities.platform;

public interface TaskScheduler {

    /**
     * Schedules a task to run every server tick.
     * @param task the task to run
     * @return A task that when run should cancel the platform scheduled task
     */
    Runnable scheduleEveryTick(Runnable task);

}
