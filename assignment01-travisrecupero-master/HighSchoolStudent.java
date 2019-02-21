package assignment01;

public class HighSchoolStudent {

	private HighSchool highschool;
	private Person person;

	public HighSchoolStudent(HighSchool highschool, Person person) {
		super();
		this.highschool = highschool;
		person.getHistory()[0] = this;
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

}
