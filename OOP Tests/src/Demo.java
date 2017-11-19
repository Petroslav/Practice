import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import america.*;
import arms.*;
import exceptions.*;
import immigrants.*;
import law_enforcement.*;

public class Demo {

	public static void main(String[] args) {
		Random rng = new Random();
		//1.
		Country usa = new Country("United States of America");
		usa.addCity(new City("Chicago", rng.nextInt(15000) + 2000));
		usa.addCity(new City("Los Angeles", rng.nextInt(15000) + 2000));
		usa.addCity(new City("New York", rng.nextInt(15000) + 2000));
		usa.addCity(new City("Washington", rng.nextInt(15000) + 2000));
		usa.addCity(new City("Miami", rng.nextInt(15000) + 2000));
		
		for (int i = 0; i < 500; i++) {
			if(rng.nextBoolean()){
				LawEnforcer guy = new SpecialOps("Pesho", usa);
				usa.getCities().get(rng.nextInt(usa.getCities().size())).hireLawEnforcer(guy);
			}
			else{
				LawEnforcer guy = new Policeman("Gancho", usa);
				usa.getCities().get(rng.nextInt(usa.getCities().size())).hireLawEnforcer(guy);
			}
		}
		
		//2.
		
		for (int i = 0; i < 100; i++) {
			int chance = rng.nextInt(100);
			if(chance < 40){
				usa.addImmigrant(new NormalImmigrant(rng.nextInt(1500)));
				continue;
			}
			if(chance >= 40 && chance <= 75){
				usa.addImmigrant(new RadicalImmigrant(rng.nextInt(5000)));
				continue;
			}
			if(chance > 75) {
				usa.addImmigrant(new ExtremistImmigrant(rng.nextInt(15000)));
			}
		}
		
		for(Immigrant x : usa.getIllegals()){
			try{
				x.addToFamily(usa.getIllegals().get(rng.nextInt(usa.getIllegals().size())));
				x.addToFamily(usa.getIllegals().get(rng.nextInt(usa.getIllegals().size())));
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
				blackMarket.add(new Weapon(arms.Weapon.Type.PISTOL, rng.nextInt(1000)));
				break;
			case 1:
				blackMarket.add(new Weapon(arms.Weapon.Type.BOMB, rng.nextInt(1200)));
				break;
			case 2:
				blackMarket.add(new Weapon(arms.Weapon.Type.GUN, rng.nextInt(2500)));
				break;
			}
		}
		
		for(int i = 0; i < usa.getIllegals().size(); i++){
			try{
				usa.getIllegals().get(i).buyWeapon(blackMarket);
				usa.getIllegals().get(i).buyWeapon(blackMarket);
				usa.getIllegals().get(i).buyWeapon(blackMarket);
				usa.getIllegals().get(i).buyWeapon(blackMarket);
				usa.getIllegals().get(i).buyWeapon(blackMarket);
			}
			catch(NoMoneyException e){
				continue;
			}
		}
		
		//4.
		
		for (int i = 0; i < usa.getIllegals().size(); i++) {
			usa.getIllegals().get(i).immigrate();
		}
		
		//5.
		
		for(Immigrant x : usa.getApprovedIllegals()){
			x.printInfo();
		}
		
		//6.
		for (int i = 0; i < 20; i++) {
			Immigrant guy = usa.getApprovedIllegals().get(rng.nextInt(usa.getApprovedIllegals().size()));
			try{
				guy.goCrazy();
			}
			catch(BombExplosionException e){
				System.out.println("Rip " + guy.getCity().getNAME());
			}
		}
		
		//7.
		Collections.sort(usa.getCities(), new CityComparatorByCitizens());
		System.out.println(usa.getCities());
		Collections.sort(usa.getApprovedIllegals(), new MoneyComparator());
		System.out.println(usa.getApprovedIllegals());
		System.out.println("Suicide bombers: " + usa.getSuicideBombers());
		
	}
}
