import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

class Login {
    Login() {
        JLabel usernameLabel = new JLabel();
        usernameLabel.setText("Username: ");
        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton submit = new JButton("Submit");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 20, 20));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submit, "center");
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JFrame frame = new JFrame("Login Form");
        frame.setSize(500, 400);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

public class LabTenLoginForm {
    public static void main(String args[]) {
        Login login = new Login();
    }
}