package exam1Spring18;

public class Website {

	private String url;
	private double pop;

	public Website(String url, double pop) {
		this.url = url;
		this.pop = pop;
	}

	public double getPop() {
		return pop;
	}

	public String getUrl() {
		return url;
	}

	public void incPop(double factor) {
		if (factor < 0) {
			throw new IllegalArgumentException("positive only");
		}
		pop *= factor;
		if (pop > 10) {
			pop = 10; //will make sure pop doesn't go over 10
		}
	}

	@Override
	public String toString() {
		return url + "(" + pop + ")";

	}
}