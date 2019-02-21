package assignment03;

public class HighSchoolStudent implements Occupation {

	private HighSchool highschool;
	private Person person;

	public HighSchoolStudent(HighSchool highschool, Person person) {
		super();
		this.highschool = highschool;
		person.addOccupation(this);
		this.person = person;
	}

	public HighSchool getHighschool() {
		return highschool;
	}

	public Person getPerson() {
		return person;
	}

	public UniversityStudent goToUniversity(University univ){
		return new UniversityStudent(univ, this.person);
	}

	public HighSchoolStudent changeHighSchool(HighSchool sch) {
		return new HighSchoolStudent(sch, this.person);
	}
	
	public void print() {
		System.out.println("\tHigh school: " + getHighschool().getName());		
	}

}
