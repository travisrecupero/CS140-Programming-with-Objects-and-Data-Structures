package lab02;


public class Library{

public static int numPagesInLibrary(Book[] books){
	int sum = 0;
	for (Book b : books)
	{
	   sum = sum + b.getNumPages();
	}
	return sum;
}	

public static int mostPages(Book[] books){
	int max = 0;
	int temp = 0;
	
	for (int i = 0; i < books.length - 1; i++){
		if (max < books[i+1].getNumPages()){
			max = books[i+1].getNumPages();
		}
	}
	return max;
}					


public static void main(String[] args) {

	Book[] library = new Book[3];
	library[0] = new Book("Small Book", 50);
	library[1] = new Book("Medium Book", 100);
	library[2] = new Book("Big Book", 150);

	int max = 0;

	//regular for loop
	System.out.println("For loop: ");	
	for(int i = 0; i < library.length; i++)
	{
		System.out.println("Book Title: " + library[i].getTitle());
	}	

	//for-each loop
	System.out.println("\nEnhanced for loop:");
	for(Book b : library )
	{
		System.out.println("Book Pages: " + b.getNumPages());
	} 


	
	//expected total number of pages
	System.out.println("\nExpected number of total pages: 300");
	System.out.println("Method return number for total pages: "+  numPagesInLibrary(library));
	
	//expected book with most pages
	max = mostPages(library);
	System.out.println("\nExpected largest book number: 150");
	System.out.println("Method return number: "+  max);

}

}
