package diablo_skills;

public class FireBreathSkill extends Skill {
	
	private static final int COST = 100;
	private static final int CD = 12;
	
	public FireBreathSkill() {
		super("Fire Breath");
	}

	@Override
	public void cast(Attackable target) throws AbilityNotReadyException, NotEnouhgManaException {
		if(this.caster.getMana() < this.COST) throw new NotEnouhgManaException();
		if(this.cdRemaining > 0) throw new AbilityNotReadyException();
		this.caster.useMana(this.COST);
		target.getStatus().setBurn(true);
		target.getStatus().setBurnRemaining(5);
		target.getStatus().setBurnDmg(caster.getStats().getEnergy()*0.5);
		double damage = caster.getStats().getStr()*1 + caster.getStats().getEnergy()*3;
		target.takeHit(damage);
		
	}
	
	@Override
	public String toString() {
		String info = super.toString();
		info += "You exhale all the air in your lungs and ignite it. Causing " + caster.getStats().getStr()*1 + caster.getStats().getEnergy()*3;
		info += " damage and burning the target for " + (caster.getStats().getEnergy()*0.5)*5 + " damage over 5 turns" + "\n"; 
		info += "Cost: " + COST + " mana. Cooldown: " + CD;
		return info;
	}
	
	public int getCOST() {
		return COST;
	}

}
