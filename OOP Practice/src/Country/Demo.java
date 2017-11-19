package country;

import java.util.ArrayList;
import java.util.Random;

import taskforce.*;
import illegals.*;
import taskforce.Weapon.Type;

public class Demo {

	public static void main(String[] args) throws FamilyFullException {
		Random rng = new Random();
		//1.
		Country usa = new Country("United States of America");
		usa.addCity(new City("Chicago"));
		usa.addCity(new City("Los Angeles"));
		usa.addCity(new City("New York"));
		usa.addCity(new City("Washington"));
		usa.addCity(new City("Miami"));
		
		for (int i = 0; i < 500; i++) {
			if(rng.nextBoolean()){
				TaskForce guy = new SpecialOps("Pesho");
				guy.setCountry(usa);
				usa.getCity(rng.nextInt(5)).hireTaskForce(guy);
			}
			else{
				TaskForce guy = new Policeman("Gancho");
				guy.setCountry(usa);
				usa.getCity(rng.nextInt(5)).hireTaskForce(guy);
			}
		}
		
		//2.
		ArrayList<Immigrant> illegals = new ArrayList<Immigrant>();
		for (int i = 0; i < 100; i++) {
			int chance = rng.nextInt(100);
			if(chance < 40){
				illegals.add(new Normal(rng.nextInt(1500), usa));
				continue;
			}
			if(chance >= 40 && chance <= 75){
				boolean passport = false;
				if(rng.nextInt(35) < 35) passport = true;
				illegals.add(new Radical(passport, rng.nextInt(5000), usa));
				continue;
			}
			if(chance > 75) illegals.add(new Extremist(rng.nextInt(15000), usa));
		}
		
		for(Immigrant x : illegals){
			try{
				x.addRelative(illegals.get(rng.nextInt(illegals.size())));
				x.addRelative(illegals.get(rng.nextInt(illegals.size())));
			}
			catch(FamilyFullException e){
				System.out.println("Familia is full!");
			}
		}
		
		//3.
		ArrayList<Weapon> blackMarket = new ArrayList<Weapon>();
		for (int i = 0; i < 200; i++) {
			int type = rng.nextInt(3);
			switch(type){
			case 0:
				blackMarket.add(new Weapon(Type.GUN, rng.nextInt(1000)));
				break;
			case 1:
				blackMarket.add(new Weapon(Type.BOMB, rng.nextInt(1200)));
				break;
			case 2:
				blackMarket.add(new Weapon(Type.RIFLE, rng.nextInt(2500)));
				break;
			}
		}
		
		for(int i = 0; i < illegals.size(); i++){
			try{
				illegals.get(i).buyWeapon(blackMarket);
				illegals.get(i).buyWeapon(blackMarket);
				illegals.get(i).buyWeapon(blackMarket);
				illegals.get(i).buyWeapon(blackMarket);
				illegals.get(i).buyWeapon(blackMarket);
			}
			catch(NotEnoughMoneyForWeaponException e){
				System.out.println("ALLAH I'M COMINGGGGGG!!!");
				illegals.remove(i);
			}
		}
		
		//4.
		
		for (int i = 0; i < illegals.size(); i++) {
			if(usa.enterCountry(usa.getCity(rng.nextInt(5)), illegals.get(i))){
				// illegals.remove(i);
			}
		}
		
		//5
		
		for(Immigrant x : illegals){
			x.printFamily();
		}
		
		
	}
}
