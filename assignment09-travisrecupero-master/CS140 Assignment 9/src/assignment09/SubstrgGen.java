package assignment09;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SubstrgGen {

	//returns a TreeSet<String>
	public static Set<String> subStrs(String starter){
		Set<String> retVal = new TreeSet<>();
		
		if(starter.length() == 1 || starter.length() == 0) {
			retVal.add(starter);
			retVal.add("");
			return retVal;
		} else {
			for(int i = 0; i <= starter.length(); i++) {
				retVal.add(starter.substring(0, i));
			}
		
			Set<String> smallerSubstrings = subStrs(starter.substring(1));
			retVal.addAll(smallerSubstrings);
			return retVal;
			
		}
		
	}
	
	//returns an ArrayList<String>
	public static List<String> subStr1(String starter){
		List<String> retVal = new ArrayList<>();
		//handle base cases
		if(starter.length() <= 1) {
			if(starter.length() == 1) retVal.add(starter);
			retVal.add("");
			return retVal;
		}
		//otherwise, add all substrings that start with
		//the first letter
		for(int i = 1; i <= starter.length(); i++) {
			if(!retVal.contains(starter.substring(0, i)))
				retVal.add(starter.substring(0, i));
		}
		//next recursively all substrings of starter
		//but with the first char removed
		List<String> recurse = subStr1(starter.substring(1));
		for(String str : recurse) {
			if(!retVal.contains(str))
				retVal.add(str);
		}
		return retVal;
	}

	
	
	
}
