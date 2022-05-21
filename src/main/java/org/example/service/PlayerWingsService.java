package org.example.service;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.example.model.PlayerWingsData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PlayerWingsService {

    private static final Map<Player, PlayerWingsData> players = new ConcurrentHashMap<>(); // for easy search
    private static final Queue<PlayerWingsData> playersData = new ConcurrentLinkedQueue<>(); // for easy iterating

    public static void updateLocation(final Player player) {
        final PlayerWingsData wingsData = players.get(player);
        if(wingsData == null) return;
        spawnParticles(wingsData);
    }

    public static void add(final PlayerWingsData wingsData) {
        players.put(wingsData.player(), wingsData);
        playersData.add(wingsData);
    }

    public static void remove(final Player player) {
        final PlayerWingsData wingsData = players.get(player);
        playersData.remove(wingsData);
    }

    public static void refreshParticles() {
        playersData.parallelStream()
                   .forEach(PlayerWingsService::spawnParticles);
    }

    private static void spawnParticles(final PlayerWingsData wingsData) {
        wingsData.layout()
                 .getOffsets()
                 .parallelStream()
                 .forEach(offset -> wingsData.player()
                         // TODO handle different direction than default
                                             .spawnParticle(wingsData.particle(),
                                                            wingsData.player().getLocation(),
                                                            1,
                                                            offset.x(),
                                                            offset.y(),
                                                            offset.z()));
    }
}
