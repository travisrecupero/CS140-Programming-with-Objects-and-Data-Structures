package lab03;

import java.util.List;
import java.util.ArrayList;

public class ClassRoom {
	
	private List<Student> roster = new ArrayList<>();

	
	public List<Student> getRoster() {
		return roster;
	}

	public void addStudent(Student s) {
		roster.add(s);
	}
	
	public void dropStudent(int id) {
		for(int i = 0; i < roster.size(); i++){
			if(roster.get(i).getId() == id){
				roster.remove(i);
			}
		}
	}
	
	public void sortById(){
		 for(int i = 0; i < roster.size(); i++){
		      for(int j = 1; j < (roster.size()-i); j++){
		              if(roster.get(j-1).getId() > roster.get(j).getId()){
		                       //swap elements
		            	  	    Student s = roster.get(j-1);
		            	  		roster.set(j-1, roster.get(j));
		            	  		roster.set(j, s);
		              }
		      }
		  }
		}

	@Override
	public String toString() {
		return "ClassRoom [roster=" + roster + ", toString()=" + super.toString() + "]";
	}

	

	
	
	
	
	
}
