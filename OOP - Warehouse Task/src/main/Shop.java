package main;

import java.util.ArrayList;

import products.*;

public class Shop extends Thread{
	private static final int MIN_STOCK = 5;

	private Warehouse warehouse;
	private String[] names = { "Banana", "Orange,", "Apple", "Potato", "Eggplant", "Cucumber", "Pork", "Beef", "Chicken" };
	private ArrayList<Product> inventory;
	

	public Shop(Warehouse warehouse){
		this.warehouse = warehouse;
		this.inventory = new ArrayList<Product>();
		this.inventory.add(new Product("Banana", ProductType.FRUIT));
		this.inventory.add(new Product("Orange", ProductType.FRUIT));
		this.inventory.add(new Product("Apple", ProductType.FRUIT));
		this.inventory.add(new Product("Potato", ProductType.VEGETABLE));
		this.inventory.add(new Product("Eggplant", ProductType.VEGETABLE));
		this.inventory.add(new Product("Cucumber", ProductType.VEGETABLE));
		this.inventory.add(new Product("Pork", ProductType.MEAT));
		this.inventory.add(new Product("Beef", ProductType.MEAT));
		this.inventory.add(new Product("Chicken", ProductType.MEAT));
	}
	
	public synchronized Product sellProduct(int itemNum, int amount){ //can be tweaked
		if(this.inventory.get(itemNum).getQuantity() < amount){
			try {
				wait();
			} catch (InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.inventory.get(itemNum).sellProduct(amount);
		Product item = this.inventory.get(itemNum);
		try {
			item = this.inventory.get(itemNum).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		item.setQuantity(amount);
		System.out.println(this.inventory);
		notifyAll();
		return item;
	}

	@Override
	public void run() {
		while(true){
			if(checkForResupply()){
				for(Product x : this.inventory){
					if(x.getQuantity() >= MIN_STOCK) continue;
					if(x.getQuantity() <= MIN_STOCK){
						Product p = this.warehouse.sellProduct(x.getName());
						x.supplyProduct(p.getQuantity());
						System.out.println("Supplied 5 of " + x.getName());
					}
				}
			}
			
		}
	}
	
	
//	public synchronized void restock(){
//		if(!checkForResupply()){
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for(Product x : this.inventory){
//			if(x.getQuantity() >= MIN_STOCK) continue;
//			if(x.getQuantity() <= MIN_STOCK){
//				Product p = this.warehouse.sellProduct(x.getName());
//				x.supplyProduct(p.getQuantity());
//				notifyAll();
//				System.out.println("Supplied 5 of " + x.getName());
//			}
//		}
//		notifyAll();
//	}

	public boolean checkForResupply(){ // returns false if there are no items at or under the minimum threshold, true if there are any.
		for(Product x : this.inventory){
			if(x.getQuantity() >= MIN_STOCK) return true;
		}
		return false;
	}
	
	public int getProducts(){
		return inventory.size();
	}
}
