package exam1Spring18;

import java.util.List;
import java.util.ArrayList;

public class Internet {
	private List<Website> sites;

	public Internet(List<Website> sites) {
		this.sites = sites;
	}

	public void addSites(Website website) {
		sites.add(website);
	}

	public List<Website> getSites() {
		return sites;
	}

	public boolean incPop(String urlstr, double fact) {
		for (Website site : sites) {
			if (site.getUrl().equals(urlstr)) {
				site.incPop(fact);
				return true;
			}
		}

		return false;
	}

	public int[] profile() {
		int[] pops = new int[11];
		int tempPop;

		for (int i = 0; i < sites.size(); i++) {
			tempPop = (int) sites.get(i).getPop();
			if (sites.get(i).getPop() == tempPop) {
				pops[tempPop - 1]++;
			}

		}

		return pops;
	}

	protected void remSite(Website w) {
		sites.remove(w);
	}
}