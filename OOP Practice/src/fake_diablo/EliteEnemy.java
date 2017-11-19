package fake_diablo;

public class EliteEnemy extends Enemy {

	private static final int MIN_STR = 51;
	private static final int MIN_STAM = 61;
	private static final int MAX_STR = 120;
	private static final int MAX_STAM = 150;
	
	public EliteEnemy(String name) {
		super(name);
		int stam = rng.nextInt(MAX_STAM);
		stam += MIN_STAM;
		int str = rng.nextInt(MAX_STR);
		str += MIN_STR;
		this.stats = new Stats(0, stam, str, 0);
		this.hp = stam*20;
		this.dmg = str*3;
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
			System.out.println("Target bleeding for " + (damage*0.15)*3 + " over 3 turns!");
			this.getTarget().getStatus().setBurn(true);
			this.getTarget().getStatus().setBurnDmg(damage*0.15);
		}
		this.getTarget().takeHit(damage);
	}

	@Override
	public boolean isDead() {
		if(this.hp <= 0){
			if(rng.nextBoolean()) this.getBooty().add(Enemy.getLoot().get(rng.nextInt(Enemy.getLoot().size())));
			if(rng.nextBoolean()) this.getBooty().add(Enemy.getLoot().get(rng.nextInt(Enemy.getLoot().size())));
			return true;
		}
		return false;
	}


	
}
