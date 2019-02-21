package assignment02;
import java.util.Arrays;

public class WeirdSorterTester {

	public static void main(String[] args) {

		int[] test = {3,7,9,10,2,6,3,1};
		WeirdSorter ws = new WeirdSorter(test);
		
		int[] test1 = {3,7,9,10,2,6,3,1};
		WeirdSorter1 ws1 = new WeirdSorter1(test1);

		System.out.print("Weird Sorter: \n");
		System.out.println(Arrays.toString(test));
		test = ws.sorted();
		System.out.println(Arrays.toString(test) + "\n");
		
		
		System.out.print("Weird Sorter 1: \n");
		System.out.println(Arrays.toString(test1));
		test1 = ws1.sorted();
		System.out.println(Arrays.toString(test1));
		
		
		
	}

}
