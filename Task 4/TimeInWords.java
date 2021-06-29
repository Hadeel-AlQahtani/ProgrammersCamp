package time.in.words;

import java.util.Scanner;

public class TimeInWords {

    //=============================================================
    //=============================================================   
    
    static String[] ones_teens = {"" , "one " , "two " , "three " , "four " , "five " , "six " , "seven " , "eight " , "nine " , "ten " ,
        "eleven " , "twelve " , "thirteen " , "fourteen " , "quarter " , "sixteen " , "seventeen " , "eighteen " , "nineteen "};

    static String[] tens = {"" , "ten " , "twenty " , "half "};

    static boolean past_to = true, validInput = true;

    //=============================================================
    //=============================================================
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter time in a numaric format: -> hour:minutes");

        String[] timeNum = input.next().split(":");

        validInput(timeNum);

        String timeWords = timeInWords(Integer.valueOf(timeNum[0]) , Integer.valueOf(timeNum[1]));

        System.out.println(validInput ? timeWords : "Wrong!! try again");

    }

    //=============================================================
    //======================= M E T H O D S =======================
    //=============================================================
    
    public static String timeInWords(int hour , int minute) {
        return (minute == 0
                ? hours(hour) + " o' clock"
                : minutes(minute) + " " + (past_to ? hours(hour) : hours(hour == 12 ? 1 : hour + 1)));
    }
    
    public static String hours(int hour) {

        if (0 < hour && hour < 13) {
            return ones_teens[hour];
        } else {
            validInput = false;
            return "";
        }

    }

    public static String minutes(int minutes) {

        if (0 < minutes && minutes < 60) {
            if (minutes > 30) { //less than 30 -> past, more than 30 -> to
                minutes = 60 - minutes;
                past_to = false;
            }
            return (minutes == 1 ? "one minute "
                    : (minutes == 15 ? ones_teens[minutes] : minutes == 30 ? tens[minutes / 10]
                                    : tens[minutes > 19 ? minutes / 10 : 0] + ones_teens[minutes < 20 ? minutes : minutes % 10] + "minutes "))
                    + (past_to ? "past" : "to");
        } else {
            validInput = false;
            return "";
        }
    }

    public static void validInput(String[] timeNum) {
        if (timeNum.length != 2) {
            System.out.println("Wrong!! try again");
            System.exit(0);
        } else {
            for (String time : timeNum) {
                if (!time.matches("[\\d]*") || time.isEmpty()) {
                    System.out.println("Wrong!! try again");
                    System.exit(0);
                }
            }
        }
    }
}
