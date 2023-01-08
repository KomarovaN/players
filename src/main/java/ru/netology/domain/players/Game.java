package ru.netology.domain.players;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    HashMap<String, Player> regPlayers = new HashMap<>();
    Player player1 = new Player();
    Player player2 = new Player();

    public void register(Player player) {
        regPlayers.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        player1 = findByName(playerName1);
        player2 = findByName(playerName2);
        if (player1 != null) {
            if (player2 != null) {
                if (player1.getStrength() > player2.getStrength()) {
                    return 1;
                } else if (player1.getStrength() < player2.getStrength()) {
                    return -1;
                }
                return 0;
            } else {
                throw new NotRegisteredException("Player with name: " + playerName2 + " not registered.");
            }
        } else {
            throw new NotRegisteredException("Player with name: " + playerName1 + " not registered.");
        }
    }

    public Player findByName(String name) {
        return regPlayers.get(name);
    }
}
