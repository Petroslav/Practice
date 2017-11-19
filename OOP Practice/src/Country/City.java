package country;

import java.util.ArrayList;
import java.util.Random;

import illegals.Immigrant;
import taskforce.NotMyJobException;
import taskforce.TaskForce;

public class City {

	private String name;
	private ArrayList<TaskForce> policeForce;
	private int citizens;
	private ArrayList<Immigrant> illegals;
	private Country country;
	private ArrayList<Immigrant> blownUp;
	private Random rng;
	
	public City(String name) {
		this.name = name;
		this.policeForce = new ArrayList<TaskForce>();
		this.rng = new Random();
		this.citizens = rng.nextInt(10000) + 2000;
		this.illegals = new ArrayList<Immigrant>();
		
	}
	
	public void hireTaskForce(TaskForce e) {
		this.policeForce.add(e);
		e.setCity(this);
	}
	
	public void approveImmigrant(Immigrant e){
		this.illegals.add(e);
		this.citizens++;
		e.setCurrentCity(this);
	}
	
	public void dispatchImmigrant(Immigrant e){
		this.illegals.add(e);
		this.citizens++;
		e.setCurrentCity(this);
	}
	
	protected void setCountry(Country country) {
		this.country = country;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public int getCitizens() {
		return citizens;
	}
	
	public boolean checkImmigrant(Immigrant es){
		TaskForce cop = policeForce.get(rng.nextInt(policeForce.size()));
		try{
			if(cop.checkImmigrant(es)){
				this.approveImmigrant(es);
				return true;
			}
			else{
				System.out.println("Not on my watch! Go back to your country! RA-TA-TA-TA-TA-TA!!!");
				return false;
			}
		}catch(NotMyJobException e){
			System.out.println("Carry on.");
			this.approveImmigrant(es);
			return true;
		}
	}
	
	public void addAllahAckbar(Immigrant e){
		this.blownUp.add(e);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
