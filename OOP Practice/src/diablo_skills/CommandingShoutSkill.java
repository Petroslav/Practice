package diablo_skills;

public class CommandingShoutSkill extends Skill {

	private static final int COST = 20;
	private static final int CD = 5;
	
	public CommandingShoutSkill() {
		super("Commanding Shout");
	}

	@Override
	public void cast(Attackable target) throws AbilityNotReadyException, NotEnouhgManaException {
		if(this.caster.getMana() < COST) throw new NotEnouhgManaException();
		if(this.cdRemaining > 0) throw new AbilityNotReadyException();
		this.caster.useMana(COST);
		this.caster.getStatus().setBuffed(true);
		this.cdRemaining = CD;
		this.caster.setHp(1.2);
		this.cdRemaining = CD;
		
	}
	
	@Override
	public String toString() {
		String info = super.toString();
		info += "Increases the caster's current health by 20% for the duration of the fight." + "\n";
		info += "Cost: " + COST + " mana. Cooldown: " + CD;
		return info;
	}
	
	public int getCOST() {
		return COST;
	}
}
