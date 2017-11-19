package america;

import java.util.ArrayList;
import java.util.Random;

import immigrants.*;
import law_enforcement.*;

public class City {

	private final String NAME;
	private ArrayList<LawEnforcer> lawEnforcement;
	private int citizens;
	private ArrayList<Immigrant> immigrants;
	private Random rng = new Random();
	
	public City(String nAME, int citizens) {
		super();
		NAME = nAME;
		this.citizens = citizens;
		this.lawEnforcement = new ArrayList<LawEnforcer>();
		this.immigrants = new ArrayList<Immigrant>();
	}
	
	public String getNAME() {
		return NAME;
	}
	
	public void killCitizens(int num){
		this.citizens -= num;
	}
	
	public void approveImmigrant(Immigrant juan){
		this.immigrants.add(juan);
		this.citizens++;
	}
	
	public LawEnforcer getEnforcer(){
		int randomGuy = rng.nextInt(this.lawEnforcement.size());
		return this.lawEnforcement.get(randomGuy);
	}
	
	public void hireLawEnforcer(LawEnforcer enforcer){
		this.lawEnforcement.add(enforcer);
		this.citizens++;
		enforcer.setCityOfResidence(this);
	}

	public ArrayList<Immigrant> getIllegals() {
		return this.immigrants;
	}
	
	public int getCitizens() {
		return citizens;
	}
	
	@Override
	public String toString() {
		return NAME + ", citizens: " + citizens;
	}
}
