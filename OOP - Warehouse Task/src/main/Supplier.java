package main;

public class Supplier extends Thread {
	
	private Warehouse storage;
	
	public Supplier(Warehouse sklad){
		this.storage = sklad;
	}
	
	@Override
	public void run() {
		while(true){
			storage.stockInventory(25);
		}
	}
}
