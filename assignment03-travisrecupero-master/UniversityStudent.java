package assignment03;

public class UniversityStudent implements Occupation {

	private University university;
	private Person person;

	public UniversityStudent(University university, Person person) {
		this.university = university;
		person.addOccupation(this);
		this.person = person;
	}

	public University getUniversity() {
		return university;
	}

	public Person getPerson() {
		return person;
	}

	public Employee getAJob(Company comp, double startingSalary) {
		return new Employee(comp, startingSalary, this.person);
	}

	public UniversityStudent transferUniversity(University uni) {
		return new UniversityStudent(uni, this.person);
	}
	
	@Override
	public void print() {
		System.out.println("\tUniversity: " + getUniversity().getName());
	}

}
