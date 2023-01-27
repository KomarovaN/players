package ru.netology.domain.players;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> regPlayers = new ArrayList<>();
    
    public void register(Player player) {
        regPlayers.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = new Player();
        Player player2 = new Player();
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
        for (Player player : regPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
