package diablo_items;

import fake_diablo.Stats;

public abstract class Armor extends Item {
	
	private static final int MAX_STR = 75;
	private static final int MAX_ENERGY = 50;
	private static final int MAX_ARMOR = 550;
	
	public Armor(String name) {
		super(name);
		int str = r.nextInt(MAX_STR) + 1;
		int energy = r.nextInt(MAX_ENERGY) + 1;
		int armor = r.nextInt(MAX_ARMOR) + 1;
		int stam = r.nextInt(MAX_STAM) + 1;
		str++;
		stam++;
		energy++;
		armor++;
		this.stats = new Stats(armor, stam, str, energy);
	}
}
