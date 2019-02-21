package exam1Spring18;

import java.util.*;

public class SnobbyInternet extends Internet {
	private double threshold;

	public SnobbyInternet(List<Website> website, double threshold) {
		super(website);
		this.threshold = threshold;
	}

	public void Trim() {
		List<Website> removeSites = new ArrayList<>();

		for (Website w : super.getSites()) {
			if (w.getPop() < threshold) {
				removeSites.add(w);
			}
		}

		for (Website w : removeSites) {
			super.remSite(w);
		}
	}


}
