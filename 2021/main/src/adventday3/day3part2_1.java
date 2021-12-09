package adventday3;

import java.util.ArrayList;

import javax.swing.event.TreeModelListener;

public class day3part2_1 {
    protectedub
    public static void main(String[] args) {

    }public odczytdanych

    {
        File file = new File("binaryday3.txt");

        Scanner scanner = new Scanner(file);

        ArrayList<String> numbersInArray = new ArrayList<String>();

        while (scanner.hasNextLine()) {

            numbersInArray.add(scanner.nextLine());
            numbersOfLines += 1;

        }

    }

    public int mostCommonNumber(ArrayList<String> numbersInArray, int position) {

        int countOnes = 0;
        
            for (int x = 0; x < numbersInArray.size() - 1; x++) {
                if ((numbersInArray.get(x).charAt(position)) == '1') {
                    countOnes += 1;
                }
            }
        return (countOnes > numbersInArray.size()/2) ? 1 : 0;
    }

    public ArrayList<String> filterByNumberAtPosition(ArrayList<String> lista, int filtr, int position)
    {
        ArrayList<String> toret = new ArrayList<String>();
        for(int x = 0; x < lista.size()-1; x++){
            if (lista.get(x).charAt(position) == filtr){
                toret.add(lista.get(x));
            }
        }
        return toret;
    }

    public void policzOdpowiedź(ArrayList<String> numerki){
        for(int position = 0; position<12-1; position++){
            int mcn = mostCommonNumber(numerki, position);
            numerki = filterByNumberAtPosition(numerki, mcn, position);
        }
        System.out.println(numerki);
    }
    









    // int policzOdpowiedź(String[] numberki){
    //     dla zerowej pozycji
    //         policz mostCommonNumber(numberki, 0)
    //         przefiltruj numberki i zostaw tylko te, które na zerowej pozycji mają mostCommonNumber(numberki, 0)
    //     powtórz dla kolejnych pozycji filtrując za każdym razem
    // }

}