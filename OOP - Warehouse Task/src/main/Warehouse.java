package main;

import java.util.concurrent.ConcurrentHashMap;

import products.*;

public class Warehouse {
	private static final int MIN_STOCK = 10;

	private ConcurrentHashMap<String, Product> inventory;
	
	public Warehouse(){
		this.inventory = new ConcurrentHashMap<>();
		this.inventory.put("Banana", new Product("Banana", ProductType.FRUIT));
		this.inventory.put("Orange", new Product("Orange", ProductType.FRUIT));
		this.inventory.put("Apple", new Product("Apple", ProductType.FRUIT));
		this.inventory.put("Potato", new Product("Potato", ProductType.VEGETABLE));
		this.inventory.put("Eggplant", new Product("Eggplant", ProductType.VEGETABLE));
		this.inventory.put("Cucumber", new Product("Cucumber", ProductType.VEGETABLE));
		this.inventory.put("Pork", new Product("Pork", ProductType.MEAT));
		this.inventory.put("Beef", new Product("Beef", ProductType.MEAT));
		this.inventory.put("Chicken", new Product("Chicken", ProductType.MEAT));
	}
	
	//Methods:
	
	public synchronized void stockInventory(int amount){
		if(!checkForResupply()){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(Product x : this.inventory.values()){
			if(x.getQuantity() >= MIN_STOCK) continue;
			if(x.getQuantity() <= MIN_STOCK){
				x.supplyProduct(amount);
				notifyAll();
				System.out.println("Supplied 25 of " + x.getName() + " in stock: " + x.getQuantity());
			}
		}
		notifyAll();
	}
	
	public synchronized Product sellProduct(String name){
		if(this.inventory.get(name).getQuantity() < 5){
			try {
				wait();
			} catch (InterruptedException e ) {
				e.printStackTrace();
			}
		}
		inventory.get(name).sellProduct(5);
		Product product = null;
		try {
			product = inventory.get(name).clone();
			product.setQuantity(5);
		} catch (CloneNotSupportedException e3) {
			
		}
		System.out.println("Sold " + product.getName() + " - " + product.getQuantity() + ", left in stock: " + inventory.get(name).getQuantity());
		notifyAll();
		return product;
	}
	
	public boolean checkForResupply(){ // returns false if there are no items at or under the minimum threshold, true if there are
		for(Product x : this.inventory.values()){
			if(x.getQuantity() >= MIN_STOCK) return true;
		}
		return false;
	}
}
