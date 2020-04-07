import java.util.*;
import java.io.*;

class Store {
    public static void main(String args[]) throws IOException {
        // CREATE THE OBJECTS INSTANCE OF THE TRANSACTION CLASS
        Transactions transactions = new Transactions();
        // COPY THE DATA FROM THE FILE INTO THE ARRAY IN MEMORY
        transactions.readFromFile();
        // PRINT THE DATA IN THE CONSOLE BEFORE CALCULATIONS
        transactions.printAllwithoutCalculation();
        // COUNT THE NUMBER OF ITEMS FROM INSIDE THE FILE
        transactions.countTheItems();
        // SUM THE TOTAL OF PRICE/UNIT FROM THE FILE
        transactions.sumTotalPrice();
        // CALCULATE THE FINAL BY => TOTAL UNIT * TOTAL PRICE PER UNIT
        transactions.calculateTotalAmount();
        // WRITE THE CALCULATIONS INTO THE END OF THE FILE
        transactions.writeToFile();
        // PRINT AGAIN WITH CALCULATIONS
        transactions.printAllWithCalculation();
    }
}