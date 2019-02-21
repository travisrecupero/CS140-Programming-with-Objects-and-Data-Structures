package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NumberReader {

	private static int[] readString(String line) {
		// first count how many integers are in the line
		var count = 0; // in Java 10 we can use "var" and Java infers the type.
		try (var lineScan = new Scanner(line)) { // this is "try with resources"
													// the Scanner will be closed automatically
													// if anything goes wrong
			while (lineScan.hasNextInt()) {
				count++;
				lineScan.nextInt();
			}
		}
		// make an array with length count
		var retVal = new int[count];
		try (var lineScan = new Scanner(line)) { // open the scanner again from the start
			for (int i = 0; i < count; i++) {
				retVal[i] = lineScan.nextInt();
			}
		}
		return retVal;

	}

	public static int[][] readArray(String fileName) throws FileNotFoundException {

		var count = 0;

		// get array size (amount of lines)
		try (var scan = new Scanner(new File(fileName))) {
			while (scan.hasNextLine()) {
				count++;
				scan.nextLine();
			}
		}
		// set array size
		var retVal = new int[count][];

		// reopen scanner
		// set array values
		try (var scan = new Scanner(new File(fileName))) {
			for (int i = 0; i < count; i++) {
				retVal[i] = readString(scan.nextLine());
			}
			return retVal;
		}

	}

	public static int[] flatten(int[][] arrays) {
		int counter = 0;
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				counter++;
			}
		}

		int[] temp = new int[counter];
		int k = 0;
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				temp[k++] = arrays[i][j];

			}
		}
		return temp;
	}
	
	public static boolean compare(int[][] arrays, String filename) throws FileNotFoundException{
		var flat = flatten(arrays);
		try (var scan = new Scanner(new File(filename))) {
			while (scan.hasNextInt()) {
				for(int i = 0; i < flat.length; i++) {
					int tempArrayInt = flat[i];
					int tempFileInt = scan.nextInt();
				
					if(tempArrayInt != tempFileInt) { //different element (test3)
						System.out.println("element changed");
						return false;
					}	
					//flat is bigger, return false
					if(scan.hasNextInt() == false && i != flat.length - 1) { //remove element (test1)
						System.out.println("removed element");
						return false;
					}
					//file is bigger, return false
					if(i == flat.length - 1 && scan.hasNextInt() == true) { //added text file integer (test3)
						System.out.println("added element");
						return false;
					}
				
				}
			}
			System.out.println("original");
			return true;
		}
		

	}
	

}
