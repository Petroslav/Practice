package menu;

public class MainDish extends Food {

	public MainDish(){
		super("Main Dish");
		this.weight = rng.nextInt(401) + 400;
		this.price = 9;
	}
}
