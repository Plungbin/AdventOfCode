package adventday1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1 {

  public static void main(String[] args) throws FileNotFoundException {
    int n = 0;

    File file = new File("depth.txt");
    Scanner in = new Scanner(file);

    int prev = in.nextInt();
    int currentDepth = in.nextInt();
    int nextDepth = in.nextInt();

    int sumprev = Integer.MAX_VALUE;
    try {
      while (true) {
        int sumcurr = prev + currentDepth + nextDepth;

        if (sumprev < sumcurr)
        n += 1;
        
        sumprev = sumcurr;
        
        prev = currentDepth;
        currentDepth = nextDepth;
        nextDepth = in.nextInt();
      }

    } catch (Exception e) {
      System.out.print(n);
      in.close();
    }

    // //while (in.hasNextLine()) {

    // // int currentDepth = (int) in.nextLine();
    // // int nextDepth = (int) in.nextLine();
    // int currentDepth = in.nextInt();

    // if (currentDepth > prev)
    // n += 1;
    // prev = currentDepth
    // }
    // System.out.print(n);
    // in.close();

  }
}