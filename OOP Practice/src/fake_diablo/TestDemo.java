package fake_diablo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import diablo_items.*;
import diablo_skills.*;

public class TestDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rng = new Random();
		Hero hero = new Hero("Pencho");
		ArrayList<Skill> skillPool = new ArrayList<Skill>();
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Enemy> enemyPool = new ArrayList<Enemy>();
		skillPool.add(new SwingSkill());
		skillPool.add(new BashSkill());
		skillPool.add(new HolySmiteSkill());
		skillPool.add(new PoisonSpitSkill());
		skillPool.add(new FireBreathSkill());
		skillPool.add(new CommandingShoutSkill());
		String[] names = {"Tal'Rasha", "The Immortal King", "Wolfman", "Violet Mage", "Thousand year Golem"};
		String[] names2 = {"'s Headpiece", "'s Chestguard", "'s Handwraps", "'s Treads", "'s Corpse Maker"};
		for (int i = 1; i < 31; i++) {
			items.add(new Head(names[rng.nextInt(5)] + names2[0]));
			items.add(new Torso(names[rng.nextInt(5)] + names2[1]));
			items.add(new Hands(names[rng.nextInt(5)] + names2[2]));
			items.add(new Feet(names[rng.nextInt(5)] + names2[3]));
			items.add(new Weapon(names[rng.nextInt(5)] + names2[4]));
			enemyPool.add(new TrivialEnemy("Unwanted Belcher"));
			if(i%3 == 0) enemyPool.add(new CommonEnemy("Dark Noob"));
			if(i%6 == 0) enemyPool.add(new EliteEnemy("Nerd Dragon"));
			if(i%15 == 0) enemyPool.add(new BossEnemy("Bossman", "Rising from the nether he's here to kill you."));
		}
		Enemy.setLoot(items);
		for(Skill x : skillPool){
			hero.learnSkill(x);
		}
		
		while(true){
			System.out.println("What would you like to do?");
			printMenu();
			int choice = sc.nextInt();
			switch(choice){
			case 1:
				int enemyIndex = rng.nextInt(enemyPool.size());
				hero.setTarget(enemyPool.get(enemyIndex));
				fight(hero);
				if(enemyPool.get(enemyIndex).isDead()) enemyPool.remove(enemyIndex);
				break;
			case 2:
				viewInventory(hero);
				break;
			case 3:
				System.out.println(hero.toString());
				break;
			case 4:
				hero.printSkills();
				break;
			default:
				break;
					
			}
			if(choice == 5) break;
		}
		
	}
	
	public static void fight(Hero hero) {
		Scanner sc = new Scanner(System.in);
		Enemy enemy = hero.getTarget();
		System.out.println("You are fighting : ");
		System.out.println(enemy.toString() + "\n");
		while(!hero.isDead() || !enemy.isDead()){
			System.out.println("Pick a skill to cast: ");
			hero.printSkillBar();
			System.out.println();
			int choice = sc.nextInt();
			hero.attack(choice);
			System.out.println("\n" + enemy.toString() + "\n");
			if(hero.getTarget().isDead()){
				System.out.println("You killed the enemy! Looting...");
				break;
			}
			enemy.attack();
			if(hero.isDead()) {
				System.out.println("You died");
				break;
			}
		}
		if(!hero.isDead()) hero.lootTarget();
		System.out.println("Freshening up...");
		hero.heroRefresh();
		
	}
	
	public static void viewInventory(Hero hero){
		Scanner sc = new Scanner(System.in);
		hero.inventoryToString();
		System.out.println("What would you like to do?");
		System.out.println("1. Equip an item?");
		System.out.println("2. Remove an item.");
		System.out.println("3. Destroy an item");
		System.out.println("4. Go back.");
		int choice = 0;
		int choice2 = -1;
		do{
			System.out.println("Your choice: ");
			choice = sc.nextInt();
		}while(choice < 1 && choice > 4);
		do{
			System.out.println("Input the number of the item you want ot use");
			choice2 = sc.nextInt();
		}while(choice < 0 && choice > hero.getInventory().size());
		
		switch(choice){
		case 1:
			hero.equipItem(hero.getInventory().get(choice2-1));
			break;
		case 2:
			hero.unequipItem(hero.getInventory().get(choice2-1));
			break;
		case 3:
			hero.destroyItem(choice2);
			break;
		case 4:
			break;
		}
	}

	public static void printMenu(){
		System.out.println("1. Fight a random enemy.");
		System.out.println("2. Check inventory");
		System.out.println("3. View stats");
		System.out.println("4. View skills");
		System.out.println("5. End game");
	}
}
