class Students {
    String studentId, firstName, lastName, dob, add;
    ArrayList<Students> studentNames = new ArrayList<Students>();
    ArrayList<String> studentsInfo = new ArrayList<String>();

    Students() {
    }

    Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Students(String studentId, String firstName, String lastName, String dob, String add) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.add = add;
    }

    class sortByLastName implements Comparator<Students> {
        @Override
        public int compare(Students s1, Students s2) {
            return s1.lastName.compareTo(s2.lastName);
        }
    }

    void readFile() throws IOException {
        try {
            Scanner read = new Scanner(new File("records.text"));
            while (read.hasNextLine()) {
                studentsInfo.add(read.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No Such File");
        }
    }

    void sortNames() {
        String studs[] = new String[studentsInfo.size()];
        for (int i = 0; i < studentsInfo.size(); i++) {
            studs[i] = studentsInfo.get(i);
        }
        for (String s : studs) {
            String[] arr = s.split(" ");
            String fname = arr[1];
            String lname = arr[2];
            studentNames.add(new Students(fname, lname));
        }
        Collections.sort(studentNames, new sortByLastName());
    }

}