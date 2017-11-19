package menu;

public class Dessert extends Food {

	public Dessert(){
		super("Dessert");
		this.weight = rng.nextInt(101) + 200;
		this.price = 4;
	}
}
