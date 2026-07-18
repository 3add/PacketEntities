package dev.threeadd.packetentities.spigot;

import dev.threeadd.packetentities.platform.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperTaskScheduler implements TaskScheduler {

    private final JavaPlugin plugin;

    public PaperTaskScheduler(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Runnable scheduleEveryTick(Runnable task) {
        return Bukkit.getScheduler().runTaskTimer(this.plugin, task, 0, 1)::cancel;
    }

}
