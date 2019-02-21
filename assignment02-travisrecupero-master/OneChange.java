package assignment02;

import java.util.Arrays;

public class OneChange {

	private int[] array;

	public OneChange(int[] array) {
		this.array = array;
	}
	
	public int smallestAfter(int start){
		int smallest = start;
		for(int i = start + 1; i < array.length; i++){ //get index with largest value
			if(array[smallest] > array[i]){
				smallest = i; 
			}
		}
		return smallest;
	}
	

	public int[] modify(int start){
		int[] temp = new int[array.length];
		int k = smallestAfter(start); //   k = 1;   |  start = 4;
		
		
		//////////////////////////////////////////////////////////
		for(int j = 0; j < start; j++){ //make temp = array
			temp[j] = array[j]; //copy array
		}
		temp[start] = array[k]; //set starting index (index 4) EQUAL TO lowest value (1)
		
		
		//////////////////////////////////////////////////////////
		for( int j = start; j < k; j++){
			temp[j+1] = array[j];
		}
		
		
		//////////////////////////////////////////////////////////
		for(int j = k + 1; j < array.length; j++){
			temp[j] = array[j];
		}
		
		return temp;

	}

	
	
	
}
