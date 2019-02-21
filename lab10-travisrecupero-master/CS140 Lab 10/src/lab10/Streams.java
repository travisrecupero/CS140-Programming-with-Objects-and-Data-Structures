package lab10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Streams {

	private static List<String> someBingoNumbers = Arrays.asList("N40", "n36", "B12", "b6", "G49", "G53", "G60", "G50",
			"g64", "I26", "i17", "I29", "O71");

	public static List<String> grabBingoNums(String letter){
		return someBingoNumbers.stream()
				.map(w -> w.toUpperCase())
				.filter(w -> w.contains(letter))
				.sorted()
				.collect(Collectors.toList());
	
	}

	public static List<Integer> extractNums() {
		return someBingoNumbers.stream()
				.map(w -> Integer.parseInt(w.substring(1)))
				.collect(Collectors.toList());
	}

	
	public static int sumLists(List<List<Integer>> lists) {
		return lists.stream()
				.flatMap(w -> w.stream())
				.reduce(0, (a,b) -> a + b);
	}

	public static boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
/*		boolean isBackwards = false;
		StringBuilder strB = new StringBuilder(str);
		strB.reverse();
		if(str.equals(strB.toString())){
			isBackwards = true;
			return isBackwards;
		} else {
			return isBackwards;
		}*/
		
	}
	
	public static void printPalindromes(List<String> list) {
		list.stream().filter(Streams::isPalindrome).forEach(System.out::println);
	}
	
	public static long countOdd(int[] arr) {
		return Arrays.stream(arr).filter(w -> w % 2 != 0).count();
	}
	
}
