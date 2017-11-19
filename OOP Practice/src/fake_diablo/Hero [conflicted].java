package fake_diablo;

import java.util.ArrayList;
import java.util.Random;

import diablo_items.*;
import diablo_skills.AbilityNotReadyException;
import diablo_skills.Attackable;
import diablo_skills.Skill;
import diablo_skills.NotEnouhgManaException;

public class Hero implements Attackable{

	private String name;
	private HeroStats stats;
	private Status status;;
	private double hp;
	private int mana; 
	private int dmg;
	private Enemy target;
	private Armor[] equipment = new Armor[4];
	private Weapon weapon;
	private ArrayList<Skill> skills;
	private ArrayList<Item> inventory;
	private int slots;
	private static final double BLOCK = 0.6;
	private Random rng = new Random();
	
	public Hero(String name) {
		super();
		this.status = new Status();
		this.stats = new HeroStats();
		this.name = name;
		this.inventory = new ArrayList<Item>();
		this.slots = 20;
		this.skills = new ArrayList<Skill>();
		this.hp = stats.getMaxHp();
		this.mana = stats.getMaxMana();
		this.weapon = null;
		this.dmg = this.stats.getStr()*3;
	}
	
	private boolean dodge(){
		if(rng.nextInt(101) > 85) return true;
		return false;
	}
	
	private boolean block(){
		if(rng.nextInt(101) > 75) return true;
		return false;
	}
	
	private int getSlot(Item item){
		if(item instanceof Head) return 0;
		if(item instanceof Torso) return 1;
		if(item instanceof Hands) return 2;
		if(item instanceof Feet) return 3;
		return 4;
	}
	
	private String slotToString(Item item){
		if(item instanceof Head) return "Head slot: ";
		if(item instanceof Torso) return "Torso slot: ";
		if(item instanceof Hands) return "Hands slot: ";
		if(item instanceof Feet) return "Feet slot: ";
		return "Weapon slot: ";		
	}
	
	private void updateDmg(){
		if(this.weapon == null) this.dmg = this.stats.getStr()*3;
		else this.dmg = this.stats.getStr()*3 + this.weapon.getDmg()*2;
	}
	
	public void equipItem(Item item){
		this.unequipItem(item);
		int slot = getSlot(item);
		if(slot == 4){
			Weapon wep = (Weapon)item;
			this.weapon = wep;
		}
		else{
			Armor armor = (Armor)item;
			this.equipment[slot] = armor;
		}
		this.stats.addStats(item.getStats());
		this.updateDmg();
		System.out.println(item.getName() + " has been equipped.");
	}
	
	public void unequipItem(Item item){
		int slot = getSlot(item);
		if(this.slots > 0) {
			this.inventory.add(item);
			this.slots--;
		}
		else{
			System.out.println("No free bag space!");
			return;
		}
		if((slot == 4 && this.weapon == null) || this.equipment[slot] == null) return;
		if(slot == 4) {
			this.weapon = null;
		}
		else this.equipment[slot] = null;
		this.stats.substractStats(item.getStats());
		this.updateDmg();
		System.out.println(item.getName() + " has been unequipped");
	}
	
	public void lootTarget(){
		ArrayList<Item> items = new ArrayList<Item>();
		items.addAll(this.target.getBooty());
		if(items.size() == 0){
			System.out.println("No loot.");
			return;
		}
		if(this.slots == 0){
			System.out.println("No room");
			return;
		}
		if(this.slots < items.size()){
			for(int i = 0; i < slots; i++){
				if(slots == 0) break;
				this.inventory.add(items.get(0));
				items.remove(0);
				this.slots--;
			}
		}
		else{
			this.inventory.addAll(items);
			this.slots -= items.size();
		}
		System.out.println("You looted " + items.size() + " items! They are: ");
		System.out.println(items);
		System.out.println();
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void destroyItem(int num){
		this.inventory.remove(--num);
		this.slots++;
	}
	
	public void pureHit(double dmg){
		this.hp -= dmg;
		System.out.println(this.name + " was hit for " + dmg + " damage!");
	}
	
	public void takeHit(double dmg){
		dmg *= this.stats.getDmgReduction();
		if(!this.status.isStun()&& dmg > 0){
			if(!this.dodge()){
				if(!this.block()){
					this.hp -= dmg;
					System.out.println(this.name + " was hit for " + dmg + " damage!");
				}
				else{
					System.out.println(this.name + " blocked!");
					System.out.println(this.name + " takes " + dmg*BLOCK + " damage");
					this.hp -= dmg*BLOCK;
				}
			}
			else System.out.println(this.name + " dodged");			
		}
		else{
			this.hp -= dmg;
			if(dmg > 0) System.out.println(this.name + " was hit for " + dmg + " damage.");
		}
		if(this.status.isBurn()){
			this.hp -= this.status.getBurnDmg();
			System.out.println(this.name + " takes " + this.status.getBurnDmg() + " burn damage.");
		}
		this.status.statusGCD();
		System.out.println("\n" + "HP: " + ((Math.round(this.hp) > 0)? Math.round(this.hp) : "0") + ", Mana: " + Math.round(this.mana) + " Damage: " + this.dmg + "\n");
	}
	
	public boolean isDead(){
		return this.hp <= 0;
	}
	
	public void useMana(int mana){
		this.mana -= mana;
	}
	
	public int getMana(){
		return this.mana;
	}
	
	public void setHp(double hp) {
		this.hp = this.hp*hp;
	}
	
	public void attack(int num){
		num--;
		if(this.status.isStun()){
			System.out.println("You are stunned. Cannot attack!");
		}
		else{
			try{
				Attackable tar = this.target;
				Skill attack = skills.get(num);
				System.out.println("Cast " + attack.getName() + "\n");
				attack.cast(tar);
			}
			catch(NotEnouhgManaException e){
				System.out.println(e.getMessage());
			}
			catch(AbilityNotReadyException e){
				System.out.println(e.getMessage());
			}			
		}
		for(Skill x : skills){
			x.gcd();
		}
	}
	
	public void heroRefresh(){
		this.hp = this.stats.getMaxHp();
		this.mana = this.stats.getMaxMana();
		this.status.setBuffed(false);
		this.status.setBurn(false);
		this.status.setStun(false);
	}
	
	public HeroStats getStats() {
		return stats;
	}
	
	public void setTarget(Enemy target) {
		this.target = target;
		target.setTarget(this);
	}
	
	public void learnSkill(Skill skill){
		Skill newSkill = skill;
		newSkill.setCaster(this);
		skills.add(newSkill);
	}
	
	public int getDmg() {
		return dmg;
	}
	
	public void inventoryToString(){
		System.out.println("Free slots in bag: " + this.slots);
		int cnt = 0;
		for(Item x : this.inventory){
			System.out.println("Bag slot " + cnt+1);
			System.out.println(x.toString());
			System.out.println();
			cnt++;
		}
	}
	
	public Status getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		String hero = this.name + "\n" + "\n" + "Equipment: " + "\n" + "\n";
		hero += "\n" + this.stats.toString();
		hero += "Damage: " + this.dmg + "\n" + "\n";
		for(Item x : this.equipment){
			if(x == null) continue;
			hero += slotToString(x) + "\n" + x.toString() + "\n";
		}
		if(this.weapon != null) hero += slotToString(this.weapon) + " " + this.weapon.toString() + "\n";
		return hero;
	}
	
	public int skillSet(){
		return this.skills.size();
	}
	
	public void printSkills(){
		int cnt = 1;
		for(Skill x : this.skills){
			System.out.println(cnt + " =====");
			System.out.println(x.toString());
			cnt++;
		}
		System.out.println();
	}
	
	public void printSkillBar(){
		int cnt = 1;
		for(Skill x : this.skills){
			if(x.getCOST() == 0) System.out.print(cnt + " " + x.getName() + " | ");
			if(x.getCOST() > 0 && x.getCdRemaining() == 0) System.out.print(cnt + " " + x.getName() + ", MP: " + x.getCOST() + " | ");
			if(x.getCdRemaining() > 0 && x.getCOST() > 0)  System.out.print(cnt + " " + x.getName() + ", MP: " + x.getCOST() + " CD: " + x.getCdRemaining() + " | ");
			cnt++;
		}
	}

	public Enemy getTarget() {
		return target;
	}
}
