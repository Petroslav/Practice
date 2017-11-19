package immigrants;

import java.util.Random;

import america.*;

public class Passport {

	private String name;
	private int age;
	private static Country countryOfBirth = new Country("Mexico");
	private static City cityOfBirh = new City("Mexico City", 12000);
	
	public Passport(String name) {
		Random rngAge = new Random();
		this.name = name;
		this.age = rngAge.nextInt(40) + 11;
	}
	
	public String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
}
