package ceasarCipher;

import java.util.Scanner;

public class CeasarCipher {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("----------------------------------------\n"
                + " Welcome to Java Programming Camp!\n"
                + "----------------------------------------\n"
                + "Enter your message: ");

        char[] message = input.nextLine().toCharArray();
        
        System.out.print("Enter the number of shifts: ");

        int shift = input.nextInt();
//      ====================================================
        char[] codedMessage = new char[message.length];

        for (int i = 0; i < message.length; i++) {

            if (Character.isAlphabetic(message[i])) {

                int codedLetter = message[i] + shift;

                if (Character.isLowerCase(message[i]) && codedLetter > 122
                        || Character.isUpperCase(message[i]) && codedLetter > 90) {
                    codedLetter -= 26;
                }
                codedMessage[i] = (char) codedLetter;
            } else {
                codedMessage[i] = message[i];
            }
        }

        System.out.println("Coded message: " + String.valueOf(codedMessage));

    }

}
