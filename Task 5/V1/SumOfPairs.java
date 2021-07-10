package sum.of.pairs;

import java.util.*;

public class SumOfPairs {

    //=============================================================
    //============================================================= 
    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> nums = new ArrayList<>();
    static int target;
    static String[] str;
    static boolean cont;
    static String pair = "";

    //=============================================================
    //============================================================= 
    public static void main(String[] args) {

        System.out.println("Enter the numbers: -> 1 2 3 ...");
        CreateArray();

        System.out.println("Enter the target: ");
        do {
            target = checkInputInt(input.nextLine()) ? Integer.valueOf(str[0]) : -1;
        } while (target == -1);

        if (checkSumOfPairs()) {
            System.out.println("there is at least a pair that its sum equal " + target + "\nthe pairs: " + pair);
        } else {
            System.out.println("there is no pair that its sum equal " + target);
        }
    }

    //=============================================================
    //======================= M E T H O D S =======================
    //=============================================================
    public static void CreateArray() {

        String stringNums = input.nextLine();

        if (checkInputInt(stringNums)) {

            for (String stringNum : str) {
                nums.add(Integer.valueOf(stringNum));
            }
        } else {
            CreateArray();
        }

        Collections.sort(nums);

    }

    //=============================================================
    //=============================================================
    public static boolean checkSumOfPairs() {
        //nums.forEach((numF) -> {
        //nums.forEach((numS) -> {
        //    if ((numF + numS) == target && numF < numS /*&& !numF.equals(numS)*/) {
        //        pair += "(" + numF + ", " + numS + ") ";
        //    }
        //});
        //});
        for (int i = 0; i < nums.size() - 1; i++) {
            int numF = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                int numS = nums.get(j);
                if ((numF + numS) == target/*&& !numF.equals(numS)*/) {
                    pair += "(" + numF + ", " + numS + ") ";
                }
            }
        }
        return !pair.isEmpty();
    }

    //=============================================================
    //=============================================================
    public static boolean checkInputInt(String s) {
        str = s.split(" ");
        for (String string : str) {
            if (!string.matches("\\d*") || string.isEmpty()) {
                System.out.println("wrong input!! try again\n");
                return false;
            }
        }
        return true;
    }

}
