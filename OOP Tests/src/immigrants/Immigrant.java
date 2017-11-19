package immigrants;

import java.util.ArrayList;
import java.util.Random;

import america.*;
import arms.Weapon;
import exceptions.BombExplosionException;
import exceptions.FamilyFullException;
import exceptions.NoMoneyException;

public abstract class Immigrant {

	private String name;
	protected Passport passport;
	private int cash;
	private City currentCity;
	protected Country currentCountry;
	protected ArrayList<Immigrant> relatives;
	protected ArrayList<Weapon> weapons;
	protected static int id = 1;
	private boolean hasBomb;
	private boolean immigrated;
	protected Random rng = new Random();
	
	public Immigrant(String name) {
		this.name = name;
		this.relatives = new ArrayList<Immigrant>();
		this.weapons = new ArrayList<Weapon>();
		this.immigrated = false;
	}
	

	public abstract void addToFamily(Immigrant juan) throws FamilyFullException;
	public abstract void goCrazy() throws BombExplosionException;
	public abstract void buyWeapon(ArrayList<Weapon> market) throws NoMoneyException;
	
	public void leaveFamily(){
		for(Immigrant x : this.relatives){
			for (int i = 0; i < x.relatives.size(); i++) {
				if(x.relatives.get(i).getName().equals(this.getName())){
					x.relatives.remove(i);
					break;
				}
			}
		}
	}
	
	public City getCity(){
		return this.currentCity;
	}
	
	public void immigrate(){
		if(this.immigrated) return;
		this.immigrated = true;
		City destination = this.currentCountry.getCities().get(rng.nextInt(5));
		if(destination.getEnforcer().checkImmigrant(this)){
			this.currentCity = destination;
			destination.approveImmigrant(this);
			this.currentCountry.addApprovedIllegal(this);
		}
		for (int i = 0; i < this.relatives.size(); i++) {
			this.relatives.get(i).immigrate();
		}
		if(!destination.getEnforcer().checkImmigrant(this)){
			System.out.println("GO BACK TO YOUR COUNTRY!!! RA-TA-TAT-AT-TA-TA-TATA!");
			this.leaveFamily();
			this.currentCountry.removeIllegal(this);
		}
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public int getCash() {
		return cash;
	}


	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	
	public boolean hasBomb() {
		return hasBomb;
	}


	public void setCurrentCountry(Country country) {
		this.currentCountry = country;
		
	}
	
	public void printInfo(){
		System.out.println("==============");
		System.out.println(this.name + (this.passport == null ? ", no passport " : ", has passport ") + "cash: " + this.cash );
		System.out.println("Current country : " + this.currentCountry.getNAME() + ", current city: " + this.currentCity.getNAME());
		System.out.println(this.relatives);
	}
	
	@Override
	public String toString() {
		return name + ", cash: " + this.cash;
	}
}
