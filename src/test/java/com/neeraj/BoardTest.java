package com.neeraj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    @DisplayName("board init test")
    void test1(){
        Board board = new Board(5);
    }

    @Test
    @DisplayName("max turns test")
    void test2(){
        Board board = new Board(5);
        assertEquals(25, board.getMaxTurns());
    }

    @Test
    @DisplayName("move test")
    void test3(){
        Board board = new Board(5);
        assertEquals(true, board.makeMove("A1", 'X'));
    }

    @Test
    @DisplayName("win test - rows")
    void test4(){
        assertAll(
                () -> {Board board = new Board(3);
                    board.makeMove("A1", 'X');
                    board.makeMove("A2", 'X');
                    board.makeMove("A3", 'X');
                    assertEquals(true, board.checkWin('X'));},
                () -> {Board board = new Board(3);
                    board.makeMove("B1", 'X');
                    board.makeMove("B2", 'X');
                    board.makeMove("B3", 'X');
                    assertEquals(true, board.checkWin('X'));},
                () -> {Board board = new Board(3);
                    board.makeMove("C1", 'X');
                    board.makeMove("C2", 'X');
                    board.makeMove("C3", 'X');
                    assertEquals(true, board.checkWin('X'));}
        );
    }

    @Test
    @DisplayName("win test - columns")
    void test5(){
        assertAll(
                () -> {Board board = new Board(3);
                    board.makeMove("A1", 'X');
                    board.makeMove("B1", 'X');
                    board.makeMove("C1", 'X');
                    assertEquals(true, board.checkWin('X'));},
                () -> {Board board = new Board(3);
                    board.makeMove("A2", 'X');
                    board.makeMove("B2", 'X');
                    board.makeMove("C2", 'X');
                    assertEquals(true, board.checkWin('X'));},
                () -> {Board board = new Board(3);
                    board.makeMove("A3", 'X');
                    board.makeMove("B3", 'X');
                    board.makeMove("C3", 'X');
                    assertEquals(true, board.checkWin('X'));}
        );
    }

    @Test
    @DisplayName("win test - diagonals")
    void test6(){
        assertAll(
                () -> {Board board = new Board(3);
                    board.makeMove("A1", 'X');
                    board.makeMove("B2", 'X');
                    board.makeMove("C3", 'X');
                    assertEquals(true, board.checkWin('X'));},
                () -> {Board board = new Board(3);
                    board.makeMove("A3", 'X');
                    board.makeMove("B2", 'X');
                    board.makeMove("C1", 'X');
                    assertEquals(true, board.checkWin('X'));}
        );
    }

}
