package assignment03;

import java.util.ArrayList;
import java.util.List;


public class ClassRoom {

	private List<Student> roster = new ArrayList<>();

	public List<Student> getRoster() {
		return roster;
	}

	public void addStudent(Student s) {
		roster.add(s);
	}

	public void dropStudent(String bnum) {
		for (int k = 0; k < roster.size(); k++) {
			if (roster.get(k).getBnumber().equals(bnum)) {
				roster.remove(k);
			}
		}
	}

	public void sortById() {
		for (int i = 0; i < roster.size(); i++) {
			for (int j = 1; j < (roster.size() - i); j++) {
				if (Student.compareBnum(roster.get(j-1), roster.get(j)) > 0) {
					// swap elements
					Student s = roster.get(j - 1);
					roster.set(j - 1, roster.get(j));
					roster.set(j, s);
				}
			}
		}
	}
	
	public void sortByName() {
		for (int i = 0; i < roster.size(); i++) {
			for (int j = 1; j < (roster.size() - i); j++) {
				if (Student.compareName(roster.get(j-1), roster.get(j)) > 0) {
					// swap elements
					Student s = roster.get(j - 1);
					roster.set(j - 1, roster.get(j));
					roster.set(j, s);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "ClassRoom: " + roster;
	}

}