package exam1Spring18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		Website website = new Website("google.com", 4);
		website.incPop(2.0);

		System.out.println("Expecting 8.0");
		System.out.println("Answer: " + website.getPop() + "\n");

		System.out.println("Testing toSting(): ");
		System.out.println(website + "\n");
		
		
		
		List<Website> websites = new ArrayList<>();
		websites.add(new Website("google.com", 2));
		websites.add(new Website("binghamton.edu", 1));
		websites.add(new Website("news.com", 3));
		websites.add(new Website("test.com", 7));
		websites.add(new Website("best.com", 4));
		websites.add(new Website("rest.com", 8));
		websites.add(new Website("jim.com", 6));
		websites.add(new Website("bob.com", 6));
		websites.add(new Website("anothertest.com", 1));
		Internet internet = new Internet(websites);
		System.out.println("Every index in array corresponds with webites having i population: ");
		System.out.println("Expected: [2, 1, 1, 1, 0, 2, 1, 1, 0, 0, 0]");
		System.out.println("Array:    " + Arrays.toString(internet.profile()));
		
		
	}

}
