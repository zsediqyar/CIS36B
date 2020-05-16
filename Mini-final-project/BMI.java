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

    void convertUsToMetric(double w, double h) {
        String height[] = String.valueOf(h).split("\\.");
        double ft = Double.parseDouble(height[0]);
        double inch = Double.parseDouble(height[1]);

        this.metricHeight = (ft * 30.48) + (inch * 2.54);
        this.metricWeight = w * 0.454;
    }

    void calcBMI() {
        bmi = metricWeight / (metricHeight * metricHeight / 100) * 100;
    }

    void getBMI() {
        if (bmi < 18.5) {
            System.out.println("UNDER WEIGHT");
        }
        if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("NORMAL");
        }
        if (bmi >= 25 && bmi <= 29.9) {
            System.out.println("OVER WEIGHT");
        }
        if (bmi >= 30 && bmi <= 39.9) {
            System.out.println("OBESE");
        }
        if (bmi >= 40) {
            System.out.println("EXTREMELY OBESE");
        }
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
            convert.convertUsToMetric(w, h);
        }
        input.close();
        convert.calcBMI();
        convert.getBMI();

    }
}