package illegals;

import java.util.ArrayList;

import Country.*;
import taskforce.Weapon;
import taskforce.Weapon.Type;

public class Extremist extends Immigrant {


	private ArrayList<Weapon> weapons;
	private boolean hasBomb;
	
	public Extremist(double money, Country country) {
		super(country);
		this.money = money;
		this.weapons = new ArrayList<Weapon>();
		this.hasBomb = false;
		this.name = "Extremist Manuel " + Immigrant.number++;
	}
	
	public void buyWeapon(ArrayList<Weapon> market) throws NotEnoughMoneyForWeaponException{
		if(market.size() == 0) return;
		int index = rng.nextInt(market.size());
		Weapon weapon = market.get(index);
		if(this.money < weapon.getCost()) {
			throw new NotEnoughMoneyForWeaponException();
		}
		if(this.money > weapon.getCost()){
			this.money -= weapon.getCost();
			this.weapons.add(market.get(index));
			market.remove(index);
			if(weapon.getType() == Type.BOMB) this.hasBomb = true;
		}
		
	}

	@Override
	public boolean hasBomb() {
		return hasBomb;
	}
	@Override
	public void goCrazy() throws NukeExplodedException {
		if(this.hasBomb) throw new NukeExplodedException();
		
	}

	@Override
	public void addRelative(Immigrant e) throws FamilyFullException {
		this.relatives.add(e);
		e.relatives.add(this);
		
	}
}
