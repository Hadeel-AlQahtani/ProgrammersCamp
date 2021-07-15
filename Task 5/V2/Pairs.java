package ArrayOfPairs;

import java.util.*;

public class Pairs {

    String pair;
    double Fnum, Snum;

    //==================CONSTRUCTORS==================
    public Pairs() {
        Fnum = 0;
        Snum = 0;
        pair = "(" + Fnum + ", " + Snum + ")";
    }

    public Pairs(double Fnum , double Snum) {
        this.Fnum = Fnum;
        this.Snum = Snum;
        pair = "(" + Fnum + ", " + Snum + ")";
    }

    public Pairs(Pairs pair) {
        Fnum = pair.getFnum();
        Snum = pair.getSnum();
        this.pair = "(" + Fnum + ", " + Snum + ")";
    }

    //=====================GETTERS====================
    public String getPair() {
        return pair;
    }

    public double getFnum() {
        return Fnum;
    }

    public double getSnum() {
        return Snum;
    }

    //=====================SETTERS====================
    public void setPair(double Fnum , double Snum) {
        pair = "(" + Fnum + ", " + Snum + ")";
    }

    public void setFnum(double Fnum) {
        this.Fnum = Fnum;
    }

    public void setSnum(double Snum) {
        this.Snum = Snum;
    }

    //=====================METHODS====================
    //Create an ArrayList of pairs
    public static ArrayList ArrOfPairs(ArrayList<Double> numbers) {
        Collections.sort(numbers);
        ArrayList<Pairs> ArrPairs = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                ArrPairs.add(new Pairs(numbers.get(i) , numbers.get(j)));
            }
        }
        return ArrPairs;
    }

    //Find pairs in the array that its ##Sum## is equal to the target
    public static ArrayList FindSum(ArrayList<Pairs> ArrPairs , double target) {
        ArrayList<Pairs> ArrSum = new ArrayList<>();
        ArrPairs.stream().filter((ArrPair) -> (ArrPair.getFnum() + ArrPair.getSnum() == target)).forEachOrdered((ArrPair) -> {
            ArrSum.add(new Pairs(ArrPair));
        });
        return ArrSum;
    }

    //Find pairs in the array that its ##Subtract## is equal to the target
    public static ArrayList FindSubtract(ArrayList<Pairs> ArrPairs , double target) {
        ArrayList<Pairs> ArrSub = new ArrayList<>();
        ArrPairs.stream().filter((ArrPair) -> (ArrPair.getSnum() - ArrPair.getFnum() == target)).forEachOrdered((ArrPair) -> {
            ArrSub.add(new Pairs(ArrPair));
        });
        return ArrSub;
    }

    //Find pairs in the array that its ##Multiply## is equal to the target
    public static ArrayList FindMultiply(ArrayList<Pairs> ArrPairs , double target) {
        ArrayList<Pairs> ArrMultiply = new ArrayList<>();
        ArrPairs.stream().filter((ArrPair) -> (ArrPair.getFnum() * ArrPair.getSnum() == target)).forEachOrdered((ArrPair) -> {
            ArrMultiply.add(new Pairs(ArrPair));
        });
        return ArrMultiply;
    }

    //Find pairs in the array that its ##Division## is equal to the target
    public static ArrayList FindDivision(ArrayList<Pairs> ArrPairs , double target) {
        ArrayList<Pairs> ArrDivide = new ArrayList<>();
        ArrPairs.stream().filter((ArrPair) -> (ArrPair.getSnum() / ArrPair.getFnum() == target)).forEachOrdered((ArrPair) -> {
            ArrDivide.add(new Pairs(ArrPair));
        });
        return ArrDivide;
    }

    //====================TOSTRING====================
    @Override
    public String toString() {
        return pair;
    }

}
