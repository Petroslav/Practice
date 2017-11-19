package illegals;

import java.util.ArrayList;
import java.util.Random;

import Country.*;
import taskforce.Weapon;

public abstract class Immigrant {

	protected Passport passport;
	protected String name;
	protected double money;
	protected Country currentCountry;
	protected City currentCity;
	protected ArrayList<Immigrant> relatives;
	protected Random rng = new Random();
	public static int number = 1;
	
	public Immigrant(Country country) {
		this.relatives = new ArrayList<Immigrant>();
		this.currentCountry = country;
	}
	
	public abstract void buyWeapon(ArrayList<Weapon> market) throws NotEnoughMoneyForWeaponException;
	public abstract void goCrazy() throws NukeExplodedException;
	public abstract void addRelative(Immigrant e) throws FamilyFullException;
	
	public ArrayList<Immigrant> getRelatives() {
		return relatives;
	}
	
	public Passport getPassport() {
		return passport;
	}
	
	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}
	
	public boolean hasBomb(){
		return false;
	}
	
	public void printFamily(){
		System.out.println("==========");
		System.out.println(this.name + ", Currently in " + this.currentCity + ", " + this.currentCountry);
		System.out.println(this.passport == null ? "No passport" : "Has passport");
		System.out.println("Relatives: " + this.relatives.toString());
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
