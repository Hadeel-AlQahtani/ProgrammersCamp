package array.of.multiples;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayOfMultiples {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number and the length -->  FirstNum  Length");

        System.out.println("Array of Multiples: " + CreatMultiplesArray(input.nextInt() , input.nextInt()).toString());
    }

    public static ArrayList<Integer> CreatMultiplesArray(int num , int length) {

        ArrayList<Integer> multiples = new ArrayList<>();

        for (int i = 1; i <= length; i++) {
            multiples.add(num * i);
        }
        return multiples;
    }

}
