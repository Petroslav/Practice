package law_enforcement;

import java.util.Random;

import america.*;
import immigrants.*;

public abstract class LawEnforcer {

	private String name;
	private City cityOfResidence;
	private Country countryOfResidence;
	protected Random rng = new Random();
	
	LawEnforcer(String name, Country country){
		this.name = name;
		this.countryOfResidence = country;
	}
	
	public abstract boolean checkImmigrant(Immigrant juan);

	public City getCityOfResidence() {
		return cityOfResidence;
	}

	public void setCityOfResidence(City cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

	public Country getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(Country countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	
	
	
}
