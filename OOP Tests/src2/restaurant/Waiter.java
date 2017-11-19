package restaurant;
import java.util.ArrayList;
import java.util.HashMap;

import clients.Client;
import menu.*;

public class Waiter {

	private final String NAME;
	private double tips;
	private HashMap<Client, ArrayList<IItem>> clients;
	private Restaurant workplace;
	
	public Waiter(String name){
		NAME = name;
		this.tips = 0;
		this.clients = new HashMap<Client, ArrayList<IItem>>();
	}
	
	public void takeOrder(Client c, ArrayList<IItem> order){
		this.clients.put(c, order);
	}
	
	public void tip(double tip){
		this.tips += tip;
	}
	
	public void getPaid(int amount){
		this.workplace.getPaid(amount);
	}
	
	public ArrayList<IItem> getMenu(){
		return this.workplace.getMenu();
	}
	public HashMap<Client, ArrayList<IItem>> getClients() {
		return clients;
	}
	
	@Override
	public String toString() {
		return NAME + ", tips: " + Math.round(tips);
	}

	public int bill(Client client) {
		int bill = 0;
		for(IItem x : clients.get(client)){
			bill += x.getPrice();
		}
		return bill;
	}

	public double getTips() {
		return Math.round(tips);
	}

	public void setWorkplace(Restaurant workplace) {
		this.workplace = workplace;
	}
}
