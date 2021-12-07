package adventday2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2   {

public static void main (String[] args)throws FileNotFoundException{
File puzzles = new File ("puzzles2.txt");
Scanner  scan = new Scanner(puzzles);
int n = 0;
int d = 0;
int aim = 0;



while(scan.hasNextLine()) {

String text = scan.nextLine();
String[]arrStr = text.split(" ");

switch (arrStr [0]) {

case "forward":
n = Integer.parseInt (arrStr[1]) + n;
d = d +Integer.parseInt (arrStr[1])*aim;
break;

case "down":
//d= Integer.parseInt (arrStr[1]) + d;
aim = aim + Integer.parseInt (arrStr[1]);
break;

case "up":
//d = d - Integer.parseInt (arrStr[1]);
aim = aim - Integer.parseInt (arrStr[1]);

break;

}

}

System.out.println(n*d);






}


}