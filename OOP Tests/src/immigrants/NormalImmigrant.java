package immigrants;

import java.util.ArrayList;

import arms.Weapon;
import exceptions.FamilyFullException;

public class NormalImmigrant extends Immigrant {
	
	public NormalImmigrant(int money) {
		super("Juan " + Immigrant.id++);
		this.setCash(money);
		this.passport = new Passport("Juan " + Immigrant.id);
		this.setHasBomb(false);
	}

	@Override
	public void addToFamily(Immigrant juan) throws FamilyFullException {
		if(this.relatives.size() < 10 && this != juan){
			if(juan instanceof NormalImmigrant && juan.relatives.size() >= 10) throw new FamilyFullException();
			this.relatives.add(juan);
			juan.relatives.add(this);
		}
		else{
			throw new FamilyFullException();
		}		
	}

	@Override
	public void goCrazy() {
		return;		
	}
	
	@Override
	public void buyWeapon(ArrayList<Weapon> market) {
		return;		
	}

}
