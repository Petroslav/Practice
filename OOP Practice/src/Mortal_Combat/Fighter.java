package Mortal_Combat;

import java.util.Random;

public class Fighter {

	private final double MAX_HP;
	private double hp;
	private double dmg;
	private double combo;
	private Fighter enemy;
	private String name;
	private Random r = new Random();
	
	public Fighter(double hp, double dmg, String name) {
		super();
		this.hp = hp;
		this.dmg = dmg;
		this.name = name;
		this.MAX_HP = hp;
	}



	public void setEnemy(Fighter enemy) {
		this.enemy = enemy;
	}
	
	public boolean isDead(){
		if( this.hp <= 0) {
			this.hp = MAX_HP;
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public void printStats(){
		System.out.println(this.name + "\n" + "HP: " + this.hp + "\n" + "DMG: " + this.dmg);
	}
	
	private boolean dodge(){
		if(r.nextInt(10) > 2) return false;
		return true;
	}
	
	private boolean block(){
		if(r.nextInt(10) > 4) return false;
		return true;
	}
	
	public void hit(){
		System.out.println();
		if(!this.enemy.dodge()){
			if(this.enemy.block()){
				System.out.println(this.enemy.name + " blocks the attack!");
				enemy.takeDamage(this.dmg*0.6);
				this.combo = 0;
			}
			else{
				enemy.takeDamage(this.dmg);
				this.combo++;
				if(combo == 5){
					System.out.println("COMBO!");
					System.out.println(this.name + " kicks " + this.enemy.name);
					combo = 0;
					enemy.takeDamage(this.dmg*1.5);
				}
			}
		}
		else System.out.println(this.enemy.name + " dodges the attack!");
	}

	private void takeDamage(double d) {
		d = Math.round(d);
		this.enemy.hp -= d;
		System.out.println(this.enemy.name + " takes " + d + " damage!");
		
	}
}
