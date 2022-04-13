package country_;
import java.io.Serializable;

public class Country implements Serializable {
	private String country, capital;
	private long population;
	private boolean democracy;
	public Country() {
		super();
	}
	public Country(String country, String capital, long population, boolean democracy) {
		super();
		this.country = country;
		this.capital = capital;
		this.population = population;
		this.democracy = democracy;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public boolean isDemocracy() {
		return democracy;
	}
	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}
	
	
}
