package taskforce;

import illegals.*;

public class SpecialOps extends TaskForce {

	private static final int CAPTURE_RATE = 90;
	
	public SpecialOps(String name) {
		super(name);
	}
	
	public boolean checkImmigrant(Immigrant e) throws NotMyJobException{
		if(e instanceof Normal) {
			throw new NotMyJobException();			
		}
		return this.capture();
	}
		
	private boolean capture(){
		if(rng.nextInt(100) > CAPTURE_RATE) return false;
		return true;
	}
}
