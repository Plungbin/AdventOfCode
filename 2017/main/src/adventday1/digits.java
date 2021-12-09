
package adventday1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class digits {


    public static void main(String[] args) throws FileNotFoundException {

        int[] tablica = createIntTab("digits.txt");
        //ArrayList<Integer> listaLiczbktoreTrzebaDodac = logicOfCase (tablica);
        ArrayList<Integer> listaLiczbktoreTrzebaDodac = logicOfCase2 (tablica);
        
        int wynik = suma (listaLiczbktoreTrzebaDodac);
        
        System.out.print (wynik);
        

}


    public static int[] createIntTab(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        String allNumbersInDigits = scanner.next();
        scanner.close();
        String[] allNumbersInDigitsTabString = allNumbersInDigits.split("");

        int[] intTab = new int[allNumbersInDigitsTabString.length];

        for (int x = 0; x < allNumbersInDigitsTabString.length; x++) {
            intTab[x] = Integer.parseInt(allNumbersInDigitsTabString[x]);
        }
        return intTab;
    }

    public static ArrayList<Integer> logicOfCase( int [] intTab ){

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int x = 0; x < intTab.length - 1; x++) {
            if (intTab[x] == intTab[x + 1])
                numbers.add(intTab[x]);
        }

        if (intTab[intTab.length - 1] == intTab[0])
            numbers.add(intTab[intTab.length - 1]);

         return numbers ;  
    }

    public static int suma ( ArrayList<Integer> sumElements){
        int sum = 0;

        for (int x = 0; x < sumElements.size(); x++) {
            sum += sumElements.get(x);
        }
        return sum;
    }


    public static ArrayList<Integer> logicOfCase2 (int[] intTab){ //druga część zadania

        int stepsForward = intTab.length/2;

        ArrayList<Integer> selectedNumbers = new ArrayList<Integer>();
    
        for (int x=0; x < intTab.length - stepsForward ; x++ ){
            if (intTab[x] == intTab[x + stepsForward])
                selectedNumbers.add(intTab[x]);
        } 
        
        for (int x=stepsForward;  x < intTab.length - 1; x++){
            if (intTab[x] == intTab[x-stepsForward]);
                selectedNumbers.add(intTab[x]);
        }
        return selectedNumbers;


    }

    
}
