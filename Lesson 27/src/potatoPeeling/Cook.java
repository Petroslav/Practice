package potatoPeeling;

public class Cook implements Runnable{

	private Kitchen kitchen;
	
	public Cook(Kitchen kit){
		this.kitchen = kit;
	}
	@Override
	public void run() {
		while(true){
			this.kitchen.usePotato();
		}
	}
}
