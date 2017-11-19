package Dealership;

public class Demo {

	public static void main(String[] args) {
		CarShop shop = new CarShop(20);
		Person qvor = new Person();
		qvor.name = "Qvor";
		Car lambo = new Car("Lamborghini", true);
		Car audi = new Car("Audi", false);
		Car mazda = new Car("Mazda 3", false);
		shop.addCar(lambo);
		shop.addCar(mazda);
		shop.addCar(audi);
		System.out.println(shop.getNextCar().model);
		shop.sellNextCar(qvor);
		System.out.println(lambo.owner.name);
		shop.showAllCarsInShop();
		
	}
}
