package TicTacToe_V2;

import java.util.*;

public class TicTacToeV2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean invalid = true;
        String mode = "", turn;

        System.out.print("Welcome to 3x3 Tic Tac Toe.\n"
                + "Enter '1' to play against Computer, or '2' to play against another player: ");

        while (invalid) {

            mode = input.next();

            if (mode.matches("[12]")) {
                System.out.println("\nGame mode: against " + (mode.equals("1") ? "the computer" : "another player"));
                System.out.println("");
                TicTacToe.printBoard();
                break;
            } else {
                System.out.println("wrong input!! try again..");
            }
        }

        TicTacToe.setMultiPlay(mode.equals("2"));

        for (int i = 1; i < 10; i++) {
            turn = i % 2 == 0 ? "O" : "X";
            
            TicTacToe.play(turn);
        }

        System.out.println("Draw!! Thanks for playing.");

    }

}
