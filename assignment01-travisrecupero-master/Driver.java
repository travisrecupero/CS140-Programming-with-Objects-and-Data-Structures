package assignment01;

public class Driver {

	public static void main(String[] args) {

		Person person1 = new Person("Bob", 1, 1, 1998);
		Person person2 = new Person("Jim", 2, 2, 1997);
		Person person3 = new Person("Tom", 3, 3, 1996);
		Person person4 = new Person("Kim", 4, 4, 1995);
		
		HighSchool highschool1 = new HighSchool("Comsewogue");
		HighSchool highschool2 = new HighSchool("Sayville");
		HighSchool highschool3 = new HighSchool("Mt. Sinai");
		
		HighSchoolStudent highschoolStudent1 = new HighSchoolStudent(highschool1, person1);
		HighSchoolStudent highschoolStudent2 = new HighSchoolStudent(highschool2, person2);
		HighSchoolStudent highschoolStudent3 = new HighSchoolStudent(highschool3, person3);
		
		University university1 = new University("BU", "Binghamton");
		University university2 = new University("SBU", "Stonybrook");
		
		UniversityStudent universityStudent1 = highschoolStudent1.goToUniversity(university1);
		UniversityStudent universityStudent2 = highschoolStudent2.goToUniversity(university2);
		
		Company company1 = new Company("I.B.M.", "Armonk");
		
		Employee employee1 = universityStudent1.getAJob(company1, 150000);
		
		
		person1.printHistory();
		System.out.println("---------------------");
		person2.printHistory();
		System.out.println("---------------------");
		person3.printHistory();		
		System.out.println("---------------------");
		person4.printHistory();
		System.out.println("---------------------");
	}

}
