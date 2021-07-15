package ArrayOfPairs;

import java.util.*;

public class ArrayOfPairs {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Double> numbers = new ArrayList<>();
    static ArrayList<Pairs> ArrPairs = new ArrayList<>();
    static ArrayList<Pairs> ProcessPairs = new ArrayList<>();
    static double target;
    static int process;
    static char cont = 'Y';

    public static void main(String[] args) {

        System.out.println("Enter the numbers ( enter -1 to stop ): ");
        CreateNumbersArr();
        ArrPairs = Pairs.ArrOfPairs(numbers);

        ArrayList<Pairs> arrOfPairs = Pairs.ArrOfPairs(numbers);
        
        do {
            System.out.print("\n------------------------------------\n"
                    + "Enter the target: ");
            getTarget();

            System.out.println("\nChoose the process you want to apply to the pairs:\n"
                    + "Summation: 1  ,Subtraction: 2  ,Multiplication: 3  ,Division: 4  ,exit: -1");
            getProcess();
            System.out.println("");

            switch (process) {
                case 1:
                    Summation();
                    System.out.println(ProcessPairs.isEmpty() ? ("There is no pair that its sum equal " + target) : ProcessPairs);
                    break;

                case 2:
                    Subtraction();
                    System.out.println(ProcessPairs.isEmpty() ? ("There is no pair that its subtract equal " + target) : ProcessPairs);
                    break;

                case 3:
                    Multiplication();
                    System.out.println(ProcessPairs.isEmpty() ? ("There is no pair that its multiply equal " + target) : ProcessPairs);
                    break;

                case 4:
                    Division();
                    System.out.println(ProcessPairs.isEmpty() ? ("There is no pair that its divide equal " + target) : ProcessPairs);
                    break;

                case -1:
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid input!! try again...");
                    continue;
            }

            System.out.println("Do you want to apply another process?  ( Y / N )");
            cont = input.next().toUpperCase().charAt(0);
        } while (cont == 'Y');

    }

//=============================================================
//======================= M E T H O D S =======================
//=============================================================
    public static void CreateNumbersArr() {
        while (true) {
            try {
                double num = input.nextDouble();
                if (num == -1) {
                    break;
                }
                numbers.add(num);
            } catch (Exception e) {
                System.out.println("invalid input!!");
                System.exit(0);
            }
        }
    }

    public static void getTarget() {
        try {
            target = input.nextDouble();
        } catch (Exception e) {
            System.out.println("invalid input!!");
            System.exit(0);
        }
    }

    public static void getProcess() {
        try {
            process = input.nextInt();
        } catch (Exception e) {
            System.out.println("invalid input!!");
            System.exit(0);
        }
    }

    public static void Summation() {
        ProcessPairs = Pairs.FindSum(ArrPairs , target);
    }

    public static void Subtraction() {
        ProcessPairs = Pairs.FindSubtract(ArrPairs , target);
    }

    public static void Multiplication() {
        ProcessPairs = Pairs.FindMultiply(ArrPairs , target);
    }

    public static void Division() {
        ProcessPairs = Pairs.FindDivision(ArrPairs , target);
    }
}
