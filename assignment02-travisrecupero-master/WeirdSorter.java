package assignment02;

public class WeirdSorter {

	private int[] array;

	public WeirdSorter(int[] array) {
		this.array = array;
	}

	public int[] sorted() {
		int temp;
		 for (int i = 0; i < array.length - 1; i++) 
	        {
	            for (int j = i + 1; j < array.length; j++) 
	            {
	                if (array[i] > array[j]) 
	                {
	                    temp = array[i];
	                    array[i] = array[j];
	                    array[j] = temp;
	                }
	            }
	        }
		return array;
		
	}

}
