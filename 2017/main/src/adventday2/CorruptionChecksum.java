package adventday2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.*;

public class CorruptionChecksum {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<ArrayList<Integer>> list = spreadsheet("puzzles2.txt");
        //int largest = largestNumbersInRow(list);
        //int smallest = smallestNumbersInRow(list);
        int result = case2(list);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> spreadsheet(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<ArrayList<Integer>> speadsheet = new ArrayList<ArrayList<Integer>>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<Integer> row = new ArrayList<Integer>();

            String[] rowString = line.split("\t");
            for (String s : rowString)
                row.add(Integer.valueOf(s));

            speadsheet.add(row);
        }
        scanner.close();
        return speadsheet;

    }

    public static int case2(ArrayList<ArrayList<Integer>> spreadsheet) {

        int diference = 0;
        for (ArrayList<Integer> row : spreadsheet) {
            for (int i : row) {
                for (int x = 0; x < row.size(); x++) {

                    if ((i % row.get(x) == 0) && (i != row.get(x))) {
                        diference +=i/ row.get(x);   
                    }
                }
            }
        }
        return diference;
    }


    public static int largestNumbersInRow(ArrayList<ArrayList<Integer>> spreadsheet) {

        int sum = 0;
        for (ArrayList<Integer> row : spreadsheet)
            sum += Collections.max(row);
        return sum;
    }

    public static int smallestNumbersInRow(ArrayList<ArrayList<Integer>> spreadsheet) {

        int sum = 0;
        for (ArrayList<Integer> row : spreadsheet)
            sum += Collections.min(row);
        return sum;
    }

    public static int calculateCase1(int smallest, int largest) {
        int result = largest - smallest;
        return result;

    }

}



/*
 * --- Day 2: Corruption Checksum ---
 * As you walk through the door, a glowing humanoid shape yells in your
 * direction.
 * "You there! Your state appears to be idle. Come help us repair the corruption in this spreadsheet - if we take another millisecond, we'll have to display an hourglass cursor!"
 * 
 * The spreadsheet consists of rows of apparently-random numbers. To make sure
 * the recovery process is on the right track, they need you to calculate the
 * spreadsheet's checksum. For each row, determine the difference between the
 * largest value and the smallest value; the checksum is the sum of all of these
 * differences.
 * 
 * For example, given the following spreadsheet:
 * 
 * 5 1 9 5
 * 7 5 3
 * 2 4 6 8
 * The first row's largest and smallest values are 9 and 1, and their difference
 * is 8.
 * The second row's largest and smallest values are 7 and 3, and their
 * difference is 4.
 * The third row's difference is 6.
 * In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.
 * 
 * What is the checksum for the spreadsheet in your puzzle input?
 * 
 * Your puzzle answer was 34581.
 * 
 * --- Part Two ---
 * "Great work; looks like we're on the right track after all. Here's a star for your effort."
 * However, the program seems a little worried. Can programs be worried?
 * 
 * "Based on what we're seeing, it looks like all the User wanted is some information about the evenly divisible values in the spreadsheet. Unfortunately, none of us are equipped for that kind of calculation - most of us specialize in bitwise operations."
 * 
 * It sounds like the goal is to find the only two numbers in each row where one
 * evenly divides the other - that is, where the result of the division
 * operation is a whole number. They would like you to find those numbers on
 * each line, divide them, and add up each line's result.
 * 
 * For example, given the following spreadsheet:
 * 
 * 5 9 2 8
 * 9 4 7 3
 * 3 8 6 5
 * In the first row, the only two numbers that evenly divide are 8 and 2; the
 * result of this division is 4.
 * In the second row, the two numbers are 9 and 3; the result is 3.
 * In the third row, the result is 2.
 * In this example, the sum of the results would be 4 + 3 + 2 = 9.
 * 
 * What is the sum of each row's result in your puzzle input?
 * 
 * Your puzzle answer was 214.
 * 
 * Both parts of this puzzle are complete! They provide two gold stars: **
 * 
 * At this point, you should return to your Advent calendar and try another
 * puzzle.
 * 
 * If you still want to see it, you can get your puzzle input.
 * 
 * You can also [Share] this puzzle.
 */
