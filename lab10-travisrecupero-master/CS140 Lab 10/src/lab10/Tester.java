package lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tester extends Streams{
	public static void main(String[] args){
		
		System.out.println("B bingo nums: " + grabBingoNums("B"));
		System.out.println("I bingo nums: " + grabBingoNums("I"));
		System.out.println("N bingo nums: " + grabBingoNums("N"));
		System.out.println("G bingo nums: " + grabBingoNums("G"));
		System.out.println("O bingo nums: " + grabBingoNums("O"));
		System.out.println("-------------------------------------------");
		
		System.out.println("extracted nums: " + extractNums());
		System.out.println("-------------------------------------------");
		
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(extractNums());
		lists.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		lists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		lists.add(new ArrayList<Integer>(Arrays.asList(7,8,9, 10)));
		System.out.println("sum: " + sumLists(lists));
		System.out.println("-------------------------------------------");
		
		System.out.println("odd count: " + countOdd(new int[]{1,2,3,4,5,6,7,8,9}));
		System.out.println("-------------------------------------------");

		List<String> words = new ArrayList<>();
		words.add("101");
		words.add("11011");
		words.add("cat");
		words.add("1000");
		words.add("12321");
		words.add("civic");
		words.add("sagas");
		words.add("dog");
		words.add("rotator");
		words.add("racecar");
		words.add("banana");
		words.add("animal");
		words.add("anna");
		
		System.out.println("palindromes: ");
		printPalindromes(words);
	}	
}
