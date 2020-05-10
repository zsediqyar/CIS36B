import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.*;
import java.util.*;

public class StudentInfoApp {
    private JFrame mainFrame;
    private JLabel appTitle, displayLabel;
    private JPanel titlePanel, btnPanel, displayPanel, mainPanel;
    private JButton printNames, printAdd, printAll, searchName, sortSelection;

    public StudentInfoApp() {
        runUserInterface();
    }

    public static void main(String args[]) {
        StudentInfoApp studentInfo = new StudentInfoApp();
        studentInfo.showEvent();
    }

    private void runUserInterface() {
        /* frame */
        mainFrame = new JFrame("STUDENT CENTER  |  Information About Students");
        mainFrame.setSize(800, 500);
        mainFrame.setLayout(new GridLayout(3, 1));

        /* labels */
        appTitle = new JLabel();
        appTitle.setText("Student Center");
        appTitle.setFont(new Font("San Serif", Font.BOLD, 20));
        appTitle.setForeground(Color.decode("#5c797a"));
        displayLabel = new JLabel("");

        /* panels */
        titlePanel = new JPanel();
        btnPanel = new JPanel();
        displayPanel = new JPanel();
        mainPanel = new JPanel();

        /* buttons */
        printNames = new JButton("Print Names");
        printAdd = new JButton("Print Address");
        printAll = new JButton("Print All Student Info");
        searchName = new JButton("Search Name");
        sortSelection = new JButton("Sort Selection");

        /* add comps to the panels */
        titlePanel.add(appTitle);
        btnPanel.add(printNames);
        btnPanel.add(printAdd);
        btnPanel.add(printAll);
        btnPanel.add(searchName);
        btnPanel.add(sortSelection);
        displayPanel.add(displayLabel);

        // mainPanel.add(titlePanel);
        // mainPanel.add(btnPanel);
        // mainPanel.add(displayPanel);

        mainFrame.add(titlePanel);
        mainFrame.add(btnPanel);
        mainFrame.add(displayPanel);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void showEvent() {
        printNames.setActionCommand("printNames");
        printAdd.setActionCommand("printAdd");
        ;
        printAll.setActionCommand("printAll");
        searchName.setActionCommand("searchName");
        ;
        sortSelection.setActionCommand("sortSelection");

        printNames.addActionListener(new ButtonClickListener());
        printAdd.addActionListener(new ButtonClickListener());
        printAll.addActionListener(new ButtonClickListener());
        searchName.addActionListener(new ButtonClickListener());
        sortSelection.addActionListener(new ButtonClickListener());

    }

    // private void displayTable() {
    // String[] headers = new String[] { "Id", "First Name", "Last Name", "DOB",
    // "Address" };
    // Object[][] data = new Object[][] { { 1, "Zaki", "Sediqyar", "January",
    // "Richmond, CA" },
    // { 2, "Lima", "Shirzad", "March", "San Pablo, CA" } };
    // JTable studentTable = new JTable(data, headers);
    // // displayPanel.add(new JScrollPane(studentTable));
    // }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("printNames")) {
                String sample = "<html><p>lorem asdlkasdlkqwjelqkwejlaksdjlaskdjlaskdjalskdja <br> aksjdhaksjdhaksjdhaksjdhaksjdhaksjdhaksdhakjsdh <br>asdasdasdasdasdasd </p> </html>";
                displayLabel.setText(sample);
            }
            if (command.equals("searchName")) {
                String name = JOptionPane.showInputDialog(mainFrame, "Enter Student First Name");
                displayLabel.setText(name);
            }
            if (command.equals("printAdd")) {
                String data[] = { "1212", "John", "Marshal", "January", "Oakland, CA" };
                String output = String.format("%1$s \t %2$s \t %3$s \t %4$s \t %5$s", data[0], data[1], data[2],
                        data[3], data[4]);
                displayLabel.setText(output);
            }
        }
    }
}