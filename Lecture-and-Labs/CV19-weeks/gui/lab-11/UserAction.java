import java.awt.event.ActionEvent;

class UserAction implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Print Names")) {
            displayLabel.setText("Print Names Clicked");
        }
    }
}