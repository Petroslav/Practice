package taskforce;

import illegals.Immigrant;
import illegals.Normal;

public class Policeman extends TaskForce {

	private static final int CAPTURE_RATE = 50;
	
	public Policeman(String name) {
		super(name);
	}
	
	public boolean checkImmigrant(Immigrant e){
		if(e instanceof Normal) return true;
		if(!e.hasBomb()){
			return this.capture();
		}
		return true;
	}
		
	private boolean capture(){
		if(rng.nextInt(100) > CAPTURE_RATE) return false;
		return true;
	}
}
