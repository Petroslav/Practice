package diablo_skills;

public abstract class Skill {

	protected String name;
	protected int cdRemaining;
	protected Attackable caster;
	protected double damage;
	
	public Skill(String name) {
		this.name = name;
		this.cdRemaining = 0;
		this.caster = null;
	}
	
	public abstract void cast(Attackable target) throws AbilityNotReadyException, NotEnouhgManaException;
	
	public void gcd() {
		if(this.cdRemaining > 0) this.cdRemaining--;
	}
	public void refresh() {
		this.cdRemaining = 0;
	}	
	public void setCaster(Attackable caster) {
		this.caster = caster;
	}
	
	@Override
	public String toString() {
		return this.name + "\n";
	}
	
	public String getName() {
		return name;
	}
	
	public abstract int getCOST();
	
	public int getCdRemaining() {
		return cdRemaining;
	}

}
