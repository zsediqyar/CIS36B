import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserInterface {
    JFrame mainFrame;
    JPanel titlePanel, inputPanel, resultPanel, buttonPanel;
    JLabel titleLabel, subTitleLabel, heightLabel, weightLabel, percentLabel, resultLabel;
    JTextField heightField, weightField;
    JButton calculate;

    UserInterface() {
        runGui();
    }

    void runGui() {
        /* setup the frame */
        mainFrame = new JFrame("BMI Calculator");
        mainFrame.setBounds(600, 200, 300, 450);
        mainFrame.setLayout(new GridLayout(4, 0));

        /* panels */
        titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        titlePanel.setLayout(new GridLayout(2, 0));
        inputPanel = new JPanel(new GridLayout(4, 0));
        inputPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        resultPanel = new JPanel();
        resultPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        resultPanel.setLayout(new GridLayout(2, 0));
        buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        buttonPanel.setLayout(new GridBagLayout());

        /* create title and add to it's panel */
        titleLabel = new JLabel("BMI - Body Mass Index");
        titleLabel.setForeground(Color.decode("#5C8B3F"));
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        subTitleLabel = new JLabel("Use Metric Measurements");
        subTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        subTitleLabel.setForeground(Color.gray);
        subTitleLabel.setVerticalAlignment(JLabel.TOP);
        titlePanel.add(titleLabel);
        titlePanel.add(subTitleLabel);

        /* create inputs and add to it's panel */
        heightLabel = new JLabel("Height (cm)");
        heightLabel.setHorizontalAlignment(JLabel.LEADING);
        heightLabel.setForeground(Color.DARK_GRAY);
        weightLabel = new JLabel("Weight (kg)");
        weightLabel.setHorizontalAlignment(JLabel.LEFT);
        weightLabel.setForeground(Color.DARK_GRAY);
        heightField = new JTextField(18);
        weightField = new JTextField(18);
        heightField.setBorder(new LineBorder(Color.decode("#5c8b3f")));
        weightField.setBorder(new LineBorder(Color.decode("#5c8b3f")));
        heightField.setMargin(new Insets(0, 2, 0, 2));
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);

        /* create result labels and add to it's panel */
        percentLabel = new JLabel("");
        percentLabel.setForeground(Color.DARK_GRAY);
        resultLabel = new JLabel("");
        percentLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        percentLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        resultLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        resultPanel.add(percentLabel);
        resultPanel.add(resultLabel);

        /* create button and add to it's panel */
        calculate = new JButton("Calculate");
        calculate.setVerticalAlignment(JButton.CENTER);
        calculate.setForeground(Color.decode("#5C8B3F"));
        calculate.setFocusPainted(false);
        buttonPanel.add(calculate);

        /* add panels to the frame */
        mainFrame.add(titlePanel);
        mainFrame.add(inputPanel);
        mainFrame.add(resultPanel);
        mainFrame.add(buttonPanel);

        /* default frame props */
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void runEvents() {
        calculate.setActionCommand("calculate");
        calculate.addActionListener(new ButtonClickListener());
    }

    double calculateBmi(double w, double h) {
        double result = w / (h * h / 100) * 100;
        return result;
    }

    String result(double percent) {
        String result = "";
        if (percent < 18.5) {
            result = "UNDER WEIGHT";
        }
        if (percent >= 18.5 && percent <= 24.9) {
            result = "NORMAL";
        }
        if (percent >= 25 && percent <= 29.9) {
            result = "OVER WEIGHT";
        }
        if (percent >= 30 && percent <= 39.9) {
            result = "OBESE";
        }
        if (percent >= 40) {
            result = "EXTREMELY OBESE";
        }
        return result;
    }

    void resetTextFields() {
        heightField.setText("");
        weightField.setText("");
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("calculate")) {
                calculate.setBackground(Color.red);
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());
                double percent = calculateBmi(weight, height);
                String percentString = String.format("%.02f", percent);
                String result = result(percent);
                percentLabel.setText(percentString + "%");
                resultLabel.setText(result);
                resetTextFields();
                if (result == "NORMAL") {
                    resultLabel.setForeground(Color.decode("#5C8B3F"));
                } else if (result == "UNDER WEIGHT") {
                    resultLabel.setForeground(Color.decode("#17a0da"));
                } else if (result == "OVER WEIGHT") {
                    resultLabel.setForeground(Color.decode("#f0a132"));
                } else if (result == "OBESE") {
                    resultLabel.setForeground(Color.decode("#e76931"));
                } else {
                    resultLabel.setForeground(Color.decode("#d91d2a"));
                }
            }
        }
    }

    public static void main(String args[]) {
        UserInterface ui = new UserInterface();
        ui.runEvents();
    }
}