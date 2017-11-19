package fake_diablo;

public class Stats {

	protected int armor;
	protected int stamina;
	protected int str;
	protected int energy;
	
	public Stats(){
		this.stamina = 1;
		this.armor = 0;
		this.str = 1;
		this.energy = 1;
	}
	
	public Stats(int armor, int stamina, int str, int energy) {
		this.armor = armor;
		this.stamina = stamina;
		this.str = str;
		this.energy = energy;
	}
	
	public void addStats(Stats s1){
		this.str += s1.str;
		this.stamina += s1.stamina;
		this.armor += s1.armor;
		this.energy += s1.energy;
	}
	
	public void substractStats(Stats s1){
		this.str -= s1.str;
		this.stamina -= s1.stamina;
		this.armor -= s1.armor;
		this.energy -= s1.energy;
	}
	
	@Override
	public String toString() {
		String stats = "Armor: " + this.armor + "\n";
		stats += "Stamina: " + this.stamina + "\n";
		stats += "Strength: " + this.str + "\n";
		stats += "Energy: " + this.energy + "\n";
		return stats;
	}
	
	public int getStr() {
		return str;
	}
	public int getEnergy() {
		return energy;
	}
	
}
