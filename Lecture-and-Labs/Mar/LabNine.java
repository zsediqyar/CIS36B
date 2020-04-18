import java.io.*;
import java.util.*;

//student class with the constructor
class Students {
    String studentId;
    String firstName;
    String lastName;
    String dateOfBirth;
    String address;

    Students() {
        studentId = "";
        firstName = "";
        lastName = "";
        dateOfBirth = "";
        address = "";
    }

    Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Students(String studentId, String firstName, String lastName, String dateOfBirth, String address) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    class sortByLastName implements Comparator<Students> {
        @Override
        public int compare(Students s1, Students s2) {
            return s1.lastName.compareTo(s2.lastName);
        }
    }

    class StudentMethods {
        ArrayList<Students> studentNames = new ArrayList<Students>();
        ArrayList<String> studentsInfo = new ArrayList<String>();

        void readFile() throws IOException {
            try {
                Scanner read = new Scanner(new File("records.text"));
                while (read.hasNextLine()) {
                    studentsInfo.add(read.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("No such file");
            }
        }

        void printAll() {
            for (int i = 0; i < studentsInfo.size(); i++) {
                System.out.println(studentsInfo.get(i));
            }
        }

        void firstNameLastName() {
            String[] studs = new String[studentsInfo.size()];
            for (int i = 0; i < studentsInfo.size(); i++) {
                studs[i] = studentsInfo.get(i);
            }
            System.out.println("-----------------------------");
            for (String line : studs) {
                String[] arr = line.split(" ");
                System.out.println(arr[1] + "\t" + arr[2]);
            }
            System.out.println("-----------------------------");
        }

        void printSortedNames() {
            String studs[] = new String[studentsInfo.size()];
            for (int i = 0; i < studentsInfo.size(); i++) {
                studs[i] = studentsInfo.get(i);
            }
            for (String s : studs) {
                String[] arr = s.split(" ");
                String fname = arr[1];
                String lname = arr[2];
                studentNames.add(new Students(fname, lname));
            }
            Collections.sort(studentNames, new sortByLastName());
            System.out.println(studentNames);
        }

        @Override
        public String toString() {
            return firstName + " \t " + lastName;
        }

        void printAddress() {
            String studs[] = new String[studentsInfo.size()];

            for (int i = 0; i < studentsInfo.size(); i++) {
                studs[i] = studentsInfo.get(i);
            }
            System.out.println("-----------------------------");
            for (String line : studs) {
                String[] arr = line.split(" ");
                System.out.println(arr[arr.length - 1]);
            }
            System.out.println("-----------------------------");
        }
    }
}

// name compare interface

// main class
class LabNine {
    public static void main(String args[]) throws IOException {
        Students s = new Students();
        Students.StudentMethods sm = s.new StudentMethods();

        sm.readFile();
        // sm.printAll();
        // sm.firstNameLastName();
        // sm.printAddress();
        sm.printSortedNames();
        System.out.println(sm.toString());
    }
}