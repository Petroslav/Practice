package illegals;

import java.util.ArrayList;

import country.City;
import country.Country;
import country.NukeExplodedException;
import taskforce.Weapon;
import taskforce.Weapon.Type;

public class Radical extends Immigrant {


	private ArrayList<Weapon> weapons;

	public Radical(boolean passport, double money, Country country) {
		super(country);
		if(passport) this.passport = new Passport();
		this.money = money;
		this.weapons = new ArrayList<Weapon>();
		this.name = "Radical Carlos " + Immigrant.number++;
	}
	
	@Override
	public void buyWeapon(ArrayList<Weapon> market) throws NotEnoughMoneyForWeaponException {
		if(market.size() == 0 || this.weapons.size() == 5) return;
		int index = rng.nextInt(market.size());
		Weapon weapon = market.get(index);
		if(weapon.getType() != Type.BOMB) return;
		if(this.money < weapon.getCost()) throw new NotEnoughMoneyForWeaponException();
		if(this.money > weapon.getCost()){
			this.money -= weapon.getCost();
			this.weapons.add(market.get(index));
			market.remove(index);
		}		
	}

	@Override
	public void addRelative(Immigrant e) throws FamilyFullException {
		this.relatives.add(e);
		e.relatives.add(this);		
	}

	@Override
	public void goCrazy() throws NukeExplodedException {
		// TODO Auto-generated method stub
		
	}
}
