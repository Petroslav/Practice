package america;

import java.util.ArrayList;

import immigrants.*;

public class Country {

	private final String NAME;
	private ArrayList<City> cities;
	private ArrayList<Immigrant> illegals;
	private ArrayList<Immigrant> suicideBombers;
	private ArrayList<Immigrant> approvedIllegals;
	
	public Country(String name) {
		this.NAME = name;
		this.cities = new ArrayList<City>();
		this.illegals = new ArrayList<Immigrant>();
		this.suicideBombers = new ArrayList<Immigrant>();
		this.approvedIllegals = new ArrayList<Immigrant>();
	}
	
	public ArrayList<Immigrant> getSuicideBombers() {
		return suicideBombers;
	}
	
	public String getNAME() {
		return NAME;
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}
	
	public void removeCity(City city){
		for (int i = 0; i < this.cities.size(); i++) {
			if(this.cities.get(i).getNAME().equals(city.getNAME())){
				this.cities.remove(i);
				break;
			}
		}
	}
	
	public void addCity(City c){
		this.cities.add(c);
	}
	
	public void addImmigrant(Immigrant juan){
		this.illegals.add(juan);
		juan.setCurrentCountry(this);
	}

	public void removeIllegal(Immigrant juan) {
		for (int i = 0; i < this.illegals.size(); i++) {
			if(this.illegals.get(i).getName().equals(juan.getName())){
				this.illegals.remove(i);
				break;
			}
		}		
	}
	
	public void addApprovedIllegal(Immigrant juan){
		this.approvedIllegals.add(juan);
	}
	
	public void removeApprovedIllegal(Immigrant juan){
		this.approvedIllegals.remove(juan);
	}

	public ArrayList<Immigrant> getIllegals() {
		return this.illegals;
	}
	
	public ArrayList<Immigrant> getApprovedIllegals() {
		return approvedIllegals;
	}
}
