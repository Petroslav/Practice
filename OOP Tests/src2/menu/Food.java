package menu;

import java.util.Random;

public abstract class Food implements IItem {

	private String name;
	private int stock;	
	protected int weight;
	protected int price;
	protected Random rng = new Random();
	
	public Food(String name){
		this.stock = 10;
		this.name = name;
		
	}
	
	public int getPrice() {
		return price;
	}
	
	public void sell() throws ItemUnavailableException {
		if(this.stock == 0) throw new ItemUnavailableException();
		this.stock--;
	}
	
	@Override
	public String toString() {
		return name + " - " + stock + " portions";
	}
}
