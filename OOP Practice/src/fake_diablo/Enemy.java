package fake_diablo;

import java.util.ArrayList;
import java.util.Random;

import diablo_items.*;
import diablo_skills.Attackable;

public abstract class Enemy implements Attackable{

	private String name;
	private String description;
	protected double hp;
	protected int mana;
	protected int dmg;
	private static final double BLOCK = 0.4;
	private Status status;
	protected Stats stats;
	private Hero target;
	private ArrayList<Item> booty;
	protected Random rng = new Random();
	private static ArrayList<Item> loot;
	
	public Enemy(String name){
		this.name = name;
		this.status = new Status();
		this.mana = 10000;
		Enemy.loot = new ArrayList<Item>();
		this.booty = new ArrayList<Item>();
		
	}
	
	public Enemy(String name, String description){
		this.name = name;
		this.description = description;
		this.status = new Status();
		this.stats = new Stats();
	}
	
	public ArrayList<Item> getBooty() {
		return booty;
	}
	
	public abstract boolean isDead();
	
	public abstract void attack();

	public static ArrayList<Item> getLoot() {
		return loot;
	}

	public static void setLoot(ArrayList<Item> loot) {
		Enemy.loot = loot;
	}
	
	private boolean block(){
		if(rng.nextInt(100) < 35) return true;
		return false;
	}
	private boolean dodge(){
		if(rng.nextInt(100) < 10) return true;
		return false;
	}
	
	@Override
	public void pureHit(double dmg){
		this.hp -= dmg;
	}
	
	@Override
	public void takeHit(double dmg) {
		if(this.status.isBurn()){
			this.hp -= this.status.getBurnDmg();
			System.out.println(this.name + " takes " + this.status.getBurnDmg() + " burn damage");
		}
		if(!this.status.isStun()){
			if(!this.dodge()){
				if(!this.block()){
					this.hp -= dmg;
					System.out.println(this.name + " was hit for " + dmg + " damage!");
				}
				else{
					System.out.println(this.name + " blocked!");
					System.out.println(this.name + " takes " + dmg*BLOCK + " damage");
				}
			}
			else System.out.println(this.name + " dodged");
		}
		else{
			this.hp -= dmg;
			System.out.println(this.name + " was hit for " + dmg + " damage!");
		}
		this.status.statusGCD();
		
	}
	
	@Override
	public String toString() {
		String stats = this.name + "\n";
		if(this.description != null) stats += this.description + "\n";
		stats += "HP: " + this.hp + "\n";
		stats += "DMG : " + this.dmg;
		stats += "\n" + this.stats.toString();
		return stats;
	}
	
	public Status getStatus() {
		return status;
	}
	public Stats getStats() {
		return stats;
	}
	
	public Hero getTarget() {
		return target;
	}
	public void setTarget(Hero target) {
		this.target = target;
	}

	@Override
	public void setHp(double d) {
		this.hp = this.hp*d;
	}

	@Override
	public void useMana(int mana) {
		return;		
	}
	
	@Override
	public int getMana() {
		return 0;
	}
	
	@Override
	public int getDmg() {
		return dmg;
	}
	
	public String targetToString(){
		return this.target.toString();
	}
	
	public String getName() {
		return name;
	}
	
}
