package fake_diablo;

import java.util.ArrayList;

import diablo_skills.Skill;

public class BossEnemy extends Enemy{

	private static final int MIN_STR = 121;
	private static final int MIN_STAM = 301;
	private static final int MAX_STR = 330;
	private static final int MAX_STAM = 500;
	private ArrayList<Skill> skills;
	
	public BossEnemy(String name, String descr) {
		super(name, descr);
		this.skills = new ArrayList<Skill>();
		int stam = rng.nextInt(MAX_STAM);
		stam += MIN_STAM;
		int str = rng.nextInt(MAX_STR);
		str += MIN_STR;
		this.stats = new Stats(0, stam, str, 0);
		this.hp = stam*13;
		this.dmg = str*2;
	}

	@Override
	public void attack() {
		double damage = this.dmg;
		if(this.getStatus().isStun()){
			System.out.println(this.getName() + " is stunned and can't attack!");
			damage = 0;
		}
		if(damage > 0 && rng.nextInt(100) < 15) {
			damage *= 1.5;
			System.out.println("Critical hit!");
			System.out.println("Target stunned for 1 turn");
			this.getTarget().getStatus().setStun(true);
			this.getTarget().getStatus().setStunRemaining(1);
			System.out.println("Target bleeding for " + (damage*0.15)*3 + " over 3 turns!");
			this.getTarget().getStatus().setBurn(true);
			this.getTarget().getStatus().setBurnRemaining(3);
			this.getTarget().getStatus().setBurnDmg(damage*0.15);
		}
		this.getTarget().takeHit(damage);
		
	}

	@Override
	public void setHp(double d) {
		this.hp *= d;
		
	}
	
	public void learnSkill(Skill skill){
		Skill newSkill = skill;
		newSkill.setCaster(this);
		this.skills.add(newSkill);
		
	}

	@Override
	public boolean isDead() {
		if(this.hp <= 0){
			if(rng.nextBoolean()) this.getBooty().add(Enemy.getLoot().get(rng.nextInt(Enemy.getLoot().size())));
			if(rng.nextBoolean()) this.getBooty().add(Enemy.getLoot().get(rng.nextInt(Enemy.getLoot().size())));
			if(rng.nextBoolean()) this.getBooty().add(Enemy.getLoot().get(rng.nextInt(Enemy.getLoot().size())));
			return true;
		}
		return false;
	}

}
