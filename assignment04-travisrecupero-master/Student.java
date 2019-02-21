package assignment04;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String name;
	private Set<Courses> taken = new HashSet<>();

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<Courses> getTaken() {
		return taken;
	}
	
	public void addCourse(Courses crs) {
		taken.add(crs);
	}
	
	public Set<Courses> needToTakeBefore(Courses crs){
		Set<Courses> needed = new HashSet<>();
		needed.add(crs);
		boolean changed = true;
		
		while(changed) {
			changed = false;
			int temp = needed.size();
			Set<Courses> tempSet = new HashSet<>();
		
			for(Courses d : needed) { //if the getPrereqs of d are not null, call
				if(d.getPrereqs() != null) {
				tempSet.addAll(d.getPrereqs());
				}
			}
			
			needed.addAll(tempSet);
			
			if(needed.size() > temp) {
				changed = true;
			}
			
			
			for(Courses e : taken) {
				needed.remove(e);
			}
			
			
			needed.remove(crs);
		}
		return needed;
	}
	
}
