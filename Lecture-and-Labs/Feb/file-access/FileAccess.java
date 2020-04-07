import java.io.*;
import java.util.Scanner;

class FileAccess {
    public static void main(String args[]) throws FileNotFoundException {
        java.io.File x = new java.io.File("sample.text");

        Scanner input = new Scanner(x);

        String[] holder_array = new String[10];
        int count = 0;

        while (input.hasNext()) {
            holder_array[count] = input.nextLine();
            count++;
        }

        for (String string_values : holder_array) {
            if (string_values != null) {
                System.out.println(string_values);
            }
        }
    }
}