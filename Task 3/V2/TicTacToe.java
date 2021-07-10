package TicTacToe_V2;

import java.util.*;

public class TicTacToe {

    static String[] ArrBoard = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9"};

    static ArrayList<Integer> Arr_X = new ArrayList<>();
    static ArrayList<Integer> Arr_O = new ArrayList<>();

    static boolean multiPlay;

    static String player, pos;

    static Scanner input = new Scanner(System.in);

    //ComputerControl
    static String positions;

    static boolean random;

    //=============================================================
    //======================= M E T H O D S =======================
    //=============================================================
    public static void printBoard() {

        System.out.println("|---|---|---|\n"
                + "| " + ArrBoard[0] + " | " + ArrBoard[1] + " | " + ArrBoard[2] + " |\n"
                + "| " + ArrBoard[3] + " | " + ArrBoard[4] + " | " + ArrBoard[5] + " |\n"
                + "| " + ArrBoard[6] + " | " + ArrBoard[7] + " | " + ArrBoard[8] + " |\n"
                + "|---|---|---|\n");
    }

    public static void setMultiPlay(boolean b) {
        multiPlay = b;
    }

    public static Boolean checkWin(ArrayList arr) {
        if (arr.toString().matches(".*1..2..3.*")
                || arr.toString().matches(".*4..5..6.*")
                || arr.toString().matches(".*7..8..9.*")
                || arr.toString().matches(".*1.*4.*7.*")
                || arr.toString().matches(".*2.*5.*8.*")
                || arr.toString().matches(".*3.*6.*9.*")
                || arr.toString().matches(".*1.*5.*9.*")
                || arr.toString().matches(".*3.*5.*7.*")) {
            return true;
        } else {
            return false;
        }
    }

    public static void play(String turn) {

        player = turn;

        System.out.println("## " + player + "'s turn.");

        boolean once = true, invalidInput = true;
        int i = 0;

        while (invalidInput) {

            if (multiPlay || player.equals("X")) {
                System.out.println("Enter a slot number to place " + player + " in:");
                pos = input.next();
            } else {
                if (once) {
                    ComputerPlay();
                    once = false;
                }
                if (random) {
                    pos = String.valueOf((int) (Math.random() * 10));
                } else {
                    pos = String.valueOf(positions.charAt(i));
                    if (i < 2) {
                        i++;
                    }
                }
            }
            if (!pos.matches("[1-9]")) {
                if (multiPlay || player.equals("X")) {
                    System.out.println("Invalid input! Please enter a number between 1-9.");
                }

            } else if (ArrBoard[Integer.valueOf(pos) - 1].matches("[XO]")) {
                if (multiPlay || player.equals("X")) {
                    System.out.println("Invalid input! This box number is already taken, try again.");
                }

            } else {
                ArrBoard[Integer.valueOf(pos) - 1] = player;

                if (player.equals("X")) {
                    Arr_X.add(Integer.valueOf(pos));
                    Collections.sort(Arr_X);
                } else {
                    Arr_O.add(Integer.valueOf(pos));
                    Collections.sort(Arr_O);
                }
                invalidInput = false;
            }

        }

        printBoard();

        if (checkWin(player.equals("X") ? Arr_X : Arr_O)) {
            System.out.println("Congratulations! " + player + "'s have won! Thanks for playing.");
            System.exit(0);
        }
    }

    //=============================================================
    //====================== Computer Control =====================
    //=============================================================
    public static void ComputerPlay() {

        random = false;
        positions = "";

        if (positions.equals("")) { // check chances of win 
            for (int i = 0; i < 2; i++) {

                ArrayList<Integer> Arr = i == 0 ? Arr_O : Arr_X;
                String XO = i == 0 ? "X" : "O";

                if (Arr.toString().matches(".*[123].*[123].*")
                        && !(ArrBoard[0].equals(XO) || ArrBoard[1].equals(XO) || ArrBoard[2].equals(XO))) {
                    positions = "123";

                } else if (Arr.toString().matches(".*[456].*[456].*")
                        && !(ArrBoard[3].equals(XO) || ArrBoard[4].equals(XO) || ArrBoard[5].equals(XO))) {
                    positions = "456";

                } else if (Arr.toString().matches(".*[789].*[789].*")
                        && !(ArrBoard[6].equals(XO) || ArrBoard[7].equals(XO) || ArrBoard[8].equals(XO))) {
                    positions = "789";

                } else if (Arr.toString().matches(".*[147].*[147].*")
                        && !(ArrBoard[0].equals(XO) || ArrBoard[3].equals(XO) || ArrBoard[6].equals(XO))) {
                    positions = "147";

                } else if (Arr.toString().matches(".*[258].*[258].*")
                        && !(ArrBoard[1].equals(XO) || ArrBoard[4].equals(XO) || ArrBoard[7].equals(XO))) {
                    positions = "258";

                } else if (Arr.toString().matches(".*[369].*[369].*")
                        && !(ArrBoard[2].equals(XO) || ArrBoard[5].equals(XO) || ArrBoard[8].equals(XO))) {
                    positions = "369";

                } else if (Arr.toString().matches(".*[159].*[159].*")
                        && !(ArrBoard[0].equals(XO) || ArrBoard[4].equals(XO) || ArrBoard[8].equals(XO))) {
                    positions = "159";

                } else if (Arr.toString().matches(".*[357].*[357].*")
                        && !(ArrBoard[2].equals(XO) || ArrBoard[4].equals(XO) || ArrBoard[6].equals(XO))) {
                    positions = "357";
                }

                if (!positions.equals("")) {
                    break;
                }
            }
        }
        /*
        
        if (positions.equals("")) { // check chances of playing :)
            for (int i = 0; i < 2; i++) {

                ArrayList<Integer> Arr = i == 0 ? Arr_O : Arr_X;

                if (Arr.toString().matches(".*[123].*")) {
                    positions = "123";
                } else if (Arr.toString().matches(".*[456].*")) {
                    positions = "456";
                } else if (Arr.toString().matches(".*[789].*")) {
                    positions = "789";
                } else if (Arr.toString().matches(".*[147].*")) {
                    positions = "147";
                } else if (Arr.toString().matches(".*[258].*")) {
                    positions = "258";
                } else if (Arr.toString().matches(".*[369].*")) {
                    positions = "369";
                } else if (Arr.toString().matches(".*[159].*")) {
                    positions = "159";
                } else if (Arr.toString().matches(".*[357].*")) {
                    positions = "357";
                }

            }
        }
        
         */
        if (positions.equals("")) { // choose position randomly
            random = true;
        }

    }
}
