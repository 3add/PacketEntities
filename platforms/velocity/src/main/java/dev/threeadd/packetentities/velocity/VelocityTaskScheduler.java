package dev.threeadd.packetentities.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.scheduler.ScheduledTask;
import dev.threeadd.packetentities.platform.TaskScheduler;

import java.util.concurrent.TimeUnit;

public class VelocityTaskScheduler implements TaskScheduler {

    private final ProxyServer server;
    private final Object plugin;

    public VelocityTaskScheduler(ProxyServer server, Object plugin) {
        this.server = server;
        this.plugin = plugin;
    }

    @Override
    public Runnable scheduleEveryTick(Runnable task) {
        ScheduledTask scheduledTask = this.server.getScheduler().buildTask(
                        this.plugin, task
                ).repeat(50, TimeUnit.MILLISECONDS)
                .schedule();
        return scheduledTask::cancel;
    }

}
