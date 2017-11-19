package law_enforcement;

import america.Country;
import immigrants.*;

public class SpecialOps extends LawEnforcer {

	private static final int CAPTURE_RATE = 90;

	public SpecialOps(String name, Country country) {
		super(name, country);
	}

	@Override
	public boolean checkImmigrant(Immigrant juan) {
		if(juan instanceof NormalImmigrant) return true;
		return this.capture();
	}
		
	private boolean capture(){
		if(rng.nextInt(100) > CAPTURE_RATE) return false;
		return true;
	}
}
