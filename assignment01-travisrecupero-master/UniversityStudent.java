package assignment01;

public class UniversityStudent {

	private University university;
	private Person person;

	public UniversityStudent(University university, Person person) {
		this.university = university;
		person.getHistory()[1] = this;
		this.person = person;
	}

	public University getUniversity() {
		return university;
	}

	public Person getPerson() {
		return person;
	}

	 public Employee getAJob(Company comp, double startingSalary){
		return new Employee(comp, startingSalary, this.person); 
	 }
	 
}
