package fake_diablo;

public class TrivialEnemy extends Enemy {

	private static final int MIN_STR = 1;
	private static final int MIN_STAM = 5;
	private static final int MAX_STR = 24;
	private static final int MAX_STAM = 20;
			
	
	public TrivialEnemy(String name) {
		super(name);
		int stam = rng.nextInt(MAX_STAM);
		stam += MIN_STAM;
		int str = rng.nextInt(MAX_STR);
		str += MIN_STR;
		this.stats = new Stats(0, stam, str, 0);
		this.hp = stam*10;
		this.dmg = str*3;
	}

	@Override
	public void attack() {
		double damage = this.dmg;
		if(this.getStatus().isStun()){
			System.out.println(this.getName() + " is stunned and can't attack!");
			damage = 0;
		}
		this.getTarget().takeHit(damage);		
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
