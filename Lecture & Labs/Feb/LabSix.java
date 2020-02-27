import java.io.*;
import java.util.Scanner;

class StudentLabSix {
    // STRING ARRAY TO STORE DATA INTO
    String studentArray[] = new String[100];

    /*
     * THIS METHOD WILL TAKE AN ARRAY AS AN INPUT FROM THE FILE AND ADD TO THE ABOVE
     * ARRAY
     */
    void addToArray(String str[]) {
        for (int i = 0; i < studentArray.length; i++) {
            studentArray[i] = str[i];
        }
    }

    // THIS METHOD WILL PRINT ALL THE DATA FROM THE ARRAY
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
        // FILE STREAM WITH THE FILE NAME
        java.io.File studentFile = new java.io.File("output.text");
        // SCANNER CLASS OBJECT TO GET DATA AND WRITE TO FILE
        Scanner fromFile = new Scanner(studentFile);
        // TEMPORARY ARRAY TO HOLD DATA
        String tempArray[] = new String[100];
        // OBJECT INSTANCE OF STUDENT CLASS
        StudentLabSix students = new StudentLabSix();
        // COUNT VARIABLE
        int count = 0;

        // LOOPING THROUGH THE DATA FROM THE FILE
        while (fromFile.hasNext()) {
            tempArray[count] = fromFile.nextLine();
            count++;
        }
        // METHOD CALL TO GET ARRAY AS INPUT
        students.addToArray(tempArray);
        // METHOD CALL TO PRINT DATA OF THAT ARRAY
        students.print();

    }
}