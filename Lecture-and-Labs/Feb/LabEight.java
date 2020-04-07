import java.util.*;
import java.io.*;

class Students {
    // create instance variables and an arraylist to push data from the file
    protected String student_id, first_name, last_name, student_dob, address;
    protected ArrayList<String> students_list = new ArrayList<String>();

    // read the content of the file to arraylist
    void readFromFile() throws FileNotFoundException {
        Scanner read = new Scanner(new File("output.text"));
        while (read.hasNextLine()) {
            students_list.add(read.nextLine());
        }
    }

    // print the first and last name from the list
    public void printFirstAndLastName() {
        // create a string array to copy data from arraylist
        String students_array[] = new String[students_list.size()];
        // push data from arraylist into the new array
        for (int i = 0; i < students_list.size(); i++) {
            students_array[i] = students_list.get(i);
        }
        System.out.println("+---------------------------+");
        System.out.println("| STUDENT FIRST & LAST NAME |");
        System.out.println("+---------------------------+");
        // loop through the string array and split each item
        for (String line : students_array) {
            String[] array = line.split(",");
            // print the specific indices of the array
            System.out.println(array[1] + "\t\t" + array[2]);
        }
    }

    // same as first and last name
    public void printAddress() {
        String students_array[] = new String[students_list.size()];

        for (int i = 0; i < students_list.size(); i++) {
            students_array[i] = students_list.get(i);
        }
        System.out.println("+-------------------+");
        System.out.println("| STUDENT ADDRESSES |");
        System.out.println("+-------------------+");
        for (String line : students_array) {
            String[] array = line.split(",");
            // this time only the last index
            System.out.println(array[array.length - 1]);
        }
    }

    // print all of the data
    public void printAll() {
        for (int i = 0; i < students_list.size(); i++) {
            System.out.println(students_list.get(i));
        }
    }

}

// menu class to show the menu
class Menu {
    void showMenu() {
        System.out.println("+----------------------------------------+");
        System.out.println("|\t\t MAIN MENU \t\t |");
        System.out.println("|\t\t Select a # \t\t |");
        System.out.println("| 1) Print Students First & Last Name \t |");
        System.out.println("| 2) Print Students Address Only \t |");
        System.out.println("| 3) Print all Students Info \t\t |");
        System.out.println("| 4) Exit the program \t\t\t |");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter: \t");
    }

}

class LabEight {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner getMenuItem = new Scanner(System.in);
        Menu menu = new Menu();
        Students students = new Students();
        students.readFromFile();
        int menuItem;
        menu.showMenu();
        menuItem = getMenuItem.nextInt();
        switch (menuItem) {
            case 1:
                students.printFirstAndLastName();
                break;
            case 2:
                students.printAddress();
                break;
            case 3:
                students.printAll();
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong Input...");
        }
    }
}