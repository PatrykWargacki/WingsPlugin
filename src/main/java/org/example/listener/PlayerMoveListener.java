package org.example.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.example.service.PlayerWingsService;

public class PlayerMoveListener
       implements Listener {

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event) {
        if(event.getFrom().equals(event.getTo())) return; // did not move
        PlayerWingsService.updateLocation(event.getPlayer());
    }
}
