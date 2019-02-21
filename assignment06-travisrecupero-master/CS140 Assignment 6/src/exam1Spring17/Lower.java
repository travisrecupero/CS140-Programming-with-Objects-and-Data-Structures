package exam1Spring17;

import java.util.Arrays;

public class Lower extends Top {

	private int[] arr1;

	public Lower(int[] arr, int[] arr1) {
		super(arr);
		this.arr1 = arr1;
	}

	@Override
	public double average() {
		if (arr1 == null || arr1.length == 0) {
			return 0.0;
		} else {
			return super.average();
		}
	}

	@Override
	public int max() {
		if ((arr1 == null || arr1.length == 0) && (super.getArr() == null || super.getArr().length == 0)) {
			return Integer.MIN_VALUE;
		}
// NOTE: I wasnt sure if you wanted it to be true for all null/empty or if only one of them were null/empty
//		if (arr1 == null || arr1.length == 0 ||super.getArr() == null || super.getArr().length == 0) {
//			return Integer.MIN_VALUE;
		int max = super.max();
		for (int i = 0; i < arr1.length; i++) {
			if (max < arr1[i]) {
				max = arr1[i];
			}
		}

		return max;
	}

	

	
	
	
}
