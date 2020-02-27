import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class StudentLabSeven {
    // ArrayList<String> studentArray = new ArrayList<String>();
    String studentArray[] = new String[100];

    // methods
    void addToArray(String str[]) {
        for (int i = 0; i < studentArray.length; i++) {
            studentArray[i] = str[i];
        }
    }

    void print() {
        for (String info : studentArray) {
            if (info != null) {
                System.out.println(info);
            }
        }
    }

}

class LabSix {
    public static void main(String args[]) throws IOException {
        java.io.File studentFile = new java.io.File("output.text");
        Scanner fromFile = new Scanner(studentFile);
        String tempArray[] = new String[100];
        StudentLabSix students = new StudentLabSix();
        int count = 0;

        while (fromFile.hasNext()) {
            tempArray[count] = fromFile.nextLine();
            count++;
        }
        students.addToArray(tempArray);
        students.print();

    }
}