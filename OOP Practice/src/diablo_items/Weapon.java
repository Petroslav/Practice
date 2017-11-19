package diablo_items;

import fake_diablo.Stats;

public class Weapon extends Item {
	
	private static final int MAX_STR = 120;
	private static final int MAX_DAMAGE = 116;
	private int dmg;
	
	public Weapon(String name) {
		super(name);
		this.dmg = r.nextInt(MAX_DAMAGE);
		this.dmg += 15;
		int str = r.nextInt(MAX_STR);
		str += 1;
		int stam = r.nextInt(MAX_STAM);
		stam += 1;
		this.stats = new Stats(0, stam, str, 0);
	}
	
	public int getDmg() {
		return dmg;
	}
	
	@Override
	public String toString() {
		String stats = this.getName() + "\n";
		stats += "Damage: " + this.getDmg() + "\n";
		stats += this.getStats().toString();
		return stats;
	}

	
}
