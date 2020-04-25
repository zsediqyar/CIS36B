import javax.swing.*;
import java.awt.*;

class LabTen {

    public static void main(String args[]) {
        JFrame frame = new JFrame("JFrame with Button and Label");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("JLabel");
        JButton button = new JButton();
        button.setText("JButton");
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}