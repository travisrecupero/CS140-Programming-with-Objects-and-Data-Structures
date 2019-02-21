package exam1Fall17;

import java.util.ArrayList;
import java.util.Arrays;

public class TesterExercise {

	public static void main(String[] args) {
		Exercise e = new Exercise(5, '+');
		
		ArrayList<Character> list = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
		System.out.print(list + " => ");
		e.modify(list);
		System.out.println(list);
		
		list = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
		System.out.print(list + " => ");
		e.modify(list);
		System.out.println(list);
		
		list = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
		System.out.print(list + " => ");
		e.modify(list);
		System.out.println(list);
		
		list = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
		System.out.print(list + " => ");
		e.modify(list);
		System.out.println(list);
		
		list = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
		System.out.print(list + " => ");
		e.modify(list);
		System.out.println(list);
		
		list = new ArrayList<>();
		System.out.print(list + " => ");
		e.modify(list);
		System.out.println(list);
		
		list = null;
		System.out.print(list + " => ");
		e.modify(list);
		System.out.println(list);

	}

}
