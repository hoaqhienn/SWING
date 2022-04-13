package country_;

import java.io.Serializable;
import java.util.ArrayList;

public class CountryManager implements Serializable {
	private ArrayList<Country> loC;

	public CountryManager() {
		super();
		loC = new ArrayList<>();
	}
	public boolean themNV(Country c) {
		if (loC.contains(c))
			return false;
		loC.add(c);
		return true;
	}
	public boolean xoa(String x) {
		for (Country c : loC) {
			if (c.getCountry().equalsIgnoreCase(x)) {
				loC.remove(c);
				return true;
			}
		}
		return false;
	}
	public ArrayList<Country> getLoC() {
		return loC;
	}
	public void setLoC(ArrayList<Country> loC) {
		this.loC = loC;
	}
	
}
