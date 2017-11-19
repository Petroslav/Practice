package fake_diablo;

public class CommonEnemy extends Enemy {

	private static final int MIN_STR = 11;
	private static final int MIN_STAM = 16;
	private static final int MAX_STR = 50;
	private static final int MAX_STAM = 60;
			
	
	public CommonEnemy(String name) {
		super(name);
		int stam = rng.nextInt(MAX_STAM);
		stam += MIN_STAM;
		int str = rng.nextInt(MAX_STR);
		str += MIN_STR;
		this.stats = new Stats(0, stam, str, 0);
		this.hp = stam*15;
		this.dmg = str*2;
	}

	@Override
	public void attack() {
		double damage = this.dmg;
		if(this.getStatus().isStun()){
			System.out.println(this.getName() + " is stunned and can't attack!");
			damage = 0;
		}
		if(rng.nextInt(100) < 15) {
			damage *= 1.5;
			if(damage > 0) System.out.println("Critical hit!");
			this.getTarget().takeHit(damage);
		}
		else this.getTarget().takeHit(damage);		
	}

	@Override
	public boolean isDead() {
		if(this.hp <= 0){
			if(rng.nextBoolean()) this.getBooty().add(Enemy.getLoot().get(rng.nextInt(Enemy.getLoot().size())));
			return true;
		}
		return false;
	}
}
