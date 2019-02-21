package lab05;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Division{

	List<Double> list = new ArrayList<>();



	public Division(double[] array){
		if (array == null || array.length == 0){
			throw new IllegalArgumentException("need to enter an array with at least one double");
		} else {
			for (int i = 0; i < array.length; i++){
				list.add(array[i]);
			}
		}
	}

	public void removeZeroes(){
		Iterator<Double> iter = list.iterator();
		while(iter.hasNext()){
			double d = iter.next();
			if(d == 0){
				iter.remove();
			} 		
		}
	}

	public void divide(int divisor){
		double quotient;
		if(divisor == 0){
			throw new IllegalArgumentException("cannot divide by zero");		
		}
		for(int i = 0; i < list.size(); i++){
			quotient = list.get(i) / divisor;
			list.set(i, quotient);
		}
	}

	@Override
	public String toString(){
		return list.toString();
	}








}
