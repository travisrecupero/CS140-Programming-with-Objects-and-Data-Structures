package assignment05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Locations {

	private int[] array;
	public static final Random rand = new Random();

	public Locations(int[] array) {
		this.array = array;
	}

	public Locations() {
		int len = 10 + rand.nextInt(50);
		array = new int[len];

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
	}


	public int[] getArray() {
		return array;
	}

	public int[] lessEQ(int[] test) {
		//initialize
		List<Integer> list = new ArrayList<>();
		
		//checks
		if (array == null || test == null) {
			return null;
		}
		if (array.length == 0 || test.length == 0) {
			int[] empty = null;
			return empty;
		}
		
		//method
		int shorterSize = 0;
		if (array.length > test.length) {
			shorterSize = test.length;
		} else {
			shorterSize = array.length;
		}
		
		for (int i = 0; i < shorterSize; i++) {
			if(array[i] <= test[i]) {
				list.add(i);
			}
		}
		
		int[] retVal = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			retVal[i] = list.get(i);
		}
		
		
		return retVal;
	}

	@Override
	public String toString() {
		return "Locations array: " + Arrays.toString(array);
	}
	
}
