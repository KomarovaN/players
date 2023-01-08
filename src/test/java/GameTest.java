package ru.netology.domain.players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Player 1", 100);
    Player player2 = new Player(2, "Player 2", 200);
    Player player3 = new Player(3, "Player 3", 100);
    Player player4 = new Player(4, "Player 4", 10);

    @Test
    public void shouldNotRegisteredExceptionPlayerName1() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player2.getName());
        });
    }

    @Test
    public void shouldNotRegisteredExceptionPlayerName2() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player3.getName());
        });
    }

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(player2, game.findByName(player2.getName()));
    }

    @Test
    public void shouldFindByNameNoExists() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(null, game.findByName(player4.getName()));
    }

    @Test
    public void shouldRoundPlayer1Winer() {
        game.register(player1);
        game.register(player4);

        int actual = game.round(player1.getName(), player4.getName());
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void shouldRoundPlayer2Winer() {
        game.register(player1);
        game.register(player2);

        int actual = game.round(player1.getName(), player2.getName());
        Assertions.assertEquals(-1, actual);
    }

    @Test
    public void shouldRoundNoWiner() {
        game.register(player1);
        game.register(player3);

        int actual = game.round(player1.getName(), player3.getName());
        Assertions.assertEquals(0, actual);
    }
}
