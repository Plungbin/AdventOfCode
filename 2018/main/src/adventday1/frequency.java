package adventday1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class frequency {

    public static void main (String[] args) throws FileNotFoundException{

        ArrayList<String> data = readData ("adventday1.txt");
        int sumInCase1 = sumOfDigitsCase1(data);
        System.out.print(sumInCase1);
        System.out.println();
        System.out.println( data.get(4).charAt(1));
        


        

    }

    public static ArrayList<String> readData (String fileName) throws FileNotFoundException{

        File file = new File (fileName);
        Scanner scanner = new Scanner (file);

        ArrayList<String> allDigits = new ArrayList<String> ();

        while (scanner.hasNextLine()){

            String nextDigit = scanner.nextLine();
            allDigits.add(nextDigit);
        }
        return allDigits;
    } 
    
    public static int sumOfDigitsCase1 (ArrayList<String> sumElements ){

        int sum = 0 ;

        for (int x = 0 ; x < sumElements.size(); x++){

            if (sumElements.get(x).charAt(0) == '+')
                sum += sumElements.get(x).charAt(1);
            else
                sum -= sumElements.get(x).charAt(1);

        }
        return sum;  
    }  



}
