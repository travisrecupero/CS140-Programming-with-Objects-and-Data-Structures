package assignment02;

import java.util.Arrays;

public class BookTester {

	
	
	public static double avgPagesInLibrary(Book[] books) {
		double average = 0;
		double counter = 0;
		Book book;
		
		
		for(int i = 0; i < books.length; i++){
			book = books[i];
			average = average + book.getNumPages();
			counter++;
		}
		
		return average / counter;
	}
	
	
	
	
	public static void main(String[] args) {

		Book[] test1 = {
				new Book("Book A", 3), 
				new Book("Book B", 7),
				new Book("Book C", 9),
				new Book("Book D", 10),
				new Book("Book E", 2),
				new Book("Book F", 6),
				new Book("Book G", 3),
				new Book("Book H", 1)
			};
	
		Book[] test2 = {
				new Book("Book A", 100), 
				new Book("Book B", 176),
				new Book("Book C", 150),
				new Book("Book D", 209),
			};
		
		Book[] test3 = {
				new Book("Book A", 3), 
				new Book("Book B", 7),
				new Book("Book C", 9),
				new Book("Book D", 10),
				new Book("Book E", 2),
				new Book("Book F", 6),
				new Book("Book G", 3),
				new Book("Book H", 1)
			};
		double average = avgPagesInLibrary(test2);
		
		WeirdSorterBook ws2 = new WeirdSorterBook(test1);
		System.out.println("Weird Sorted Books: ");
		System.out.println(Arrays.toString(ws2.sorted()));
		System.out.println("\nAverage pages: " + average + "\n");
		
		
		
		
		System.out.println("One Change Books: ");
		OneChangeBook ocb = new OneChangeBook(test3);
		System.out.println(Arrays.toString(ocb.modify(4)));
		
		
		
	}

}
