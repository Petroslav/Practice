package diablo_skills;

public class SwingSkill extends Skill {

	public SwingSkill() {
		super("Swing");
	}

	@Override
	public void cast(Attackable target) {
		target.takeHit(caster.getDmg());
		
	}
	
	@Override
	public String toString() {
		String info = super.toString();
		info+= "You autoattack your target each turn." + "\n";
		info+= "No cost and no cooldown.";
		return info;
	}
	
	public int getCOST() {
		return 0;
	}
	@Override
	public int getCdRemaining() {
		return 0;
	}

}
