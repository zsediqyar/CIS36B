import java.util.Scanner;

class Conversions {
    double metricWeight;
    double metricHeight;
    double usWeight;
    double usHeight;
    double bmi;

    Conversions() {
    }

    void setUnits(double w, double h, char select) {
        if (select == 'u') {
            usWeight = w;
            usHeight = h;
        } else if (select == 'm') {
            metricWeight = w;
            metricHeight = h;
        }
    }

    void convertUsToMetric() {

    }

    void calcBMI() {
        bmi = metricWeight / (metricHeight * metricHeight / 100) * 100;
    }

    double getBMI() {
        return bmi;
    }

    void result() {
        if (bmi > 25) {
            System.out.println("overweight");
        } else if (bmi < 25) {
            System.out.println("underweight");
        }
    }
}

class BMI {

    public static void main(String args[]) {
        char selection;
        double height, weight;
        Scanner input = new Scanner(System.in);
        Conversions convert = new Conversions();

        System.out.println("Choose Your Measurement System: U - (US) \t M - (Metric)");
        selection = input.next().charAt(0);
        if (selection == 'm') {
            System.out.println("Enter your height in CM");
            double h = input.nextDouble();
            System.out.println("Enter your weight in KG");
            double w = input.nextDouble();
            convert.setUnits(w, h, 'm');
        }
        if (selection == 'u') {
            System.out.println("Enter your height in ft.inch");
            double h = input.nextDouble();
            System.out.println("Enter your weight in LBs");
            double w = input.nextDouble();
            convert.setUnits(w, h, 'u');
        }
        input.close();
        System.out.println(convert.usHeight);
        System.out.println(convert.usWeight);
        convert.calcBMI();
        System.out.println(convert.getBMI());

    }
}