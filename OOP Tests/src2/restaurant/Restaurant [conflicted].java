package restaurant;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import clients.*;
import menu.*;

public class Restaurant {

	private final String NAME;
	private final String address;
	private double capital;
	private ArrayList<IItem> menu;
	private ArrayList<Waiter> staff;
	private Random rng = new Random();
	
	public Restaurant(String name, String address, double capital) {
		NAME = name;
		this.address = address;
		this.capital = capital;
		this.staff = new ArrayList<Waiter>();
		this.menu = new ArrayList<IItem>();
		this.menu.add(new Salad());
		this.menu.add(new MainDish());
		this.menu.add(new Dessert());
		this.menu.add(new FizzyDrink());
		this.menu.add(new Alcohol());
	}
	
	public void hireWaiter(Waiter... w){
		for(Waiter s : w){
			this.staff.add(s);
			s.setWorkplace(this);
		}
	}
	
	public void getPaid(int amount){
		this.capital += amount;
	}
	
	public ArrayList<IItem> getMenu() {
		return menu;
	}
	
	public void seatClients(ArrayList<Client> clients){
		for(Client x : clients){
			x.setWaiter(staff.get(rng.nextInt(this.staff.size())));
		}
	}
	
	public ArrayList<Waiter> getStaff() {
		return staff;
	}
	
	public double getCapital() {
		return capital;
	}
	
	public Waiter mostTippedServer(){
		TreeSet<Waiter> tips = new TreeSet<Waiter>((o1, o2) -> (int) o1.getTips() - (int) o2.getTips());
		tips.addAll(this.staff);
//		Collections.sort(this.staff, new TipsComparator());
//		Collections.reverse(this.staff);
		return tips.last();
	}
	
	public void printInventory(){
		System.out.println("Food: ");
		for(IItem x : this.menu){
			if(x instanceof Food) System.out.println(x.toString());
		}
		System.out.println();
		System.out.println("Drinks: ");
		for(IItem x : this.menu){
			if(x instanceof Drink) System.out.println(x.toString());
		}
	}
}
