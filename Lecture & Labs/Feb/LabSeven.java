import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.*;

class Student {
  int studentId;
  int studentDob;
  String firstName;
  String lastName;
  String Address;
  ArrayList<String> studentsList = new ArrayList<String>();
  String fileName;

  Student() {

  }
  Student(int id, String fName, String lName, int dob, String address) {
    studentId = id;
    firstName = fName;
    lastName = lName;
    studentDob = dob;
    Address = address;
  }

  //get file fileName
  void getFileName() {
    Scanner file = new Scanner(System.in);
    String name = file.next();
    fileName = name;
  }

  //read and write to array
  void readFromFile() {
    try {
      BufferedReader readStudentFile = new BufferedReader(new FileReader(fileName));
      String line = readStudentFile.readLine(); 
      while (line != null) { 
        studentsList.add(line); 
        line = readStudentFile.readLine(); 
      } 
      readStudentFile.close();
    } catch (Exception e) {
      System.out.println("file name");
    }
  }
  
  //print all data to the console.
  void printAll() {
    for(String info : studentsList) {
      if(info != null) {
        System.out.println(info);
      }
    }
  }

  //write to array
  void writeToArray() throws IOException {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter Student ID: ");
    studentId = userInput.nextInt();
    System.out.println("Enter Student First Name: ");
    firstName = userInput.next();
    System.out.println("Enter Student Last Name: ");
    lastName = userInput.next();
    System.out.println("Enter Student DOB: ");
    studentDob = userInput.nextInt();
    System.out.println("Enter Student Address: ");
    Address = userInput.next();
    studentsList.add(Student(studentId, firstName, lastName, studentDob, Address));
  }
  
  //write back to file
  void writeToFile() {
    FileWriter file = new FileWriter(fileName);
    BufferedWriter br = new BufferedWriter(file);
    for(int i = 0; i < studentsList.size(); i++) {
      file.write(studentsList.get(i));
    }
    br.close();
  }
}

class Append extends Student {
  Append() {
    writeToArray();
    writeToFile();
  }
}

class Main {
  public static void main(String args[]) throws IOException {
    Scanner userInput = new Scanner(System.in);
    Student student = new Student();
    System.out.println("Enter file name:");
    student.getFileName();
    student.readFromFile();
    student.printAll();


  }
}
