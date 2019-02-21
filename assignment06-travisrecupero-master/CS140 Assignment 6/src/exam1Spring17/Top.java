package exam1Spring17;

import java.util.Arrays;

public class Top {

	private int[] arr;

	public Top(int[] arr) {
		this.arr = arr;
	}

	public double average() {
		if (arr == null || arr.length == 0) {
			return 0.0;
		} else {
			double sum = 0;
			double average = 0;

			for (int i = 0; i < arr.length; i++) {
				sum = sum + arr[i];
			}

			average = sum / arr.length;
			return average;
		}
	}

	public int max() {
		if (arr.length == 0 || arr == null) {
			return Integer.MIN_VALUE;
		} else {
			int max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			return max;

		}
	}

	public int[] getArr() {
		return arr;
	}
	
	
	

}
