package lab08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tester {

	int factorialize;
	
	double square;
	double approx;
	
	List<Integer> list = new ArrayList<Integer>();
	
	int[] array = new int[3];
	
	int n, k;
	
	@BeforeEach
	public void init() {
		//factorial
		factorialize = 3;
		
		//square root
		square = 64;
		approx = 8;
		
		//list sum
		list.add(0, 10);
		list.add(1, 20);
		list.add(2, 30);
		
		//array
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		
		//binomial coefficient
		n = 4;
		k = 2;
	}
	
	@Test
	@DisplayName("Test for Factorial Base Case 1")
	public void test01() {
		assertEquals(1, Recursion.factorial(1));
	}
	
	@Test
	@DisplayName("Test for Factorial Base Case 2")
	public void test02() {
		assertEquals(1, Recursion.factorial(0));
	}
	
	@Test
	@DisplayName("Test for 3 Factorial")
	public void test03() {
		assertEquals(6, Recursion.factorial(factorialize));
	}
	
	@Test
	@DisplayName("Test for Squareroot Base Case")
	public void test04() {
		assertEquals(0, Recursion.squareRoot(0));
	}
	
	@Test
	@DisplayName("Test for Squareroot of 8")
	public void test05() {
		assertEquals(8, Recursion.squareRoot(square), 1e-6);
	}
	//8.000000000000103
	//need , 1e-6
	
	@Test
	@DisplayName("Test for List Sum")
	public void test06() {
		assertEquals(60, Recursion.sum(list));
	}
	
	@Test
	@DisplayName("Test for Array Sum")
	public void test07() {
		assertEquals(60, Recursion.sum(array));
	}
	
	//n = 4, k = 2
	@Test
	@DisplayName("Test for Binomial Coefficient")
	public void test08() {
		assertEquals(6, Recursion.binomialCoefficient(n, k));
	}
	
	//test k < n/2
	//k = 1
	@Test
	@DisplayName("Test for Binomial Coefficient Base Case")
	public void test09() {
		assertEquals(4, Recursion.binomialCoefficient(n, k-1));
	}
	
	
	
	
	
	
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	

}
