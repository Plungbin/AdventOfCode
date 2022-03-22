package adventday2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PasswordPhilosophy {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> listOfData = scanData("puzzles2.txt");
        String[] dataStringTab = toTabString(listOfData);
        int resultFirstCase = secondCase(dataStringTab);
        System.out.println(resultFirstCase);

    }

    public static ArrayList<String> scanData(String fileName) throws FileNotFoundException {

        File data = new File(fileName);
        Scanner scanner = new Scanner(data);
        ArrayList<String> listOfData = new ArrayList<String>();

        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();
            listOfData.add(nextLine);
        }
        scanner.close();

        return listOfData;
    }

    public static String[] toTabString(ArrayList<String> listOfData) {

        String[] separateData = new String[listOfData.size()];

        for (int i = 0; i < listOfData.size(); i++) {
            separateData[i] = listOfData.get(i);
        }
        return separateData;
    }

    public static int firstCase(String[] dataInStringTab) {
        int result = 0;
        for (String k : dataInStringTab) {
            String[] dataNextLine = k.split(" ");
            String str = dataNextLine[2];
            String letter = dataNextLine[1];
            char c = letter.charAt(0);
            int counter = countChar(str, c);

            String numbers = dataNextLine[0];
            String[] numbersInTab = numbers.split("-");
            int counterOfResult = compare(counter, numbersInTab);
            result += counterOfResult;

        }
        return result;
    }

    public static int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }

        return count;
    }

    public static int compare(int count, String[] numbers) {
        int counter = 0;
        int lowest = Integer.parseInt(numbers[0]);
        int highest = Integer.parseInt(numbers[1]);
        if (count <= highest && count >= lowest) {
            counter++;
        }
        return counter;
    }

    public static int secondCase(String[] dataInStringTab) {

        int result = 0;
        for (String k : dataInStringTab) {
            String[] dataNextLine = k.split(" ");
            String str = dataNextLine[2];
            String letter = dataNextLine[1];
            char c = letter.charAt(0);
            String numbers = dataNextLine[0];
            String[] numbersInTab = numbers.split("-");
            int counterOfResult = counter2(c, str, numbersInTab);
            result += counterOfResult;

        }
        return result;
    }

    public static int counter2(char c, String str, String[] numbers) {

        int counter = 0;
        int lowest = Integer.parseInt(numbers[0]);
        int highest = Integer.parseInt(numbers[1]);

        if ((str.charAt(lowest - 1) == c) ^ (str.charAt(highest - 1) == c))
            counter++;

        return counter;
    }
}
    
/*
--- Day 2: Password Philosophy ---
Your flight departs in a few days from the coastal airport; the easiest way down to the coast from here is via toboggan.

The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day. "Something's wrong with our computers; we can't log in!" You ask if you can take a look.

Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the Official Toboggan Corporate Policy that was in effect when they were chosen.

To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the corrupted database) and the corporate policy when that password was set.

For example, suppose you have the following list:

1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
Each line gives the password policy and then the password. The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.

In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b, but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits of their respective policies.

How many passwords are valid according to their policies?

Your puzzle answer was 378.

--- Part Two ---
While it appears you validated the passwords correctly, they don't seem to be what the Official Toboggan Corporate Authentication System is expecting.

The shopkeeper suddenly realizes that he just accidentally explained the password policy rules from his old job at the sled rental place down the street! The Official Toboggan Corporate Policy actually works a little differently.

Each policy actually describes two positions in the password, where 1 means the first character, 2 means the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!) Exactly one of these positions must contain the given letter. Other occurrences of the letter are irrelevant for the purposes of policy enforcement.

Given the same example list from above:

1-3 a: abcde is valid: position 1 contains a and position 3 does not.
1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
How many passwords are valid according to the new interpretation of the policies?

Your puzzle answer was 280.

Both parts of this puzzle are complete! They provide two gold stars: **

At this point, you should return to your Advent calendar and try another puzzle.

If you still want to see it, you can get your puzzle input.

You can also [Share] this puzzle.
*/


    
