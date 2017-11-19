package diablo_skills;

public class PoisonSpitSkill extends Skill {
	
	private static final int COST = 150;
	private static final int CD = 18;

	public PoisonSpitSkill() {
		super("Poison spit");
	}

	@Override
	public void cast(Attackable target) throws AbilityNotReadyException, NotEnouhgManaException {
		if(this.caster.getMana() < COST) throw new NotEnouhgManaException();
		if(this.cdRemaining > 0) throw new AbilityNotReadyException();
		this.caster.useMana(COST);
		target.getStatus().setBurn(true);
		target.getStatus().setBurnRemaining(10);
		target.getStatus().setBurnDmg(caster.getStats().getEnergy()*0.75 + caster.getStats().getStr()*0.25);
		double damage = caster.getStats().getStr()*2 + caster.getStats().getEnergy()*2;
		target.takeHit(damage);
		this.cdRemaining = CD;
	}

	@Override
	public String toString() {
		String info = super.toString();
		info += "You spit a toxin at the target. Causing " + caster.getStats().getStr()*1 + caster.getStats().getEnergy()*3;
		info += " damage and poisoning the target for " + (caster.getStats().getEnergy()*0.75 + caster.getStats().getStr()*0.25)*10;
		info += " damage over 10 turns" + "\n"; 
		info += "Cost: " + COST + " mana. Cooldown: " + CD;
		return info;
	}
	
	public int getCOST() {
		return COST;
	}
}
