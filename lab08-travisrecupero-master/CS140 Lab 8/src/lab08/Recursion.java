package lab08;

import java.util.List;

public class Recursion {

	public static final double DELTA = 1e-6;

	// n! = n(n-1)(n-2) ..... (3) (2) (1)
	//	0! = 1
	//	1! = 1
	//	2! = 2
	//	3! = 6
	//	4! = 24
	public static int factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}

	public static double squareRoot(double n) {
		return squareRootHelper(n, n - 1);
	}

	// helper
	private static double squareRootHelper(double n, double approx) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		if ((Math.abs(n - (approx * approx))) < DELTA) {
			return approx;
		} else {
			return squareRootHelper(n, (approx + n / approx) / 2);
		}

	}

	public static int sum(List<Integer> nums) {
		return sumHelper(nums, 0);
	}

	private static int sumHelper(List<Integer> nums, int index) {

		if (nums == null) {
			return 0;
		} else if (index == nums.size()) {
			return 0;
		} else {
			int temp = nums.get(index);
			return sumHelper(nums, index + 1) + temp;
		}

	}
	
	public static int sum(int[] nums) {
		return sumHelper(nums, 0);
	}
	
	private static int sumHelper(int[] nums, int index) {
		if (nums.length == 0) {
			return 0;
		} else if (index == nums.length) {
			return 0;
		} else {
			int temp = nums[index];
			return sumHelper(nums, index + 1) + temp;
		}

	}

	// n! / (k!(n-k)!)
	public static int binomialCoefficient(int n, int k) {
		if (k == 0) {
			return 1;
		} else if (k > (n / 2)) {
			return binomialCoefficient(n, n-k);
		} else {
			return binomialCoefficient(n-1, k) + binomialCoefficient(n-1, k-1);
		}
		
		
//		if (k > (n / 2)) {
//			int temp = n - k;
//			return factorial(n) / factorial(temp) * factorial(n - temp);
//		}
//
//		if (n > 1) {
//			return binomialCoefficient(n - 1, k) + binomialCoefficient(n - 1, k - 1);
////			int temp1 = factorial(n - 1) / factorial(k) * factorial((n-1) - k);
////			int temp2 = factorial(n - 1) / factorial(k-1) * factorial((n - 1) - (k-1));
////			return temp1 + temp2;
//		}
//		return 0;

	}

}
