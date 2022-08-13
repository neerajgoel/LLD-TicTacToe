package com.neeraj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    @DisplayName("Game init test")
    void test1(){
        Player pl1 = new Player.PlayerBuilder().setName("a").setCh('x').build();
        Player pl2 = new Player.PlayerBuilder().setName("b").setCh('o').build();
        new Game.GameBuilder().addPlayer1(pl1).addPlayer2(pl2).build();
    }

    @Test
    @DisplayName("Game player 1 test")
    void test2(){
        assertThrows(Error.class, () -> new Game.GameBuilder().build());
    }

    @Test
    @DisplayName("Game player 2 test")
    void test3(){
        assertThrows(Error.class, () -> {
            Player pl = new Player.PlayerBuilder().setName("a").setCh('x').build();
            new Game.GameBuilder().addPlayer1(pl).build();
        });
    }

    @Test
    @DisplayName("Turn prompt test")
    void test4(){
        Player pl1 = new Player.PlayerBuilder().setName("a").setCh('x').build();
        Player pl2 = new Player.PlayerBuilder().setName("b").setCh('o').build();
        Game game = new Game.GameBuilder().addPlayer1(pl1).addPlayer2(pl2).build();
        assertEquals("Player 1: Enter box:", game.nextTurnPrompt());
        game.play("A1");
        assertEquals("Player 2: Enter box:", game.nextTurnPrompt());
    }

    @Test
    @DisplayName("game state test")
    void test5(){
        Player pl1 = new Player.PlayerBuilder().setName("a").setCh('x').build();
        Player pl2 = new Player.PlayerBuilder().setName("b").setCh('o').build();
        Game game = new Game.GameBuilder(2).addPlayer1(pl1).addPlayer2(pl2).build();
        assertEquals(false, game.isFinished());
        game.play("A1");
        game.play("A2");
        game.play("B1");
        game.play("B2");
        assertEquals(true, game.isFinished());
    }
}
