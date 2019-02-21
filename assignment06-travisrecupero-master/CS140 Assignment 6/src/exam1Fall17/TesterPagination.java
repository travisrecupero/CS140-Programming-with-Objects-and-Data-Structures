package exam1Fall17;

public class TesterPagination {

	public static void main(String[] args) {

		Pagination p = new Pagination(4, 158);
		p.setChapStartPage(1, 55);
		p.setChapStartPage(2, 88);
		p.setChapStartPage(3, 128);
		p.setChapStartPage(4, 158);
		p.assign(2);
		p.assign(4);
		
		System.out.println("Expected: 63 pages");
		System.out.println("Outcome: " + p.totalToRead() + " pages");
		
		
	}

}
