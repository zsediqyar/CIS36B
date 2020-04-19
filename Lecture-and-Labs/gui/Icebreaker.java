import javax.swing.*;

public class Icebreaker {
    // static GraphicsConfiguration gc;
    Icebreaker() {
        JFrame frame = new JFrame("Border Layout");

        frame.setSize(600, 400);
        frame.setTitle("Ice-Breaker");
        frame.setVisible(true);
        frame.setVisible(true);
        frame.setLocation(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new Icebreaker();
    }
}
