package immigrants;

import java.util.ArrayList;

import arms.*;
import arms.Weapon.Type;
import exceptions.FamilyFullException;
import exceptions.NoMoneyException;

public class RadicalImmigrant extends Immigrant {
	
	public RadicalImmigrant(int money){
		super("Radical Raul " + Immigrant.id++);
		this.setCash(money);
		if(rng.nextInt(100) < 35) this.passport = new Passport("Radical Raul " + Immigrant.id);
		this.setHasBomb(false);
	}

	@Override
	public void addToFamily(Immigrant juan) throws FamilyFullException {
		if(this != juan){
			if(juan instanceof NormalImmigrant && juan.relatives.size() == 10) throw new FamilyFullException();
			this.relatives.add(juan);
			juan.relatives.add(this);			
		}		
	}

	@Override
	public void goCrazy() {
		int kills = 0;
		for(Weapon x : this.weapons){
			int shots = x.shoot();
			double killShots = (rng.nextInt(60) + 10) / 100.0;
			kills += Math.round(shots*killShots);
		}
		System.out.println(this.getName() + " got " + kills + " kills!");
		this.getCity().killCitizens(kills);
		
	}

	@Override
	public void buyWeapon(ArrayList<Weapon> market) throws NoMoneyException {
		if(market.size() == 0 || this.weapons.size() == 5) return;
		int index = rng.nextInt(market.size());
		Weapon weapon = market.get(index);
		if(weapon.getType() != Type.BOMB) return;
		if(this.getCash() < weapon.getPrice()) {
			this.leaveFamily();
			this.currentCountry.removeIllegal(this);
			System.out.println("I'm coming, Allah!!!");
			throw new NoMoneyException();
		}
		else{
			this.setCash(this.getCash() - weapon.getPrice());
			this.weapons.add(market.get(index));
			market.remove(index);
		}
		
	}

}
