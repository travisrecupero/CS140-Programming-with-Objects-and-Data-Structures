package assignment05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwoDimNumArr {

	private int[][] array;

	private static int[] readString(String line) {
		var count = 0;
		try (var lineScan = new Scanner(line)) {
			while (lineScan.hasNextInt()) {
				count++;
				lineScan.nextInt();
			}
		}

		var retVal = new int[count];
		try (var lineScan = new Scanner(line)) { // open the scanner again from the start
			for (int i = 0; i < count; i++) {
				retVal[i] = lineScan.nextInt();
			}
		}
		return retVal;
	}

	public TwoDimNumArr(String fileName) throws FileNotFoundException {
		var count = 0;
		try (var scan = new Scanner(new File(fileName))) {
			while (scan.hasNextLine()) {
				count++;
				scan.nextLine();
			}
		}

		array = new int[count][];
		try (var scan = new Scanner(new File(fileName))) {
			for (int i = 0; i < count; i++) {
				array[i] = readString(scan.nextLine());
			}
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

	public boolean compare(String filename) throws FileNotFoundException {
		var flat = flatten(array);
		try (var scan = new Scanner(new File(filename))) {
			while (scan.hasNextInt()) {
				for (int i = 0; i < flat.length; i++) {
					int tempArrayInt = flat[i];
					int tempFileInt = scan.nextInt();

					if (tempArrayInt != tempFileInt) { // different element (test3)
						System.out.println("element changed");
						return false;
					}
					// flat is bigger, return false
					if (scan.hasNextInt() == false && i != flat.length - 1) { // remove element (test1)
						System.out.println("removed element");
						return false;
					}
					// file is bigger, return false
					if (i == flat.length - 1 && scan.hasNextInt() == true) { // added text file integer (test3)
						System.out.println("added element");
						return false;
					}

				}
			}
			System.out.println("Original");
			return true;
		}
	}
	
	
	public int compareTo(TwoDimNumArr other) {
		return Arrays.compare(flatten(this.array), flatten(other.array));
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (var row : array) {
			for (var num : row) {
				sb.append(num + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		return sb.toString();
	}

}
