package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static assignment04.NumberReader.*;
import static assignment04.NumberReader2.*;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		//variable for file name 
		String test = "test.txt";
		String test1 = "test1.txt"; //remove element from txt file
		String test2 = "test2.txt"; //add element to end of txt file
		String test3 = "test3.txt"; //change number in txt file
		
		//initialize array for number reader
		int[][] array1 = null;
		array1 = readArray(test); 
		
		//print array
		System.out.println("--------------------------------------------------------------");
		System.out.println("Expected Array: ");
		System.out.println("[[1, 4, 2, 18, 12], [], [2], [1, 5, 23, -10, 6, 8], [7, -100], [34, 6, 0]]");
		System.out.println("Array: ");
//		for(int i = 0; i < array1.length; i++) {
//			for(int j = 0; j < array1[i].length; j++) {
//				System.out.print(array1[i][j] + " ");
//			}
//		}
//		System.out.println("\n");
		//use deepToString() to print out multidimensional arrays in java
		System.out.println(Arrays.deepToString(array1));
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------");

		
		//initialize list of integer list for number reader 2 
		List<List<Integer>> list1 = new ArrayList<>();
		list1 = readList2(test);
		
		//print list
		System.out.println("Expected List: ");
		System.out.println("[[1, 4, 2, 18, 12], [], [2], [1, 5, 23, -10, 6, 8], [7, -100], [34, 6, 0]] ");
		System.out.println("List: ");
		System.out.println(list1);
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------");

		
		
		//initialize for flatten
		int[][] array2 = null;
		int[] array3;
		array2 = readArray(test); 
		array3 = flatten(array2);
		System.out.println("Expected Flattened Array: ");
		System.out.println("[1, 4, 2, 18, 12, 2, 1, 5, 23, -10, 6, 8, 7, -100, 34, 6, 0]");
		System.out.println("Flattened Array: ");
		System.out.println(Arrays.toString(array3));
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------");

		
		//initialize list of integer list for flatten 2
		List<List<Integer>> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		list2 = readList2(test);
		list3 = flatten2(list2);
		System.out.println("Expected Flattened List: ");
		System.out.println("[1, 4, 2, 18, 12, 2, 1, 5, 23, -10, 6, 8, 7, -100, 34, 6, 0]");
		System.out.println("Flattened List: ");
		System.out.println(list3);
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------");
		
		//print changed files for array
		System.out.println("Array Compares: \n");
		int[][] array4 = null;
		array4 = readArray(test); 
		System.out.println(compare(array4, test) + " Original File" + "\n"); //this calls flatten
		System.out.println(compare(array4, test1) + " (test1.txt)" + "\n"); //
		System.out.println(compare(array4, test2) + " (test2.txt)" + "\n");
		System.out.println(compare(array4, test3) + " (test3.txt)" + "\n"); //should return 1
		System.out.println("--------------------------------------------------------------");
		
		//print changed files for array
		System.out.println("List Compares: \n");
		List<List<Integer>> list4 = new ArrayList<>();
		list4 = readList2(test);
		System.out.println(compare(list4, test) + " Original File" + "\n"); //this calls flatten
		System.out.println(compare(list4, test1) + " (test1.txt)" + "\n"); //
		System.out.println(compare(list4, test2) + " (test2.txt)" + "\n");
		System.out.println(compare(list4, test3) + " (test3.txt)" + "\n"); //should return 1
		System.out.println("--------------------------------------------------------------");


		
		
		Student s = new Student("Travis");
		Set<Courses> needed = s.needToTakeBefore(Courses.CS140);
		System.out.println("Needed courses: " + needed + "\n");
		
		s.addCourse(Courses.CS110);
		needed = s.needToTakeBefore(Courses.CS140);
		System.out.println("Needed courses after course added: " + needed + "\n");
		
		

		
		
		
		
		
		
		
		
		
		
	}

	
}
