import java.util.Scanner;

class Convert {
    private double usd;
    private double yen = 108.68;
    private double euro = 0.90;
    private double peso = 18.81;

    public void setUsd(double usdAmount) {
        usd = usdAmount;
    }

    public double usdToYen() {
        return yen * usd;
    }

    public double usdToEuro() {
        return euro * usd;
    }

    public double usdToPeso() {
        return peso * usd;
    }

    public void convertAll() {
        double usdToYen = usdToYen();
        double usdToEuro = usdToEuro();
        double usdToPeso = usdToPeso();
        System.out.println("[" + usd + "] USD --> [" + usdToYen + "] \t Yen \n" + "[" + usd + "] USD --> [" + usdToEuro
                + "] \t Euro \n" + "[" + usd + "] USD --> [" + usdToPeso + "] \t Peso");
    }
}

class Menu extends Convert {
    double amountValidation;

    void Validate(double amount) {
        if (amount <= 0) {
            System.out.println("Insufficient Funds ... Exiting the program");
        }
        if (amount > 0) {
            open();
        }
    }

    void open() {
        System.out.println("--- Choose Menu Options ---");
        System.out.println("1) - Convert USD to YEN");
        System.out.println("2) - Convert USD to EURO");
        System.out.println("3) - Convert USD to PESO");
        System.out.println("4) - Convert USD to ALL");
    }
}

class LabOneTask {
    public static void main(String[] args) {

        double amount, result;
        int menuSelection;

        Convert convert = new Convert();
        Menu menu = new Menu();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amount to convert: ");
        amount = sc.nextDouble();
        menu.Validate(amount);
        convert.setUsd(amount);
        System.out.print("Enter Menu Number: ");
        menuSelection = sc.nextInt();

        if (menuSelection == 1) {
            result = convert.usdToYen();
            System.out.println(amount + " USD Equals: " + result + " YEN");
        } else if (menuSelection == 2) {
            result = convert.usdToEuro();
            System.out.println(amount + " USD Equals: " + result + " EURO");
        } else if (menuSelection == 3) {
            result = convert.usdToPeso();
            System.out.println(amount + " USD Equals: " + result + " PESO");
        } else if (menuSelection == 4) {
            convert.convertAll();
        } else {
            System.out.println(" Invalid Selection ... Exiting");
        }

    }
}
