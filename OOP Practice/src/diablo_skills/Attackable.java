package diablo_skills;

import fake_diablo.Stats;
import fake_diablo.Status;

public interface Attackable {

	public void takeHit(double dmg);
	public void pureHit(double dmg);
	public void setHp(double d);
	public void useMana(int mana);
	public Status getStatus();
	public Stats getStats();
	public int getMana();
	public int getDmg();
}
