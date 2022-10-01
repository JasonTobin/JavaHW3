/**
 * @author Jason Tobin
 * @version 1.0
 * Some words here, MyTime just takes in input from a user, checks it to make sure it's valid and then 
 * prints the time differences after changing to minutes to get the exact time then using integer rounding
 * to change to a actual readable time in military time.
 */
import java.util.Scanner;
public class MyTime {

    public static void printTimeDifference() {
        /**
         * Represents the users input for both entries
         */

         /**
          * @param firstTime, accepts the first and second time from the user
          */
        Scanner someScan = new Scanner(System.in);
        System.out.println("Please enter the first time: ");
        String firstTime = someScan.nextLine();
        System.out.println("Please enter the second time: ");
        String secondTime = someScan.nextLine();

        try {
            if (Integer.parseInt(firstTime) < 0 || Integer.parseInt(secondTime) < 0) { // Time cannot be negative
                IndexOutOfBoundsException excep = new IndexOutOfBoundsException();      // Also checks for able to be an int with parseInt
                throw excep;
            }
            if(Integer.parseInt(firstTime.substring(0, 2)) > 23 || Integer.parseInt(secondTime.substring(0, 2)) > 23) { // Hour marker never goes  > 24 in military time
                IndexOutOfBoundsException excep = new IndexOutOfBoundsException(); // Probably is some better type of exception but im too lazy to find one now; could just throw exception but whatever
                throw excep;
            }
            if(Integer.parseInt(firstTime.substring(2, 4)) > 59 || Integer.parseInt(secondTime.substring(0, 2)) > 59) { // Minute never go above 59, straight to 0
                IndexOutOfBoundsException excep = new IndexOutOfBoundsException();
                throw excep;
            }
            if (firstTime.length() != 4 || secondTime.length() != 4) { // length must be 4
                IndexOutOfBoundsException excep = new IndexOutOfBoundsException();
                throw excep;
            }
            printTimeDifference(firstTime, secondTime);
        }
        catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid Input");
            System.exit(0);
        }
        someScan.close();
        return;
    }

    public static void printTimeDifference(String oneTime, String twoTime) {
        int oneMinutes = 0;
        int twoMinutes = 0;
        int hourMinutes = 60;
        String tempString = "";
        tempString += oneTime.charAt(0); // USE SUBSTRING HERE NEXT TIME
        tempString += oneTime.charAt(1);
        oneMinutes += Integer.parseInt(tempString);
        oneMinutes *= hourMinutes;
        tempString = "";
        tempString += oneTime.charAt(2);
        tempString += oneTime.charAt(3);
        oneMinutes += Integer.parseInt(tempString);
        tempString = "";
        tempString += twoTime.charAt(0);
        tempString += twoTime.charAt(1);
        twoMinutes += Integer.parseInt(tempString);
        twoMinutes *= hourMinutes;
        tempString = "";
        tempString += twoTime.charAt(2);
        tempString += twoTime.charAt(3);
        twoMinutes += Integer.parseInt(tempString);
        if (oneMinutes > twoMinutes) {twoMinutes += 24*hourMinutes;}
        twoMinutes -= oneMinutes;
        oneMinutes = twoMinutes % 60; // This is entirely for readability in the out statment
        twoMinutes = twoMinutes / 60; // Same as ^
        System.out.println(twoMinutes + " hour(s) " + oneMinutes + " minute(s)");
        /** 
         * @return ends the method, but prior to ending it prints the military time statements
         */
        return;

    }
} 