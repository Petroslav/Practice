package taskforce;

public class Weapon {

	public enum Type {GUN, BOMB, RIFLE};
	
	private Type type;
	private int price;
	
	public Weapon(Type type, int price) {
		this.type = type;
		this.price = price;
	}

	public double getCost() {
		return this.price;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type + ", cost: " + price;
	}
}
