package taskforce;

import java.util.Random;

import Country.*;
import illegals.Immigrant;

public abstract class TaskForce {

	private String name;
	private Country country;
	private City city;
	protected Random rng = new Random();
	
	public TaskForce(String name){
		this.name = name;
	}
	
	public abstract boolean checkImmigrant(Immigrant e) throws NotMyJobException;
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public City getCity() {
		return city;
	}
}
