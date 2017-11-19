package menu;

public class Salad extends Food {
	
	public Salad(){
		super("Salad");
		this.weight = rng.nextInt(301) + 300;
		this.price = 5;
	}

}
