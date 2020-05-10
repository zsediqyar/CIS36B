class UserInterface {
    UserInterface() {
        JLabel appTitle = new JLabel();
        appTitle.setText("Student Information Application");
        appTitle.setFont(new Font("San Serif", Font.BOLD, 20));
        appTitle.setForeground(Color.decode("#5c797a"));

        JLabel displayLabel = new JLabel();
        displayLabel.setText("");

        JButton printNames = new JButton("Print Names");
        JButton printAdd = new JButton("Print Address");
        JButton printAll = new JButton("Print All Student Info");
        JButton searchName = new JButton("Search Name");
        JButton sortSelection = new JButton("Sort Selection");

        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel btnPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        JPanel displayPanel = new JPanel(new GridLayout(1, 1));
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        titlePanel.add(appTitle);
        btnPanel.add(printNames);
        btnPanel.add(printAdd);
        btnPanel.add(printAll);
        btnPanel.add(searchName);
        btnPanel.add(sortSelection);
        displayPanel.add(displayLabel);
        mainPanel.add(titlePanel);
        mainPanel.add(btnPanel);
        mainPanel.add(displayPanel);

        JFrame mainFrame = new JFrame("Student Info GUI Application");
        mainFrame.setSize(1000, 500);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}