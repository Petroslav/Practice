package law_enforcement;

import america.Country;
import immigrants.*;

public class Policeman extends LawEnforcer {
	
	private static final int CAPTURE_RATE = 50;

	public Policeman(String name, Country country) {
		super(name, country);
	}


	@Override
	public boolean checkImmigrant(Immigrant juan) {
		if(juan instanceof NormalImmigrant) return true;
		if(!juan.hasBomb()){
			return this.capture();
		}
		return true;
	}
		
	private boolean capture(){
		if(rng.nextInt(100) > CAPTURE_RATE) return false;
		return true;
	}
}
