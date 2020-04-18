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
    }

    Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Students(String studentId, String firstName, String lastName, String dateOfBirth, String address) {
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

        void printUnsortedNames() {
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

        void sortNames() {
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
        }

        void printSortedNames() {
            Iterator itr = studentNames.iterator();
            while (itr.hasNext()) {
                Students stud = (Students) itr.next();
                System.out.println(stud.firstName + "\t" + stud.lastName);
            }
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

        void searchAndPrint(String name) {
            String[] studs = new String[studentsInfo.size()];
            for (int i = 0; i < studentsInfo.size(); i++) {
                studs[i] = studentsInfo.get(i);
            }
            System.out.println("---------------------------------------");
            for (String line : studs) {
                String[] arr = line.split(" ");
                if (Arrays.asList(arr).contains(name)) {
                    System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4]);
                } else {
                    System.out.println("No Such Record");
                }
            }
            System.out.println("---------------------------------------");
        }
    }

    class Menu {
        void showMenu() {
            System.out.println("Enter # to Run Program or Quit");
            System.out.println("1:\t Print Student First and Last Name");
            System.out.println("2:\t Print Student Address Only");
            System.out.println("3:\t Print all Student Info");
            System.out.println("4:\t Search Student by Lastname and Print all Info");
            System.out.println("5:\t Quit");
        }

    }
}

// main class
class LabNine {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String selection;
        int key = 0;
        Students s = new Students();
        Students.StudentMethods sm = s.new StudentMethods();
        Students.Menu menu = s.new Menu();
        menu.showMenu();
        sm.readFile();
        key = sc.nextInt();

        if (key == 1) {
            System.out.println("Sort it by Lastname?\t(Y,N)");
            selection = sc.next();
            if (selection == "y" || selection == "Y") {
                sm.sortNames();
                sm.printSortedNames();
            } else {
                sm.printUnsortedNames();
            }
        }
        if (key == 2) {
            sm.printAddress();
        }
        if (key == 3) {
            sm.printAll();
        }
        if (key == 4) {
            System.out.println("Enter Student Lastname:");
            System.out.print(":> \t");
            selection = sc.next();
            sm.searchAndPrint(selection);
        }
        // if (key == 5) {

        // }
    }
}