package diablo_skills;

public class HolySmiteSkill extends Skill {

	private static final int COST = 120;
	private static final int CD = 7;
	
	public HolySmiteSkill() {
		super("Holy Smite");
	}

	@Override
	public void cast(Attackable target) throws AbilityNotReadyException, NotEnouhgManaException {
		if(this.caster.getMana() < COST) throw new NotEnouhgManaException();
		if(this.cdRemaining > 0) throw new AbilityNotReadyException();
		this.caster.useMana(COST);
		double damage = caster.getStats().getStr()*0.25 + caster.getStats().getEnergy()*4 + caster.getDmg();
		target.pureHit(damage);
		this.cdRemaining = CD;
	}
	
	@Override
	public String toString() {
		String info = super.toString();
		info += "Infuse your sword with the holy light and smite your target, causing ";
		info +=caster.getStats().getStr()*0.25 + caster.getStats().getEnergy()*4 + caster.getDmg() + " pure damage." + "\n";
		info += "Cost: " + COST + " mana. Cooldown: " + CD;
		return info;
	}
	
	public int getCOST() {
		return COST;
	}
	
	

}
