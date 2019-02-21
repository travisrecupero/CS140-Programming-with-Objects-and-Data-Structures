package lab08;

public class Bonus {

	public static void main(String[] args) {
		printPascalsTriangle(5);
	}
	
	public static int binomialCo(int n, int k) {
		if (k == 0) {
			return 1;
		} else if (k == n) {
			return binomialCo(n, n-k);
		} else {
			return binomialCo(n-1, k) + binomialCo(n-1, k-1);
		}
		

	}

	public static void printPascalsTriangle(int limit) {
		printPascalsHelper(limit, 0, 0);
	}
	
	
	private static void printPascalsHelper(int limit, int n, int k) {
		//check
		if(n >= limit + 1) {
			return; //finish recursing
		}
		
		
		if(n > k) { //keep printing until n IS equal to k
			System.out.print(binomialCo(n, k) + " ");
			printPascalsHelper(limit, n, k + 1);
		} else if (n == k) {  //end of n
			System.out.println(binomialCo(n, k));
			printPascalsHelper(limit, n + 1, 0);
		}

		
	}
//	int i = 1;
//	int printCounter = 2;
//	
//	while(i <= limit) {
//		System.out.println(binomialCo(n, k));
//		i++;
//		
//		while(i <= printCounter) {
//			System.out.print(binomialCo(n, k) + " ");
//			k++;
//			i++;
//		}
//		printCounter++;
//		n++;
//	}
//	do {
//		System.out.println(binomialCo(n, k));
//		printCounter++;
//		n++;
//		i++;
//		
//		if(printCounter < i && printCounter < limit) {
//			System.out.println(binomialCo(n, k));
//		}
//	} while (i <= limit);

	//print 0 0
	//next line 
	
	//print 1 0
	//print 1 1
	//next line 
	
	//next line 
	//print 2 0
	//print 2 1
	//print 2 2
}
