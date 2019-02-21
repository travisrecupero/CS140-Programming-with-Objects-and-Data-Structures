package assignment02;

public class WeirdSorterBook {

	private Book[] bookArray;

	public WeirdSorterBook(Book[] b) {
		this.bookArray = b;
	}

	public Book[] sorted() {
		Book book;
		 for (int i = 0; i < bookArray.length - 1; i++) 
	        {
	            for (int j = i + 1; j < bookArray.length; j++) 
	            {
	                if (bookArray[i].getNumPages() > bookArray[j].getNumPages()) 
	                {
	                    book = bookArray[i];
	                    bookArray[i] = bookArray[j];
	                    bookArray[j] = book;
	                }
	            }
	        }
		return bookArray;
		
	}
	
	
}
