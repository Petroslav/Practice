package menu;

public abstract class Drink implements IItem {

	protected int price;
	private int stock;
	private String name;
	
	public Drink(String name){
		this.name = name;
		this.stock = 20;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void sell() throws ItemUnavailableException {
		if(this.stock == 0) throw new ItemUnavailableException();
		this.stock--;
	}
	
	@Override
	public String toString() {
		return name + " - " + stock + " servings";
	}
}
