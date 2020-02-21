
/* char finder from a string input */
import java.util.Scanner;

public class LabFourTaskTwo {

    public static void printChar(String str) {
        int len = str.length();
        if (len % 2 == 0) {
            char first = str.charAt(len / 2 - 1);
            char second = str.charAt(len / 2);
            System.out.println("First Middle:\t [" + first + "] Second Middle:\t [" + second + "]");
        }
        if (len % 2 != 0) {
            char mid = str.charAt(len / 2);
            System.out.println("Middle Char:\t [" + mid + "]");
        }
        if (len == 1) {
            System.out.println(str);
        }
    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        String userInput;
        System.out.print("Enter a String:\t");
        userInput = scan.nextLine();

        printChar(userInput);
    }
}
