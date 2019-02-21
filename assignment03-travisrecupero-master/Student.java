package assignment03;

public class Student {

	private String bnumber;
	private String lastname;
	private String firstname;

	public Student(String bnumber, String lastname, String firstname) {
		super();
		this.bnumber = normalize(bnumber);
		this.lastname = normalize(lastname);
		this.firstname = normalize(firstname);
	}

	public String getBnumber() {
		return bnumber;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getName() {
		return firstname + ", " +  lastname;
	}
	
	private String normalize(String input){
		input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
		return input;
	}
	
	public static int compareBnum(Student s1, Student s2){
		return s1.bnumber.compareTo(s2.bnumber);
	}
	
	public static int compareName(Student s1, Student s2){
		if ((s1.lastname.compareTo(s2.lastname)) != 0){
			return s1.lastname.compareTo(s2.lastname);
		}
		else if (s1.firstname.compareTo(s2.firstname) == 0){
			if (s1.bnumber.compareTo(s2.bnumber) == 0){
				return s1.bnumber.compareTo(s2.bnumber);
			}
			else {
				return s1.bnumber.compareTo(s2.bnumber);
			}
		}
		return s1.lastname.compareTo(s2.lastname);
	}

	@Override
	public String toString() {
		return "Name: " + getName();
	}
	
	
}
