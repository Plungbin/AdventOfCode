package adventday1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportRepair {

    public static void main (String[]args) throws FileNotFoundException{
        ArrayList<String> data = numbersInArrayString("puzzles.txt");
        int[] numbers = numbersInIntTab(data);
        int result = secondCase(numbers);
        System.out.println(result);

    }

    public static ArrayList<String> numbersInArrayString (String fileName) throws FileNotFoundException {

        File puzzles = new File(fileName);
        Scanner scanner = new Scanner(puzzles);
        ArrayList<String> numbersArray = new ArrayList<String>();
        
        while (scanner.hasNextLine()) {

            String nextNumber = scanner.nextLine();

            numbersArray.add(nextNumber);

        }
        scanner.close();
        return numbersArray;       
    }

    public static int[] numbersInIntTab(ArrayList<String> numbersArray) {

        int[] tabInt = new int[numbersArray.size()];
        for (int x = 0; x < numbersArray.size(); x++) {
            tabInt[x] = Integer.parseInt(numbersArray.get(x));

        }

        return tabInt;
    }
    
    public static int firstCase(int[] numbers) {
        int result = 0;
        for (int x = 0; x < numbers.length; x++) {
            for (int i = 0; i < numbers.length; i++) {

                if ((numbers[x] + numbers[i] == 2020) && (x != i)) {
                    result = numbers[x] * numbers[i];
                }
            }
        }

        return result;
    }

    public static int secondCase(int[] numbers) {
        int result = 0;
        for (int x = 0; x < numbers.length; x++) {
            for (int i = 0; i < numbers.length; i++) {
                for (int z = 0; z < numbers.length; z++) {

                    if ((numbers[x] + numbers[i] + numbers[z] == 2020) && (x != i && x != z && z != i)) {
                        result = numbers[x] * numbers[i] * numbers[z];
                    }
                }
            }
        }

        return result;
    }

}   

/*
After saving Christmas five years in a row, you've decided to take a vacation at a nice resort on a tropical island. Surely, Christmas will go on without you.

The tropical island has its own currency and is entirely cash-only. The gold coins used there have a little picture of a starfish; the locals just call them stars. None of the currency exchanges seem to have heard of them, but somehow, you'll need to find fifty of these coins by the time you arrive so you can pay the deposit on your room.

To save your vacation, you need to get all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.

Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456
In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?

Your puzzle answer was 1010884.

--- Part Two ---
The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

In your expense report, what is the product of the three entries that sum to 2020?

Your puzzle answer was 253928438.

Both parts of this puzzle are complete! They provide two gold stars: **

At this point, you should return to your Advent calendar and try another puzzle.

If you still want to see it, you can get your puzzle input.

You can also [Share] this puzzle.
*/
