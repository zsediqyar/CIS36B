import java.util.Scanner;
import java.util.*;
import java.io.*;

class ClassWork {
    public static void main(String args[]) {
        int userInput = 0;
        int result;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number: ");
        userInput = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                result = i * userInput;
                System.out.println(userInput + " * " + i + "\t => " + result);
            }
        }
    }
}