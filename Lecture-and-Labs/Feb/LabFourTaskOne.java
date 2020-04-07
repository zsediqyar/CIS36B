
/* Random Numbers in Array and Math operations */
import java.util.Random;
import java.util.Scanner;

class RandomNums {
    int arrSize = 500;
    public int randomArr[] = new int[arrSize];

    RandomNums() {
        Random rand = new Random();
        for (int i = 0; i < arrSize; i++) {
            randomArr[i] = rand.nextInt(1000);
        }
    }

    void printNums() {
        System.out.println("");
        for (int i = 0; i < arrSize; i++) {
            System.out.print(randomArr[i] + "\t");
        }
        System.out.println("");
    }

    void printEvenOdd(int arg) {
        if (arg == 2) {
            System.out.println("Odd Numbers \n");
            for (int i = 0; i < arrSize; i++) {
                if (randomArr[i] % 2 != 0) {
                    System.out.print(randomArr[i] + "\t");
                }
            }
            System.out.println("");
        }
        if (arg == 3) {
            System.out.println("Even Numbers \n");
            for (int i = 0; i < arrSize; i++) {
                if (randomArr[i] % 2 == 0) {
                    System.out.print(randomArr[i] + "\t");
                }
            }
            System.out.println("");
        }
    }

    void printFirstLastValue(int arg) {
        if (arg == 6) {
            System.out.println("");
            System.out.println("First Value:\t [" + randomArr[0] + "] \n");
        }
        if (arg == 7) {
            System.out.println("");
            System.out.println("Last Value:\t [" + randomArr[arrSize - 1] + "] \n");
        }
    }

    void printMiddleTwoValues() {
        int valOne = randomArr[arrSize / 2];
        int valTwo = randomArr[arrSize / 2 - 1];
        System.out.println("");
        System.out.println("Middle Values: \t [" + valOne + "] [" + valTwo + "]");
    }

    void printAverage() {
        int total = 0;
        double average;
        for (int i = 0; i < arrSize; i++) {
            total += randomArr[i];
        }
        average = total / arrSize;
        System.out.println("");
        System.out.println("Mean Average:\t [" + average + "] \n");
    }
}

class LabFourTaskOne {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        RandomNums random = new RandomNums();
        int arg = 0;

        while (arg != 8) {
            System.out.println("------------------------------");
            System.out.println("Choose Option From the Menu");
            System.out.println("------------------------------ \n");

            System.out.println("1) - Output All Integer Values");
            System.out.println("2) - Output All Odd Numbers");
            System.out.println("3) - Output All Even Numbers");
            System.out.println("4) - Output Mean Average of All Integers");
            System.out.println("5) - Output Middle Value in Array");
            System.out.println("6) - Output The First Value in the Array");
            System.out.println("7) - Output The Last Value in the Array");
            System.out.println("8) - Exit \n");
            System.out.print("Enter: \t");
            arg = input.nextInt();
            System.out.println("");

            if (arg == 1) {
                random.printNums();
            }
            if (arg == 2) {
                random.printEvenOdd(2);
            }
            if (arg == 3) {
                random.printEvenOdd(3);
            }
            if (arg == 4) {
                random.printAverage();
            }
            if (arg == 5) {
                random.printMiddleTwoValues();
            }
            if (arg == 6) {
                random.printFirstLastValue(6);
            }
            if (arg == 7) {
                random.printFirstLastValue(7);
            }
            if (arg == 8) {
                System.out.println("Exiting...");
                break;
            }
        }

    }
}
