package adventday1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class frequency {

    public static void main (String[] args) throws FileNotFoundException{

        ArrayList<String> data = readData ("adventday1.txt");
        int sumInCase2 = sumOfDigitsCase2(data);
        System.out.print(sumInCase2);
    }

    public static ArrayList<String> readData (String fileName) throws FileNotFoundException{ //przetworzenie danych na ArrayList<String>

        File file = new File (fileName);
        Scanner scanner = new Scanner (file);

        ArrayList<String> allDigitsAndChar = new ArrayList<String> ();

        while (scanner.hasNextLine()){

            String nextDigit = scanner.nextLine();
           
            allDigitsAndChar.add(nextDigit);
            
        }

        return allDigitsAndChar;
    } 
    
    public static int sumOfDigitsCase1 (ArrayList<String> sumElements ){ //Część pierwsza zadania

        int sum = 0 ;
        for (int x=0; x< sumElements.size();  x++){

            sum += Integer.parseInt(sumElements.get(x));
       
    } 
        return sum;
    } 
    public static int sumOfDigitsCase2 (ArrayList<String> sumElements ){ //Część druga zadania

        int sum = 0 ;
        int result = 0;
        ArrayList<Integer> sumElementsInteger = new ArrayList<Integer>();    //elementy z pliku umieszczone w ArrayList<Integer>
        ArrayList<Integer> sumOfNextNumbers = new ArrayList<Integer>();
        
        for (int x=0; x< sumElements.size();  x++) {                        //Zmiana ArrayList<String> na ArrayList<Integer>
            sumElementsInteger.add(Integer.parseInt(sumElements.get(x)));
        }



        for (int x=0; x< sumElementsInteger.size();  x++){                // Stworzenie ArrayList, w której zawarte są sumy kolejnych liczb

            sum += sumElementsInteger.get(x);
            sumOfNextNumbers.add(sum);
        }  
        for ( int y = 0; y< sumOfNextNumbers.size(); y++){
            for (int x = 0; x< sumElementsInteger.size(); x++){
                
                if ((sum + sumElementsInteger.get(x)) == sumOfNextNumbers.get(y)){
                result += sumOfNextNumbers.get(y);
                //break; 
                }
                sum += sumElementsInteger.get(x);
            }
        
        }
        return result;
    }
}

