package diablo_items;

import java.util.Random;

import fake_diablo.Stats;

public abstract class Item {
	
	private String name;
	protected Stats stats;
	protected static final int MAX_STAM = 120;
	protected Random r = new Random();
	
	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Stats getStats() {
		return stats;
	}
	
	@Override
	public String toString() {
		String stats = this.getName() + "\n";
		stats += this.getStats().toString();
		return stats;
	}
	
	

}
