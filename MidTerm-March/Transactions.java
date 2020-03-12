import java.util.*;
import java.io.*;

class Transactions {
    private ArrayList<String> totalItems = new ArrayList<String>();
    float unitCost, finalAmount;
    int totalNumberOfItems = 0;

    // READ THE CONTENT OF THE FILE
    void readFromFile() {
        try {
            Scanner read = new Scanner(new File("raw_data.txt"));
            while (read.hasNextLine()) {
                totalItems.add(read.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found");
        }
    }

    // COUNT THE NUMBER OF ITEMS
    public void countTheItems() {
        String tempArr[] = new String[totalItems.size()];
        for (int i = 0; i < totalItems.size(); i++) {
            tempArr[i] = totalItems.get(i);
        }
        for (String item : tempArr) {
            String[] array = item.split(",");
            // totalCount.add(array[1]);
            totalNumberOfItems += Integer.parseInt(array[1]);
        }
    }

    // SUM THE TOTAL OF PER UNIT PRICE
    public void sumTotalPrice() {
        String tempArr[] = new String[totalItems.size()];
        for (int i = 0; i < totalItems.size(); i++) {
            tempArr[i] = totalItems.get(i);
        }

        for (String price : tempArr) {
            String[] array = price.split(",");
            unitCost += Float.parseFloat(array[0]);

        }

    }

    // CALCULATE THE FINAL AMOUNT
    public void calculateTotalAmount() {
        finalAmount = unitCost * totalNumberOfItems;
    }

    // WRITE THE DATA BACK TO THE FILE
    void writeToFile() throws IOException {
        FileWriter file = new FileWriter("raw_data.txt", true);
        Writer out = new BufferedWriter(file);
        out.write("\nTOTAL NUMBER OF ITEMS: \t" + totalNumberOfItems);
        out.write("\nTOTAL PRICE / UNIT: \t" + unitCost);
        out.write("\nTOTAL FINAL AMOUNT: \t" + finalAmount);
        out.close();
    }

    // PRINT THE FILE WITHOUT CALCULATIONS IN THE CONSOLE
    void printAllwithoutCalculation() {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < totalItems.size(); i++) {
            temp.add(totalItems.get(i).replaceAll(",", "\t"));
        }
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }

    // PRINT THE ITEMS WITH THE CALCULATION
    void printAllWithCalculation() {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < totalItems.size(); i++) {
            temp.add(totalItems.get(i).replaceAll(",", "\t"));
        }
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        System.out.println("\n Total Price per Unit: \t" + unitCost);
        System.out.println("\n Total Number of Items: \t" + totalNumberOfItems);
        System.out.println("\n Total Amount: \t" + finalAmount);
    }
}