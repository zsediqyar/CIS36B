import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UI {
    JFrame mainFrame;
    JPanel titlePanel, inputPanel, resultPanel, buttonPanel;
    JLabel titleLabel, subTitleLabel, heightLabel, weightLabel, percentLabel, resultLabel;
    JTextField heightField, weightField;
    JButton calculate;

    UI() {
        /* setup the frame */
        mainFrame = new JFrame("BMI - Calcuate Your Body Mass Index");
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
        subTitleLabel = new JLabel("Use Metric (Kg & CM");
        subTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        subTitleLabel.setForeground(Color.gray);
        subTitleLabel.setVerticalAlignment(JLabel.TOP);
        titlePanel.add(titleLabel);
        titlePanel.add(subTitleLabel);

        /* create inputs and add to it's panel */
        heightLabel = new JLabel("Height");
        heightLabel.setHorizontalAlignment(JLabel.LEADING);
        heightLabel.setForeground(Color.DARK_GRAY);
        weightLabel = new JLabel("Weight");
        weightLabel.setHorizontalAlignment(JLabel.LEFT);
        weightLabel.setForeground(Color.DARK_GRAY);
        heightField = new JTextField(18);
        weightField = new JTextField(18);
        heightField.setBorder(new LineBorder(Color.decode("#5c8b3f")));
        weightField.setBorder(new LineBorder(Color.decode("#5c8b3f")));
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);

        /* create result labels and add to it's panel */
        percentLabel = new JLabel("%");
        resultLabel = new JLabel("Obese");
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            percentLabel.setText("Clicked");
        }
    }
}