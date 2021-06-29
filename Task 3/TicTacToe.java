package tic.tac.toe;

import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] pos = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9"};
        ArrayList<Integer> Xarr = new ArrayList<>();
        ArrayList<Integer> Oarr = new ArrayList<>();

        System.out.println("Welcome to 3x3 Tic Tac Toe.\n" + printBoard(pos));

        String player;

        for (int i = 1; i < 10; i++) {

            player = i % 2 == 0 ? "O" : "X";

            System.out.print(i == 1 ? "X will play first. " : player + "'s turn. ");

            boolean invalidInput = true;
            String num;
            while (invalidInput) {
                System.out.println("Enter a slot number to place " + player + " in:");
                num = input.next();

                if (!num.matches("[1-9]")) {
                    System.out.println("Invalid input! Please enter a number between 1-9.");

                } else if (pos[Integer.valueOf(num) - 1].matches("[XO]")) { //!pos[num - 1].equals(String.valueOf(num))
                    System.out.println("Invalid input! This box number is already taken, try again.");

                } else {
                    pos[Integer.valueOf(num) - 1] = player;

                    if (player.equals("X")) {
                        Xarr.add(Integer.valueOf(num));
                        Collections.sort(Xarr);
                    } else {
                        Oarr.add(Integer.valueOf(num));
                        Collections.sort(Oarr);
                    }
                    invalidInput = false;
                }

            }

            System.out.println(printBoard(pos));

            if (checkWin(player.equals("X") ? Xarr : Oarr)) {
                System.out.println("Congratulations! " + player + "'s have won! Thanks for playing.");
                System.exit(0);
            }

        }

        System.out.println("Draw!! Thanks for playing.");

    }

    //=============================================================
    //======================= M E T H O D S =======================
    //=============================================================
    public static String printBoard(String[] pos) {

        return "|---|---|---|\n"
                + "| " + pos[0] + " | " + pos[1] + " | " + pos[2] + " |\n"
                + "| " + pos[3] + " | " + pos[4] + " | " + pos[5] + " |\n"
                + "| " + pos[6] + " | " + pos[7] + " | " + pos[8] + " |\n"
                + "|---|---|---|\n";
    }

    public static Boolean checkWin(ArrayList arr) {

        if (arr.toString().matches(".*1..2..3.*")
                || arr.toString().matches(".*4..5..6.*")
                || arr.toString().matches(".*7..8..9.*")
                || arr.toString().matches(".*1..4..7.*")
                || arr.toString().matches(".*2..5..8.*")
                || arr.toString().matches(".*3..6..9.*")
                || arr.toString().matches(".*1..5..9.*")
                || arr.toString().matches(".*3..5..7.*")) {
            return true;
        } else {
            return false;
        }

    }
}
