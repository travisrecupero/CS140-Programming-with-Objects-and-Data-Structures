package assignment10;
import java.util.Set;
import java.util.TreeSet;

public class NonRecursiveSubstrgGen {

	public static Set<String> strGen(String starter) {

		Set<String> retVal = new TreeSet<>();

		if (starter.length() == 1 || starter.length() == 0) {
			retVal.add(starter);
			retVal.add("");
			return retVal;
		} else {
			for (int i = 0; i < starter.length(); i++) {
				for (int j = i + 1; j <= starter.length(); j++) {
					retVal.add(starter.substring(i, j));
				}
			}
		}
		return retVal;
	}

}
