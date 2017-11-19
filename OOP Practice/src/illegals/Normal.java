package illegals;

import java.util.ArrayList;

import country.City;
import country.Country;
import country.NukeExplodedException;
import taskforce.Weapon;

public class Normal extends Immigrant {
	
	int maxRelatives;

	public Normal(double money, Country country) {
		super(country);
		this.passport = new Passport();
		this.name = "Juan " + Immigrant.number++;
	}

	@Override
	public void buyWeapon(ArrayList<Weapon> market) {
		return;		
	}
	
	@Override
	public void addRelative(Immigrant e) throws FamilyFullException {
		if(this.relatives.size() < 10 && this != e){
			if(e instanceof Normal && e.relatives.size() >= 10) throw new FamilyFullException();
			this.relatives.add(e);
			e.relatives.add(this);
			this.maxRelatives--;
			if(e instanceof Normal) ((Normal) e).maxRelatives--;
		}
		else{
			System.out.println("Family full!");
			throw new FamilyFullException();
		}
	}

	@Override
	public void goCrazy() throws NukeExplodedException {
		return;
		
	}

}
