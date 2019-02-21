package exam1Spring17;

import java.util.ArrayList;
import java.util.List;

public class Ques1 {

	private int n;
	
	public Ques1(int n1){
		if(n1 < 0) {
			this.n = -1 * n1;
		} else {
			n = n1;
		}
		
	}
	
	public int smallest() {
		if(n == 0 || n == 1) {
			return n;
		}
		
		for(int i = 2; i < n; i++) {
			if (n % i == 0) {
				return i;
			}
		}
		return n;
	}
	
	public ArrayList<Integer> factorize(){
		int temp = n;
		int x;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(n > 1) {
			x = smallest();
			list.add(x);
			n = n/x;
		}
		n = temp;
		
		return list;
	
	}
	
	
	
	
	
	@Override
	public String toString() {
		String str = n + " " +  "=" + factorize();
		str = str.replace(",", " x"); 
		str = str.replace("[", " ");
		str = str.replace("]", " ");
		return str;
	}
	
	
	
	
}
