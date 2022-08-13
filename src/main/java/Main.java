import com.neeraj.Game;
import com.neeraj.Player;

import java.util.Scanner;

public class Main {

    private final static char player1Ch = 'X';
    private final static String player1Name = "abc";
    private final static char player2Ch = '0';
    private final static String player2Name = "qwe";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // create player 1
        System.out.println("Enter com.neeraj.Player 1 Name:");
        String name = scanner.nextLine();
        name = name.isEmpty() ? player1Name : name;
        System.out.println("Enter com.neeraj.Player 1 Character (X):");
        String chStr = scanner.nextLine();
        char ch = chStr.isEmpty() ? player1Ch : chStr.charAt(0);

        Player player1 = new Player.PlayerBuilder()
                .setName(name)
                .setCh(ch)
                .build();

        // create player 2
        System.out.println("Enter com.neeraj.Player 2 Name:");
        name = scanner.nextLine();
        name = name.isEmpty() ? player2Name : name;
        if( name.contentEquals(player1.getName()) )
            throw new Error("com.neeraj.Player must have different name!!");
        System.out.println("Enter com.neeraj.Player 2 Character (0):");
        chStr = scanner.nextLine();
        ch = chStr.isEmpty() ? player2Ch : chStr.charAt(0);
        if( ch == player1.getCh() )
            throw new Error("com.neeraj.Player must have different character!!");
        Player player2 = new Player.PlayerBuilder()
                .setName(name)
                .setCh(ch)
                .build();

        Game game = new Game.GameBuilder(4)
                .addPlayer1(player1)
                        .addPlayer2(player2)
                                .build();

        String box;
        boolean res;
        while( !game.isFinished() ){
            do {
                game.printBoard();
                System.out.println(game.nextTurnPrompt());
                box = scanner.nextLine();
                res = game.play(box);
                System.out.println();
            }while (!res);
        }
    }
}
