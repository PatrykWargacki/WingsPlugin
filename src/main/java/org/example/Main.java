package org.example;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.listener.PlayerMoveListener;
import org.example.service.CommandService;
import org.example.service.PlayerWingsService;

public class Main extends JavaPlugin {
    private static final PlayerMoveListener listener = new PlayerMoveListener();
    private static final CommandService commandService = new CommandService();

    @Override
    public void onEnable() {
        this.getServer()
            .getPluginManager()
            .registerEvents(listener,
                            this);

        this.getServer()
            .getScheduler()
            .scheduleSyncRepeatingTask(this,
                                       PlayerWingsService::refreshParticles,
                                       0,
                                       100);

        this.getCommand("wings")
            .setExecutor(commandService);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(listener);
    }
}
