package people;

import products.ProductByCount;
import products.ProductByKg;
import shop.Shop;

public interface IBuyer {

	public static IBuyer createBuyer(String name, Shop shop, int neededProducts, double money){
		return new Buyer(name, shop, neededProducts, money);
	}
	
	public void addProductByKg(ProductByKg product, double amount) throws CloneNotSupportedException;
	
	public void removeProductByKg(ProductByKg product, double amount);
	
	public void addProductByCount(ProductByCount product, int amount) throws CloneNotSupportedException;
	
	public void removeProductByCount(ProductByCount product, int amount);
	
	public void payProducts();
	
	
}
