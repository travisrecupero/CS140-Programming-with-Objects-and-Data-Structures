package exam1Fall17;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise {
	private int pos;
	private char ch;

	public Exercise(int pos, char ch) {
		if (pos < 0)
			throw new IllegalArgumentException("the int cannot be negative");
		this.pos = pos;
		this.ch = ch;
	}

	/**
	 * Does nothing if list is null. The int pos and the char ch are the fields
	 * above. If list.size() is less than or equal to pos, then it adds the char ch
	 * to list until list.size() equals pos + 1. Otherwise, if list.size() is
	 * greater than pos, it changes the char at index pos and ALL following char in
	 * list to the char ch.
	 * 
	 * @param list the ArrayList<Character> to be modified to have the char ch from
	 *             index pos onwards
	 */

	public void modify(ArrayList<Character> list) {
		int counter = pos;
		if (list == null) {
			return;
		}
		if (list.size() <= pos) {
			do {
				list.add(ch);
			} while (list.size() != pos + 1);

		} else if (list.size() > pos) {
			for (int i = pos; i < list.size(); i++) {
				list.set(i, ch);
			}

		}

	}

}