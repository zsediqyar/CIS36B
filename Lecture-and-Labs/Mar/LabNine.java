import java.io.*;
import java.util.*;

/*  student class with the constructor */
class Students {
    String studentId;
    String firstName;
    String lastName;
    String dateOfBirth;
    String address;

    Students() {
    }

    /* second constructor for print/sorting first and last name */
    Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* main constructor */
    Students(String studentId, String firstName, String lastName, String dateOfBirth, String address) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    /* COMPARATOR interface */
    class sortByLastName implements Comparator<Students> {
        @Override
        /* the methods gets to student objects and compares with each other */
        public int compare(Students s1, Students s2) {
            return s1.lastName.compareTo(s2.lastName);
        }
    }

    /* Sub-class implementing all the methods */
    class StudentMethods {
        /* Arraylist of type STUDENT (Object) */
        ArrayList<Students> studentNames = new ArrayList<Students>();
        /* Arraylist of type String */
        ArrayList<String> studentsInfo = new ArrayList<String>();

        /* reading/copying file content to the arraylist */
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

        /* printing all student information */
        void printAll() {
            for (int i = 0; i < studentsInfo.size(); i++) {
                System.out.println(studentsInfo.get(i));
            }
        }

        /* sorting the names by student last name */
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

        /* printing the sorted names */
        void printSortedNames() {
            Iterator itr = studentNames.iterator();
            while (itr.hasNext()) {
                Students stud = (Students) itr.next();
                System.out.println(stud.firstName + "\t" + stud.lastName);
            }
        }

        /* printint the first name / last name unsorted */
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

        /* printing the student address only */
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

        /* searching student by last name and printing the record */
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
                }
            }
            System.out.println("---------------------------------------");
        }
    }

    /* Sub-class of the student class displaying MENU */
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

/* MAIN Implementation class */
class LabNine {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String selection;
        int key = 0;
        /* object instance of the STUDENTS class */
        Students s = new Students();
        /* object instances of the sub classes of students class */
        Students.StudentMethods sm = s.new StudentMethods();
        Students.Menu menu = s.new Menu();
        /* reading the file and copying it's content to memory */
        sm.readFile();
        /* once copied, copying names and sorting them */
        sm.sortNames();
        /* displaying the menu until selected to exit */
        do {
            menu.showMenu();
            System.out.print("Enter:\t");
            key = sc.nextInt();
            if (key == 1) {
                System.out.println("Sort it by Lastname?\t(Y,N)");
                selection = sc.next();

                switch (selection.toLowerCase()) {
                    case "y":
                        sm.printSortedNames();
                        break;
                    case "n":
                        sm.printUnsortedNames();
                        break;
                    default:
                        System.out.println("No Option");
                        break;
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
        } while (key != 5);
    }
}