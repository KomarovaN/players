package ru.netology.domain.players;

public class Player {
    int id;
    String name;
    int strength;

    public Player() {

    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}
