package assignment05;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static assignment05.Counter5.*;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("TESTING StringBuilder: ");
		var test = new TwoDimNumArr("input.txt");
		System.out.println(test.toString());
		System.out.println("------------------------------------------" + "\n");

		
		
		System.out.println("TESTING compareTo(): ");
		var v1 = new TwoDimNumArr("test1.txt");
		var v2 = new TwoDimNumArr("test2.txt");
		var v3 = new TwoDimNumArr("test3.txt");
		System.out.println(v1.compareTo(v2) + ", Expected: -1"); // prints a negative number
		System.out.println(v2.compareTo(v3) + ", Expected: 0" + "\n"); // prints 0 but test1.txt and text2.txt have different numbers of rows
		System.out.println("------------------------------------------" + "\n");

		
		
		Locations location = new Locations();
		int[] nullArray = null; // null array
		int[] emptyArray = new int[0]; // empty array
		int[] nonEmptyArray = { 10, 20, 30, 40, 50, 60, 70, 10, 20, 30, 40, 50, 60, 20, 30, 40, 50, 60, 30, 40, 60 };
		System.out.println("\n" + "TESTING lessEQ(): " + "\n");
		System.out.println(location);
		System.out.println(Arrays.toString(location.lessEQ(nonEmptyArray)) + "\n");
		System.out.println("Non-empty Array: " + Arrays.toString(nonEmptyArray) + "\n");
		System.out.println("Check null array: " + Arrays.toString(location.lessEQ(nullArray)));
		System.out.println("Check empty array: " + Arrays.toString(location.lessEQ(emptyArray)) + "\n");
		System.out.println("Indices where locations is smaller than non-empty array: " + "\n"
				+ Arrays.toString(location.lessEQ(nonEmptyArray)));
		System.out.println("------------------------------------------");

		
		
		System.out.println("\n" + "TESTING LocalDateTime: " + "\n");
		var testDate = new DiaryEvent("Office Hours", 2018, 9, 18, 14, 30, 60);
		System.out.println(testDate + "\n");
		System.out.println("------------------------------------------" + "\n");

		
		
		
		System.out.println("\n" + "TESTING monthBreakdown(): " + "\n");
		System.out.println("Expected DiaryEvent[] month: [9, 10, 11, 2, 1, 11, 10, 9, 10, 11, 10, 11, 1] ");
		DiaryEvent[] testDate1 = new DiaryEvent[] { new DiaryEvent("Office Hours 1", 2018, 9, 1, 14, 30, 60),
				new DiaryEvent("Office Hours 2", 2018, 10, 2, 14, 30, 60),
				new DiaryEvent("Office Hours 3", 2018, 11, 3, 14, 30, 60),
				new DiaryEvent("Office Hours 4", 2018, 2, 4, 14, 30, 60),
				new DiaryEvent("Office Hours 5", 2018, 1, 5, 14, 30, 60),
				new DiaryEvent("Office Hours 6", 2018, 11, 6, 14, 30, 60),
				new DiaryEvent("Office Hours 7", 2018, 10, 8, 14, 30, 60),
				new DiaryEvent("Office Hours 8", 2018, 9, 2, 14, 30, 60),
				new DiaryEvent("Office Hours 9", 2018, 10, 4, 14, 30, 60),
				new DiaryEvent("Office Hours 10", 2018, 11, 3, 14, 30, 60),
				new DiaryEvent("Office Hours 11", 2018, 10, 2, 14, 30, 60),
				new DiaryEvent("Office Hours 12", 2018, 11, 3, 14, 30, 60),
				new DiaryEvent("Office Hours 13", 2018, 1, 5, 14, 30, 60)};
		System.out.println("\t\t\t\t" + Arrays.toString(DiaryEvent.monthBreakdown(testDate1)) + "\n");
		List<DiaryEvent> testDate2 = new ArrayList<>(Arrays.asList( new DiaryEvent("Office Hours 1", 2018, 9, 1, 14, 30, 60),
				new DiaryEvent("Office Hours 2", 2018, 10, 2, 14, 30, 60),
				new DiaryEvent("Office Hours 3", 2018, 11, 3, 14, 30, 60),
				new DiaryEvent("Office Hours 4", 2018, 2, 4, 14, 30, 60),
				new DiaryEvent("Office Hours 5", 2018, 5, 5, 14, 30, 60),
				new DiaryEvent("Office Hours 6", 2018, 11, 6, 14, 30, 60),
				new DiaryEvent("Office Hours 7", 2018, 10, 8, 14, 30, 60),
				new DiaryEvent("Office Hours 8", 2018, 9, 2, 14, 30, 60),
				new DiaryEvent("Office Hours 9", 2018, 10, 4, 14, 30, 60),
				new DiaryEvent("Office Hours 10", 2018, 11, 3, 14, 30, 60),
				new DiaryEvent("Office Hours 11", 2018, 10, 2, 14, 30, 60),
				new DiaryEvent("Office Hours 12", 2018, 11, 3, 14, 30, 60),
				new DiaryEvent("Office Hours 13", 2018, 3, 5, 14, 30, 60)));
		System.out.println("Expected earliest month on list: Office Hours 4 at 2018-02-04T14:30, lasting 60 minutes.");
		System.out.println("\t\t\t\t" + DiaryEvent.earliest(testDate2));
		System.out.println("------------------------------------------" + "\n");

		
		
		
		System.out.println("\n" + "TESTING counter() " + "\n");
		String[] str1 = { "", null, "", "", "", "Hello"};
		System.out.println("Expected[]: [1, 4, 1]");
		System.out.println("[nullCount, emptyCount, diffCount]  ->   " + Arrays.toString(counter(str1, 'h')) + "\n");
		List<String> list1 = new ArrayList<>(Arrays.asList("", null, "", "", "", "Hello"));
		System.out.println("Expected (list): [1, 4, 1]");
		System.out.println("\t\t " + Counter5.counter(list1, 'h'));
		
		
		

	}

}
