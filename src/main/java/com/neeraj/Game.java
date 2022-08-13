package com.neeraj;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private int turn;
    private GameState state;
    private Player winner;

    private enum GameState{
        STARTED,
        FINISHED
    }

    private void init(){
        state = GameState.STARTED;
        turn = 0;
    }

    public void printBoard(){
        board.print();
    }

    public static class GameBuilder{
        Game game;
        public GameBuilder(){
            this.game = new Game();
            this.game.init();
            this.game.board = new Board();
        }
        public GameBuilder(int size){
            this.game = new Game();
            this.game.init();
            this.game.board = new Board(size);
        }
        public GameBuilder addPlayer1(Player player){
            this.game.player1 = player; return this;
        }
        public GameBuilder addPlayer2(Player player){
            this.game.player2 = player; return this;
        }
        public Game build(){
            if ( game.player1 == null){
                throw new Error("You need to add Player 1 before build.");
            }
            if ( game.player2 == null){
                throw new Error("You need to add Player 2 before build.");
            }
            return game;
        }
    }

    public String nextTurnPrompt(){
        return "Player " +
                (turn %2 == 0 ? "1" : "2") + ": Enter box:";
    }

    public boolean isFinished(){
        return state == GameState.FINISHED;
    }

    public boolean play(String box){
        Player currTurnPlayer = turn %2 == 0 ? player1 : player2;
        boolean moveResult = board.makeMove(box, currTurnPlayer.getCh());
        if( moveResult ){
            turn++;
            boolean winResult = board.checkWin( currTurnPlayer.getCh() );
            if( turn >= board.getMaxTurns() && !winResult){
                // all boxes filled and no winner - draw
                winner = null;
                state = GameState.FINISHED;
                printBoard();
                System.out.println("Game drawn...");
                return moveResult;
            }
            if( winResult ){
                System.out.println("****** RESULTS ******");
                winner = currTurnPlayer;
                state = GameState.FINISHED;
                printBoard();
                System.out.println("Player " + winner.getName() + " won...");
            }
        }
        return moveResult;
    }

}
