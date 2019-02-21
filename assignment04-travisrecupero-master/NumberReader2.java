package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumberReader2 {

	private static List<Integer> readString2(String line) {
		var retVal = new ArrayList<Integer>();

		try (var lineScan = new Scanner(line)) {
			while (lineScan.hasNextInt()) {
				retVal.add(lineScan.nextInt());
			}
		}

		return retVal;

	}

	public static List<List<Integer>> readList2(String fileName) throws FileNotFoundException {
		List<List<Integer>> retVal = new ArrayList<>();
		try (var scan = new Scanner(new File(fileName))) {
			while (scan.hasNextLine()) {
				retVal.add(readString2(scan.nextLine()));
			}
			return retVal;
		}

	}

	public static List<Integer> flatten2(List<List<Integer>> list) {
		List<Integer> temp = new ArrayList();
		int k = 0;
		for (List<Integer> i : list) {
			for (int j = 0; j < i.size(); j++) {
				temp.add(k++, i.get(j));
			}
		}
		return temp;

	}

	public static boolean compare(List<List<Integer>> list, String filename) throws FileNotFoundException {
		List<Integer> flat = flatten2(list);
		List<Integer> flat2 = new ArrayList<>();

		try (var scan = new Scanner(new File(filename))) {
			while (scan.hasNextInt()) {
				for (int i = 0; i < flat.size(); i++) {
					int tempArrayInt = flat.get(i);
					int tempFileInt = scan.nextInt();

					if (tempArrayInt != tempFileInt) { // different element (test3)
						System.out.println("element changed");
						return false;
					}
					// flat is bigger, return false
					if (scan.hasNextInt() == false && i != flat.size() - 1) { // remove element (test1)
						System.out.println("removed element");
						return false;
					}
					// file is bigger, return false
					if (i == flat.size() - 1 && scan.hasNextInt() == true) { // added text file integer (test3)
						System.out.println("added element");
						return false;
					}
				}
			}
		}
		System.out.println("original");
		return true;

//		List<Integer> flat = flatten2(list);
//		List<Integer> flat2 = new ArrayList<>();
//		
//		flat2 = readString2(filename);
//		
//		//flat2.addAll(readString2(filename));
//		
//		System.out.println(flat + "flat");
//		System.out.println(flat2 + "flat2");
//		
//		if(flat.size() == flat2.size()) {
//			for(int i = 0; i < flat.size(); i++){
//				if(flat.get(i) != flat2.get(i)) {
//					System.out.println("Different element");
//					return false;
//				} else {
//					System.out.println("Same as original");
//					return true;
//				}
//			}
//		} else {
//			System.out.println("Element removed or added");
//			return false;
//		}
//		

	}

}
