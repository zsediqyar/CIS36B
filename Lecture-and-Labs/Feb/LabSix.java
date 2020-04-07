import java.io.*;
import java.util.Scanner;

class Student {
    int id;
    int dob;
    String firstName;
    String lastName;
    String Address;
    String studentArray[] = new String[200];
    String fileName;

    //get file fileName
    void getFileName() {
      Scanner file = new Scanner(System.in);
      String name = file.next();
      fileName = name;
    }

    //read and write to array
    void readFileAndWriteToArray() {
      try {
        int count = 0;
        java.io.File studentFile = new java.io.File(fileName);
        Scanner file = new Scanner(studentFile);
        while(file.hasNext()) {
            studentArray[count] = file.nextLine();
            count++;
        }
        file.close();
      } catch (Exception e) {
          System.out.println("file name");
      }
        
    }
    
    //print all data to the console.
    void printAll() {
        for(String info : studentArray) {
            if(info != null) {
                System.out.println(info);
            }
        }
    }
}

class LabSix {
    public static void main(String args[]) throws IOException {
      Scanner userInput = new Scanner(System.in);
      Student student = new Student();
      System.out.println("Enter file name:");
      student.getFileName();
      student.readFileAndWriteToArray();
      student.printAll();
    }
}
