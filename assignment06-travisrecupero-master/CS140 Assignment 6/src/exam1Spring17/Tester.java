package exam1Spring17;

public class Tester {

	public static void main(String[] args) {
		
		Ques1 q = new Ques1(36);
		System.out.println("Smallest: " + q.smallest());
		System.out.println(); 
		for(int i = 18; i < 23; i++) {
			System.out.println(new Ques1(i));
			}
		System.out.println("--------------------------" + "\n");
		System.out.println("Testing Factorize: ");
		System.out.println(q.factorize());
		System.out.println("\n" + "--------------------------" + "\n");
		
		
		
		System.out.println("PLEASE READ COMMENT IN MAX METHOD. . . ");
		int[] test1 = null;
		int[] test2 = {};
		int[] test3 = {5, 2, -2, 7, -5, 2}; 
		System.out.println(new Top(test1).average() + " average test 1 (null)");
		System.out.println(new Top(test3).average() + " average test 3 (not null/empty)");
		System.out.println(new Lower(test3, test2).average() + " average test 3 and 2 (not null/empty and empty)");
		System.out.println(new Lower(test2, test3).average() + " average test 2 and 3 (empty and not null/empty)");
		System.out.println(new Top(test3).max() + " max of test 3 (not null/empty)");
		System.out.println(new Lower(test2, test2).max() + " max of test 2 and test 2 (empty and empty)");
		System.out.println(new Lower(test2, test3).max() + " max of test 2 and test 3 (empty and not null/empty)"); //if only one array is null/empty then print max of other??
		
		
		
		
	}

}
