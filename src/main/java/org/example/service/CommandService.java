package org.example.service;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.model.PlayerWingsData;
import org.example.model.WingsLayout;

public class CommandService implements CommandExecutor {

    @Override
    public boolean onCommand(final CommandSender sender,
                             final Command command,
                             final String s,
                             final String[] strings) {
        // /wings true|false particleName layoutName
        if (sender instanceof Player player) {
            if(strings.length != 3) return false;
            final boolean enable = Boolean.parseBoolean(strings[0]);
            if(!enable) {
                PlayerWingsService.remove(player);
                return true;
            }
            final Particle particle = Particle.valueOf(strings[1]);
            final WingsLayout layout = WingsLayout.valueOf(strings[2]);

            PlayerWingsService.add(new PlayerWingsData(player,
                                                       particle,
                                                       layout));
        }
        return false;
    }
}
