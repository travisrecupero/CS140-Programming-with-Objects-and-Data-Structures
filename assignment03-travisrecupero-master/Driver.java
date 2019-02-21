package assignment03;

public class Driver {

	public static void main(String[] args) {

		Person person1 = new Person("Dylan", 1, 1, 1998);
		Person person2 = new Person("Mike"", 2, 2, 1997);
		Person person3 = new Person("Fred", 3, 3, 1996);
		Person person4 = new Person("Frank", 4, 4, 1995);
		
		HighSchool highschool1 = new HighSchool("JohnJay");
		HighSchool highschool2 = new HighSchool("Arlington");
		HighSchool highschool3 = new HighSchool("Beacon");
		
		HighSchoolStudent highschoolStudent1 = new HighSchoolStudent(highschool1, person1);
		HighSchoolStudent highschoolStudent2 = new HighSchoolStudent(highschool2, person2);
		HighSchoolStudent highschoolStudent3 = new HighSchoolStudent(highschool3, person3);
		
		University university1 = new University("BU", "Binghamton");
		University university2 = new University("SBU", "Stonybrook");
		
		UniversityStudent universityStudent1 = highschoolStudent1.goToUniversity(university1);
		UniversityStudent universityStudent2 = highschoolStudent2.goToUniversity(university2);
		
		Company company1 = new Company("I.B.M.", "Armonk");
		Company company2 = new Company("Bloomberg", "N.Y.C");
		
		Employee employee1 = universityStudent1.getAJob(company1, 120000);
		
		
		
		
		person1.printHistory();
		System.out.println("---------------------");
		person2.printHistory();
		System.out.println("---------------------");
		person3.printHistory();		
		System.out.println("---------------------");
		person4.printHistory();
		System.out.println("---------------------");
		
		highschoolStudent1.changeHighSchool(highschool2);
		universityStudent1.transferUniversity(university2);
		employee1.changeJob(company2);
		person1.printHistory();
		System.out.println("---------------------");
		
		
		
	}

}
