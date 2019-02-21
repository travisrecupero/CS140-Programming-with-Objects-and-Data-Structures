package exam1Fall17;

public class Pagination {

	private int numPages; // number of pages in book
	private int numChapters; // number of chapters in book
	private int[] chapStarts; // chapStarts[n] is page number where chapter n starts
	private int[] chapAssigned; // if chapAssigned = 1 then chapter has been assigned

	public Pagination(int numPages, int numChapters) {
		this.numPages = numPages;
		this.numChapters = numChapters;
		chapStarts = new int[numChapters + 1];
		chapStarts[0] = 0;
		chapAssigned = new int[numChapters + 1];
		chapAssigned[0] = 0;
	}

	public void setChapStartPage(int n, int p) {
		chapStarts[n] = p;
	}

	public void assign(int n) { // n is the chapter assigned
		chapAssigned[n] = 1;
	}

	// returns total pages to read
	public int totalToRead() {
		int total = 0;
		for (int i = 0; i < chapAssigned.length; i++) {
			if (chapAssigned[i] == 1) {
				total = total + (chapStarts[i] - chapStarts[i - 1]);
			}
		}
		return total;

	}

}
