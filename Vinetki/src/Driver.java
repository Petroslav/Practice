import java.util.ArrayList;

import vehicles.Vehicle;
import vehicles.Vignette;

public class Driver {

	private final String name;
	private ArrayList<Vehicle> garage;
	private double budget;
	private GasStation shop;
	
	public Driver(String name, double budget) {
		super();
		this.name = name;
		this.budget = budget;
		this.garage = new ArrayList<Vehicle>();
	}
	
	public void buyVignetteForAllVehicles(){
		this.shop.sellManyVignette(this);
	}
	
	public void buyVignette(int num, int length){
		this.shop.sellVignette(this, num, length);
		
	}
	
	public ArrayList<Vehicle> getGarage() {
		return garage;
	}
	
	public void pay(Vignette v){
		if(v.getPrice() > this.budget){
			System.out.println("Not enough money");
			return;
		}else{
			this.budget -= v.getPrice();
		}
	}
	
	
}
