package adventday3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import javax.lang.model.util.ElementScanner6;


public class day3part2 {


 public static void main (String[]args) throws FileNotFoundException {
     
     int numberOfLines = 1; // inicjalizacja zmiennej int, która ma liczyć ile wierszy tekstu zawiera plik binaryday3.txt
     
     File file = new File ("binaryday3.txt"); //czytanie z pliku
     Scanner scanner = new Scanner(file); //czytanie z pliku

     String firstLineOfBinaryNumbers =  scanner.nextLine(); // pobieram pierwszą linię z pliku, aby policzyć ile jest kolumn 
     String[] firstLineOfBinary = firstLineOfBinaryNumbers.split ("");// rozdzielam pierwszą linię i tworzę tablicę Stringów
     

    
       ArrayList <String> numbersInArray = new ArrayList <String> (); // tworzę ArrayList, aby zrobić listę Stringów z poszczególnymi liniami tekstu
                                                                        // Przy okazji liczę ile jest wierszy
        while (scanner.hasNextLine()) { 

       
            numbersInArray.add (scanner.nextLine());

            numberOfLines += 1;

       
        }

    int [] numbersofgamma = new int [(firstLineOfBinary.length) ]; // tworzę nową tablicę, w której zawrę sumę 1 z poszczególnych kolumn 

    
    
    for(  int y =0 ;  y < firstLineOfBinary.length ;   y++){ // dla każdej kolumny (y) sprawdzam wszystkie wiersze (x) jeżeli dany char jest równy 1 
                                                            // to dodaję jego wartość do numbersofgamma i powstaje mi tablica z sumowanymi 1 z każdej z kolumn

        for (int x = 0; x< numberOfLines - 1; x++ ){

        if ((numbersInArray.get(x).charAt(y)) == '1') {

           numbersofgamma [y] += 1;
        
        
        }
    }
    }
    

        int [] BinaryNumbersOfGamma = new int [(firstLineOfBinary.length)]; // tablica która będzie zawierać tylko 1 lub 0 na kazdej z pozycji


        for (int i =0; i < firstLineOfBinary.length ; i++){
            if (numbersofgamma [i]> (numberOfLines/2))
                BinaryNumbersOfGamma [i] = 1;

                else
                BinaryNumbersOfGamma [i] = 0;
        }

        int [] BinaryNumbersOfEpsilon = new int [(firstLineOfBinary.length) ]; // tablica która będzie zawierać tylko 1 lub 0 na kazdej z pozycji

        for (int i = 0; i <firstLineOfBinary.length ; i++){
        if (BinaryNumbersOfGamma[i] == 1)
            BinaryNumbersOfEpsilon[i] = 0;
            else
                BinaryNumbersOfEpsilon[i] = 1;

        }

            String convertGammaToInt = "";                             // konwersja tablicy int do int poprzez String
            for(int i = 0; i < BinaryNumbersOfGamma.length; i++)
                convertGammaToInt += "" + BinaryNumbersOfGamma[i];
                int GammaInt = Integer.parseInt(convertGammaToInt,2); // 2 mówi o tym, że tego Stringa czytamy jak liczbę binarną
                System.out.println(GammaInt);

                System.out.println();
       
            String convertEpsilonToInt = "";
            for(int i = 0; i < BinaryNumbersOfEpsilon.length; i++)
                convertEpsilonToInt += "" + BinaryNumbersOfEpsilon[i];
                int EpsilonInt = Integer.parseInt(convertEpsilonToInt,2);
                System.out.println(EpsilonInt);

                System.out.println();

                System.out.println("wynik ostateczny: " + GammaInt*EpsilonInt);
       
                










            for (int i =0 ; i<BinaryNumbersOfGamma.length; i++ ){

             System.out.print (BinaryNumbersOfGamma[i] + "  ");
            }

                System.out.println();

            for (int i =0 ; i<BinaryNumbersOfGamma.length; i++ ){

                System.out.print (BinaryNumbersOfEpsilon[i] + "  ");
            }

                System.out.println();
      
            for (int i =0 ; i<numbersofgamma.length; i++ ){

                System.out.print (numbersofgamma[i] + "  ");
            }

            



        
            System.out.println();   

     
            System.out.println(numberOfLines);
            System.out.print(firstLineOfBinary.length);
 }


     
     




     
 }








