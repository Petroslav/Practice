package fake_diablo;

public class Status {

	private boolean stun;
	private boolean burn;
	private int stunRemaining;
	private int burnRemaining;
	private double burnDmg;
	private boolean buffed;
	
	public Status() {
		this.stun = false;
		this.stunRemaining = 0;
		this.burn = false;
		this.burnRemaining = 0;
		this.burnDmg = 0;
		this.buffed = false;
	}

	public boolean isStun() {
		return stun;
	}

	public void setStun(boolean stun) {
		this.stun = stun;
	}

	public int getStunRemaining() {
		return stunRemaining;
	}

	public void setStunRemaining(int stunRemaining) {
		this.stunRemaining = stunRemaining;
	}

	public boolean isBurn() {
		return burn;
	}

	public void setBurn(boolean burn) {
		this.burn = burn;
		if(!this.burn) {
			this.burnRemaining = 0;
			this.burnDmg = 0;
		}
	}

	public int getBurnRemaining() {
		return burnRemaining;
	}

	public void setBurnRemaining(int burnRemaining) {
		this.burnRemaining = burnRemaining;
	}

	public double getBurnDmg() {
		return burnDmg;
	}

	public void setBurnDmg(double burnDmg) {
		this.burnDmg += burnDmg;
	}
	
	public boolean isBuffed() {
		return buffed;
	}
	
	public void setBuffed(boolean buffed) {
		this.buffed = buffed;
	}
	
	public void statusGCD(){
		this.burnRemaining--;
		this.stunRemaining--;
		if(this.stunRemaining < 0) {
			this.stun = false;
			this.stunRemaining = 0;
		}
		if(this.burnRemaining == 0) {
			this.burn = false;
			this.burnDmg = 0;
		}
	}	
}
