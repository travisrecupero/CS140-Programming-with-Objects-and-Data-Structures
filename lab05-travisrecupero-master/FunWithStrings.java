package lab05;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;



public class FunWithStrings{

public static void swapMaxes(List<String> list1, List<String> list2){

	String temp1 = "";
	String temp2 = "";

	if(list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0){
		throw new IllegalArgumentException("cannot swap maxes of empty lists, null lists, or lists with all null elements");
	}
	
	//get largest string in list1
	for(int i = 0; i < list1.size(); i++){	
		if(temp1.length() < list1.get(i).length()){
		temp1 = list1.get(i);		
		}
	}
	
	//get largest string in list2
	for(int i = 0; i < list2.size(); i++){	
		if(temp2.length() < list2.get(i).length()){
		temp2 = list2.get(i);		
		}
	}

	//change list1 element to largest element from list2
	for(int i = 0; i < list1.size(); i++){	
		if(list1.get(i) == temp1){
		list1.set(i, temp2);		
		}
	}
	//change list2 element to largest element from list1
	for(int i = 0; i < list2.size(); i++){	
		if(list2.get(i) == temp2){
		//list2.get(i) = temp1;	
		list2.set(i, temp1);		
		}
	}

}

}
