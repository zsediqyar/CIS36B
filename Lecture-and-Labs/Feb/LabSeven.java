import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Student {
  protected String studentId, firstName, lastName, studentDob, Address;
  protected ArrayList<String> studentsList = new ArrayList<String>();

  Student() {
  }

  public void newStudent(String id, String fname, String lname, String dob, String add) {
    studentId = id;
    firstName = fname;
    lastName = lname;
    studentDob = dob;
    Address = add;
  }

  // copy file to arraylist
  void copyToList() throws FileNotFoundException {
    Scanner copyToList = new Scanner(new File("output.text"));
    while (copyToList.hasNextLine()) {
      studentsList.add(copyToList.nextLine());
    }
  }

  // print all data to the console.
  void printAll() {
    for (int i = 0; i < studentsList.size(); i++) {
      System.out.println(studentsList.get(i));
    }
  }
}

class Append extends Student {
  Append(String id, String fname, String lname, String dob, String add) throws IOException {
    newStudent(id, fname, lname, dob, add);
    studentsList.add("\n" + id + "," + fname + "," + lname + "," + dob + "," + add);
    FileWriter newS = new FileWriter("output.text", true);
    Writer out = new BufferedWriter(newS);
    for (int i = 0; i < studentsList.size(); i++) {
      if (studentsList.get(i) != null) {
        out.write(studentsList.get(i).toString());
      } else {
        System.out.println("null");
      }
    }
    out.close();
  }
}

class LabSeven {
  public static void main(String args[]) throws IOException {
    Scanner userInput = new Scanner(System.in);
    Student student = new Student();
    student.copyToList();
    student.printAll();
    System.out.print("Student ID: \t");
    String id = userInput.next();
    System.out.print("Student First Name: \t");
    String fname = userInput.next();
    System.out.print("Student Last Name: \t");
    String lname = userInput.next();
    System.out.print("Student DOB: \t");
    String dob = userInput.next();
    System.out.print("Student Address: \t");
    String add = userInput.next();
    Append newStudent = new Append(id, fname, lname, dob, add);
    student.copyToList();
    student.printAll();
  }
}
