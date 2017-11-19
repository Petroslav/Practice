package shop;

import people.IBuyer;
import products.*;

public class Demo {

	public static void main(String[] args) {
		
		//1.
		Shop shop = new Shop("Kaufland", "Sofia", 10000, 6);
		//2
		
		try {
			ProductByKg chedar = new Cheese("Chedar", 55.435, 88.65);
			ProductByKg svinsko = new Meat("Svinchuga", 7, 63.4);
			ProductByKg siomga = new Fish("Siomga", 20, 14);
			
			ProductByCount stolichno = new Beer("Stolichno", 2.2, 200);
			ProductByCount voinaIMir = new Book("Voina i mir", 35, 10);
			ProductByCount stol = new Chair("Klasik", 60, 50);

			//3
			shop.addProduct(chedar);
			shop.addProduct(svinsko);
			shop.addProduct(siomga);
			shop.addProduct(stolichno);
			shop.addProduct(voinaIMir);
			shop.addProduct(stol);
			
			//4

			IBuyer maria = IBuyer.createBuyer("Maria", shop, 3, 2000);
			IBuyer david = IBuyer.createBuyer("David", shop, 5, 20000);
			IBuyer tancho = IBuyer.createBuyer("Tancho", shop, 2, 300000);

			shop.showProducts();
			//5
			maria.addProductByKg(svinsko, 4);
			maria.addProductByKg(chedar, 6);
			tancho.addProductByCount(stolichno, 22);
			david.addProductByCount(stol, 11);
			//6
			david.removeProductByCount(stol, 2);
			maria.removeProductByKg(chedar, 2);
			//7
			maria.payProducts();
			tancho.payProducts();
			david.payProducts();
			//8
			shop.showProducts();
			
		} 
		catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		} catch (ShopFullException e) {
			System.out.println(e.getMessage());

		} catch (CloneNotSupportedException e) {
			System.out.println("ops, clone failed");
		}
	}
}
