package assignment05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Counter5 {
	
	public static int[] counter(String[] strings, char ch) {
	
		if (strings == null) {
			return null;
		} else {
			int[] retVal = new int[3];
			int nullCounter = 0;
			int emptyCounter = 0;
			int chCounter= 0;
			for (int i = 0; i < strings.length; i++) {
				if (strings[i] == null) { //if null
					nullCounter++;
					retVal[0] = nullCounter;
				} else if (strings[i].length() == 0) { //if empty
					emptyCounter++;
					retVal[1] = emptyCounter;
				} else {
					for (int j = 0; j < strings[i].length(); j++) {
						//if toUpper/Lower is different -> increase counter
						if (strings[i].charAt(j) == Character.toUpperCase(ch) || strings[i].charAt(j) == Character.toLowerCase(ch)) {
							chCounter++;
							retVal[2] = chCounter;
						}
					}
				}
			}
			return retVal;
		}
	}
		
	public static List<Integer> counter(List<String> strings, char ch){
		if(strings == null){
			return null;
		}	
		else{
			int nullCounter = 0;
			int emptyCounter = 0;
			int chCounter= 0;
			List<Integer> retVal = new ArrayList<>(Arrays.asList(0,0,0));
			for(int i = 0; i < strings.size(); i++){			
				if(strings.get(i) == null){
					nullCounter++;
					retVal.set(0, nullCounter);
				}
				else if(strings.get(i).length() == 0){
					emptyCounter++;
					retVal.set(1, emptyCounter);
				}
				else{
					for(int j = 0; j < strings.get(i).length(); j++){
						if(strings.get(i).charAt(j) == Character.toUpperCase(ch) || strings.get(i).charAt(j) == Character.toLowerCase(ch)){
							chCounter++;
							retVal.set(2, chCounter);
						}
					}
				}
			}
			return retVal;
		}	
		
	}
		
		
//		
//		//initialization
//				List<Integer> list = new ArrayList<>();
//				
//				//if null return nothing
//				if(strings == null) {
//					return null;
//				}
//				
//				//count number of null strings
//				int nullCounter = 0;
//				for(int i = 0; i < strings.size(); i++) {
//					if(strings.get(i) == null) {
//						nullCounter++;
//					}
//				}
//				list.add(0, nullCounter);
//				
//				//count number of empty strings
//				int emptyCounter = 0;
//				for(int i = 0; i < strings.size(); i++) {
//					if(strings.get(i).isEmpty()) {
//						emptyCounter++;
//					}
//				}
//				list.add(1, emptyCounter);
//				
//				
//				int chCounter = 0;
//				String str = "";
//				for(int i = 0; i < strings.size(); i++) {
//					str = strings.get(i);
//					for (char c : str.toCharArray()) {
//						char temp = c;
//						Character.toUpperCase(temp);
//						if(Character.isLowerCase(c)) {
//							chCounter++;
//						}
//					}
//				}
//				list.add(2, chCounter);
//				
//				
//				return null;
//	
//	}
	
	
	
	/*	
//		
//		
//		//		//initialization
////		int[] retVal = new int[3];
////		
////		//if null return nothing
////		if(strings == null) {
////			return null;
////		}
////		
////		//count number of null strings
////		int nullCounter = 0;
////		for(String s : strings) {
////			if(s == null) {
////				nullCounter++;
////			}
////		}
////		retVal[0] = nullCounter;
////		
////		//count number of empty strings
////		int emptyCounter = 0;
////		for(String s : strings) {
////			if(s.length() == 0 ) {
////				emptyCounter++;
////			}
////		}
////		retVal[1] = emptyCounter;	
////		
////		
////		int chCounter = 0;
////		String str = "";
////		//char temp;
////		for(int i = 0; i < strings.length; i++) {
////			str = strings[i];
////			char[] temp1 = str.toCharArray();
////			char[] temp2 = str.toLowerCase().toCharArray();
////			
////			for (char c : temp1 ) {
////				for(char v : temp2) {
////					if(Character.isLowerCase(c) && Character.isUpperCase(v)) {
////						chCounter++;
////					}
////					else if(Character.isLowerCase(v) && Character.isUpperCase(c)) {
////						chCounter++;
////					}
////				}
////				
////			}
		
			*/
		
//			for(int j = 0; j < str.length(); j++) {
//				if(temp1 != temp2) {
//					System.out.println(temp1);
//					System.out.println(temp2);
//					chCounter++;
//				}
//			}
			
			
			//			for (char c : str.toCharArray()) {
//				temp = c;
//				
//				if(Character.isLowerCase(c) && Character.isUpperCase(temp)) {
//					chCounter++;
//				}
//				
//					
////				char temp = c;
////				Character.toUpperCase(temp);
////				if(Character.isLowerCase(c)) {
////					chCounter++;
////				}
//			
//			}
//	}
//	retVal[2] = chCounter;
		
		

	

	
	
/*	public static List<Integer> counter(List<String> strings, char ch){
		//initialization
				List<Integer> list = new ArrayList<>();
				
				//if null return nothing
				if(strings == null) {
					return null;
				}
				
				//count number of null strings
				int nullCounter = 0;
				for(int i = 0; i < strings.size(); i++) {
					if(strings.get(i) == null) {
						nullCounter++;
					}
				}
				list.add(0, nullCounter);
				
				//count number of empty strings
				int emptyCounter = 0;
				for(int i = 0; i < strings.size(); i++) {
					if(strings.get(i).isEmpty()) {
						emptyCounter++;
					}
				}
				list.add(1, emptyCounter);
				
				
				int chCounter = 0;
				String str = "";
				for(int i = 0; i < strings.size(); i++) {
					str = strings.get(i);
					for (char c : str.toCharArray()) {
						char temp = c;
						Character.toUpperCase(temp);
						if(Character.isLowerCase(c)) {
							chCounter++;
						}
					}
				}
				list.add(2, chCounter);
				
				
				return null;
	
	}*/
	
	
	
}
