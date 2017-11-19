package diablo_skills;

public class BashSkill extends Skill {

	private static final int COST = 50;
	private static final int CD = 15;
	
	public BashSkill() {
		super("Bash!");
	}

	public void cast(Attackable target) throws AbilityNotReadyException, NotEnouhgManaException {
		if(this.caster.getMana() < COST) throw new NotEnouhgManaException();
		if(this.cdRemaining > 0) throw new AbilityNotReadyException();
		this.caster.useMana(COST);
		target.getStatus().setStun(true);
		target.getStatus().setStunRemaining(3);
		double damage = caster.getStats().getStr()*0.25 + caster.getDmg();
		target.takeHit(damage);
		this.cdRemaining = CD;
		
	}
	
	@Override
	public String toString() {
		String info = super.toString();
		info += "Bash the target, stunning them for 3 turns. Deals " + caster.getStats().getStr()*0.25 + caster.getDmg() + " damage." + "\n";
		info += "Cost: " + COST + " mana. Cooldown: " + CD;
		return info;
	}
	
	public int getCOST() {
		return COST;
	}
}
