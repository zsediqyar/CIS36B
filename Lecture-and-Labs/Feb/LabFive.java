class Student {
	private int id;
	private String name;
	private String city;
	char dual_enrolled;

  Student(String name, String city) {        
  // Name, City
		this.name = name;
		this.city = city;
	}
  
  Student(int id, String city) {      
  // ID, City
		this.id = id;
		this.city = city;
	}
  
  Student(int id, String name, String city){ 
  // ID, Name, City, International or High School
		this.id = id;
		this.name = name;
		this.city = city;
	}

	void print(){                 
    // method will output Name, ID, City, Enrollment Status
		System.out.println(id + " " + name + " " + city + " ");
	}
}
public class LabFive {
    public static void main(String[] args) { 
      
    // Student student = new Student();
    Student international_student = new Student(10585, "Julius Caesar", "Athens");
    Student high_school_student   = new Student(10678, "James Brown", "Oakland");

    international_student.print();
    
    } 
}
