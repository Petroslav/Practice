package main;

public class TestRun {

	public static void main(String[] args) {
		Warehouse sklad = new Warehouse();
		Shop shopche = new Shop(sklad);
		Client c1 = new Client(shopche, "Grisho");
		Client c2 = new Client(shopche, "Pisho");
		Client c3 = new Client(shopche, "Swegro");
		Supplier sup = new Supplier(sklad);
		shopche.start();
		sup.start();
		c1.start();
		c2.start();
		c3.start();
		
	}
}
