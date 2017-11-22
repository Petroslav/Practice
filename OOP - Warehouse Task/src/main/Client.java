package main;

import java.util.ArrayList;
import java.util.Random;

import products.*;

public class Client extends Thread {

	private ArrayList<Product> cart;
	private Shop shop;
	private Random rng;
	
	public Client(Shop shop, String name){
		this.shop = shop;
		this.setName(name);
		this.cart = new ArrayList<>();
		this.rng = new Random();
	}
	
	@Override
	public void run() {
		while(true){
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int item = rng.nextInt(this.shop.getProducts());
			int amount = rng.nextInt(4) + 1;
			Product bought = this.shop.sellProduct(item, amount);
			System.out.println(currentThread().getName() + " bought " + bought.toString());
			if(cart.contains(bought)) {
				for(Product p : this.cart){
					if(p.getName() == bought.getName()) {
						p.supplyProduct(bought.getQuantity());
						break;
					}
				}
			}else this.cart.add(bought);
			System.out.println(this.toString());
		}
	}
	
	@Override
	public String toString() {
		return "I have in my cart: " + cart;
	}
}
