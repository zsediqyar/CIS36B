import javax.swing.*;
import java.awt.*;

class UI {
    JButton convert;
    JTextField heightField, weightField;
    JRadioButton us, metric;
    JLabel heightLabel, weightLabel, titleLabel, resultNumLabel, resultLabel;
    JFrame frame;
    JPanel titlePanel, inputPanel, buttonPanel, resultPanel;

    UI() {
        /* create frame */
        frame = new JFrame("BMI - Calculate your Body Mass Index");
        frame.setBounds(600, 300, 700, 400); /* X, Y, width, height */
        frame.setLayout(new GridLayout(4, 1));
        frame.setBackground(Color.orange);

        /* create panels */
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.red);
        inputPanel = new JPanel(new GridLayout(1, 4));
        inputPanel.setBackground(Color.blue);
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.yellow);
        resultPanel = new JPanel();
        resultPanel.setBackground(Color.orange);

        /* create title and add to panel */
        JLabel titleLabel = new JLabel("BMI - Body Mass Index");
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        titleLabel.setForeground(Color.decode("#5C8B3F"));
        titlePanel.add(titleLabel);

        /* create text fields and add to panel */
        heightLabel = new JLabel("Enter your Height");
        weightLabel = new JLabel("Enter your Weight");
        heightField = new JTextField();
        heightField.setSize(20, 20);
        weightField = new JTextField();
        weightField.setSize(20, 20);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);
        /* create button and add to panel */

        /* add panels to the frame */
        frame.add(titlePanel);
        frame.add(inputPanel);
        frame.add(buttonPanel);
        frame.add(resultPanel);

        /* default frame props */
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}