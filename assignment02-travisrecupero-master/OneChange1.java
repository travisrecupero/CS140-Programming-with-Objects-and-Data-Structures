package assignment02;

import java.util.Arrays;

public class OneChange1 {
	
	private int[] array;

	public OneChange1(int[] array) {
		this.array = array;
	}
	
	public int largestAfter(int start){
		int largest = start;
		for(int i = start + 1; i < array.length; i++){ //get index with largest value
			if(array[largest] < array[i]){
				largest = i; 
			}
		}
		return largest;
	}
	

	public int[] modify(int start){
		int[] temp = new int[array.length];
		int k = largestAfter(start); //   k = 1;   |  start = 4;
		
		
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
