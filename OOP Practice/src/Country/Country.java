package country;

import java.util.ArrayList;
import java.util.Collections;

import illegals.*;

public class Country {

	private final String NAME;
	private ArrayList<City> cities = new ArrayList<City>();;
	
	public Country(String name) {
		this.NAME = name;
	}
	
	public void addCity(City city) {
		this.cities.add(city);
		city.setCountry(this);
	}
	
	public City getCity(int index) {
		return this.cities.get(index);
	}
	
	public boolean enterCountry(City city, Immigrant es){
		return city.checkImmigrant(es);
	}
	
	public ArrayList<City> getCities(){
		Collections.sort(cities, new InhabitantsComparator());
		return cities;
	}
	
	@Override
	public String toString() {
		return NAME;
	}
}
