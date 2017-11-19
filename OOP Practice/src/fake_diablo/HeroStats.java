package fake_diablo;

public class HeroStats extends Stats {

	private double maxHp;
	private int maxMana;
	private double dmgReduction;
	
	public HeroStats() {
		this.stamina = 20;
		this.armor = 0;
		this.str = 15;
		this.energy = 10;
		this.maxHp = 230;
		this.maxMana = 200;
		this.dmgReduction = 1;
	}
	
	private void updateValues(){
		this.dmgReduction = 1 - (this.armor / 15000.0);
		this.maxHp = (this.str*2 + this.stamina*5);
		this.maxMana = 10 + this.energy*5;
	}
	
	@Override
	public void addStats(Stats s1) {
		super.addStats(s1);
		this.updateValues();
	}
	
	@Override
	public void substractStats(Stats s1) {
		super.substractStats(s1);
		this.updateValues();
	}
	
	public double getMaxHp() {
		return maxHp;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public double getDmgReduction() {
		return dmgReduction;
	}
	
	public int getStr(){
		return this.str;
	}
	
	@Override
	public String toString() {
		String stats = super.toString();
		stats += "Max HP: " + this.maxHp + "\n" + "Max MP: " + this.maxMana + "\n" + "Damage reductions: " + (100 - (Math.round((this.dmgReduction)*100))) + "%" + "\n";
		return stats;
	}
	
}
