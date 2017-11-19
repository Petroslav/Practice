package arms;

import java.util.Random;

public class Weapon {

	public enum Type {PISTOL, BOMB, GUN};
	
	private Type type;
	private int price;
	private Random rng = new Random();
	
	public Weapon(Type type, int price) {
		this.type = type;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Type getType() {
		return type;
	}
	
	public int shoot(){
		int shots = rng.nextInt(30) + 20;
		
		return shots;
	}
}
