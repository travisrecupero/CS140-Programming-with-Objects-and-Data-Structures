package lab04;
import java.util.Arrays;

public class FileExtractorTester{
	
	public static void main(String[] args){
	System.out.println("input file: [5, 20, 8, 13, 46, 7]");
	System.out.println("Expected array output: [20, 8, 46]");
	System.out.println("Expected list output: [5, 13, 7]");
	if(args.length != 1){
		throw new IllegalArgumentException("The program requires exactly 1 argument, the name of a file to be opened");	
	}
	else{
		FileExtractor fe = new FileExtractor(args[0]);
		fe.removeOddElements();
		fe.removeEvenElements();

		System.out.println(fe);
	}


	int[] array = new int[5];
	int n = 0;
	for (int i : array) {
   	 	i = n;
    		n++; // shorthand to increment by 1
	}
	System.out.println("For-each example: " + Arrays.toString(array) + "\n");
	
	System.out.println("Four Strings: ");
	String[] strings = {"Fee", "Fi", "Fo", "Fum"};
	for (String s : strings) {
   	 	System.out.println(s + " " + s.length());
	}

	}

}
