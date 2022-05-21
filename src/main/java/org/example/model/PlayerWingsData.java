package org.example.model;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

public record PlayerWingsData(Player player,
                              Particle particle,
                              WingsLayout layout) {
}
