package immigrants;

import java.util.ArrayList;

import arms.Weapon;
import arms.Weapon.Type;
import exceptions.BombExplosionException;
import exceptions.FamilyFullException;
import exceptions.NoMoneyException;

public class ExtremistImmigrant extends Immigrant {
	
	public ExtremistImmigrant(int money) {
		super("Extremist carlos " + Immigrant.id++);
		this.setCash(money);
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
	public void goCrazy() throws BombExplosionException {
		this.currentCountry.getSuicideBombers().add(this);
		this.currentCountry.removeCity(this.getCity());
		this.leaveFamily();
		this.currentCountry.removeIllegal(this);
		System.out.println("ALLAH ACKBAR!");
		this.currentCountry.removeCity(this.getCity());
		this.currentCountry.removeApprovedIllegal(this);
		throw new BombExplosionException();
		
	}

	@Override
	public void buyWeapon(ArrayList<Weapon> market) throws NoMoneyException {
		if(market.size() == 0) return;
		int index = rng.nextInt(market.size());
		Weapon weapon = market.get(index);
		if(this.getCash() < weapon.getPrice()) {
			this.leaveFamily();
			this.currentCountry.removeIllegal(this);
			System.out.println("I'm coming, Allah!!!");
			throw new NoMoneyException();
		}
		if(this.getCash() > weapon.getPrice()){
			this.setCash(this.getCash() - weapon.getPrice());
			this.weapons.add(market.get(index));
			market.remove(index);
		}
		if(weapon.getType() == Type.BOMB) this.setHasBomb(true);
		
	}

}
