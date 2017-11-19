package Dealership;

public class CarShop {

	Car[] inventory;
	
	CarShop(int capacity){
		this.inventory = new Car[capacity];
	}
	
	boolean addCar(Car car){
		boolean addedCar = false;
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null){
				inventory[i] = car;
				addedCar = true;
				break;
			}else{
			}
		}

		return addedCar;
	}
	
	Car getNextCar(){
		Car nextCar = null;
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null){
				nextCar = inventory[i];
				break;
			}
		}
		return nextCar;
	}
	
	void sellNextCar(Person buyer){
		getNextCar().owner = buyer;
		removeCar(getNextCar());
	}
	
	boolean removeCar(Car car){
		boolean carGone = false;
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null){
				inventory[i] = null;
				carGone = true;
				break;
			}
		}
		return carGone;
		
	}
	
	void showAllCarsInShop(){
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null){
				continue;
			}
			System.out.println("====================");
			System.out.println("Brand: "+inventory[i].brand);
			System.out.println("Model: "+inventory[i].model);
			System.out.println("Color: "+inventory[i].color);
			System.out.println("====================");
		}
	}
}
