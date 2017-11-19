package potatoPeeling;

public class NoobCook implements Runnable{

	private Kitchen kitchen;
	
	public NoobCook(Kitchen kit){
		this.kitchen = kit;
	}
	@Override
	public void run() {
		while(true){
			this.kitchen.peelPotato();
		}
	}
	
}
