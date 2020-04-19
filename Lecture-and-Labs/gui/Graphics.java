import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Graphics {
    Graphics() {
        JFrame f = new JFrame("Button Example");
        // submit button
        JButton b = new JButton("Submit");
        b.setBounds(100, 100, 140, 40);
        // enter name label
        JLabel label = new JLabel();
        label.setText("Enter Name :");
        label.setBounds(10, 10, 100, 100);
        // empty label which will show event after button clicked
        JLabel label1 = new JLabel();
        label1.setBounds(10, 110, 200, 100);
        // textfield to enter name
        JTextField textfield = new JTextField();
        textfield.setBounds(110, 50, 130, 30);
        // add to frame
        f.add(label1);
        f.add(textfield);
        f.add(label);
        f.add(b);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // action listener
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = textfield.getText();
                label1.setText(name);
                System.out.println(name);
            }
        });
    }

    public static void main(String[] args) {
        // new Graphics();
        String sample = JOptionPane.showInputDialog(null, "Enter a Dollar Amount", "Currency Converter",
                JOptionPane.INFORMATION_MESSAGE);

        System.out.println(sample);
    }
}