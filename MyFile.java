//package edu.sjsu.assignment2;
import java.util.Scanner;
//import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
public class MyFile {
    
    public static void writePrimes(String file1, String file2) {
        File inputFile = new File(file1);
        try {
            Scanner in  = new Scanner(inputFile);
            File outputFile = new File(file2);
            PrintWriter out = new PrintWriter(outputFile);
            while(in.hasNextLine()) {
                String curLine = in.nextLine();
                Scanner readLine = new Scanner(curLine);
                readLine.useDelimiter(",|\\n");
                while(readLine.hasNext()) {
                    String curWord = readLine.next();
                    if(checkPrime(curWord)) {
                        out.println(curWord);
                    }
                }
                readLine.close();
            }
            in.close();
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkPrime(String someStr) {
        try {
            int someInt = Integer.parseInt(someStr);
            for (int i = 2; i <= someInt / 2; i++) {
                if (someInt % i == 0) {
                    return false;
                }
            }
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
}
