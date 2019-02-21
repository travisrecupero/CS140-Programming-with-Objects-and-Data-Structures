package assignment02;

import java.util.Arrays;

public class OneChangeTester {

	public static void main(String[] args) {

		int[] test = {3,7,9,10,2,6,3,1,2};
		OneChange one = new OneChange(test);
		
		int[] test1 = {3,7,9,10,2,6,3,1,2};
		OneChange1 one1 = new OneChange1(test1);
		
		System.out.print("One Change: \n");
		System.out.println(Arrays.toString(test));
		System.out.println(Arrays.toString(one.modify(4)) + "\n");
		
		
		System.out.println("One Change 1: ");
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(one1.modify(4)));
		
		
		
	}

}
