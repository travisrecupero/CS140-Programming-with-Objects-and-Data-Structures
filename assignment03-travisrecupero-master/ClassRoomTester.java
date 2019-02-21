package assignment03;

public class ClassRoomTester{
	
	public static void main(String[] args){
		ClassRoom classRoom = new ClassRoom();

		classRoom.addStudent(new Student("5", "Gina", "G"));
		classRoom.addStudent(new Student("3", "Tyler", "T"));
		classRoom.addStudent(new Student("4", "Arnold", "A"));
		classRoom.addStudent(new Student("1", "Jessica", "J"));
		classRoom.addStudent(new Student("2", "Richard", "R"));

		System.out.println("**************Original Class Roster**********");
		System.out.println(classRoom);

		classRoom.dropStudent("3");
		System.out.println("\n*******Dropped Tyler from the Roster**********");
		System.out.println(classRoom);

		
		classRoom.sortById();
		System.out.println("\n*******Roster after sorting by Id's**********");
		System.out.println(classRoom);

		for(Student s : classRoom.getRoster()){
			System.out.println("Name: " + s.getName() + "\tId: " + s.getBnumber());
		}

		
		classRoom.sortByName();
		System.out.println("\n*******Roster after sorting by Name**********");
		System.out.println(classRoom);

		for(Student s : classRoom.getRoster()){
			System.out.println("Name: " + s.getName() + "\tId: " + s.getBnumber());
		}
		
	}
}
