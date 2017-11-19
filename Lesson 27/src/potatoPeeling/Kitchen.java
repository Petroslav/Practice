package potatoPeeling;

public class Kitchen {

	private int potatoes;
	private final int MAX_POTATOES = 500;
	private final int MIN_POTATOES = 50;
	
	public Kitchen(){
		this.potatoes = 200;
	}
	
	public synchronized void peelPotato(){
		if(potatoes >= MAX_POTATOES){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		potatoes++;
		System.out.println("Peeled a potato. Potatoes: " + this.potatoes);
	}
	
	public synchronized void usePotato() {
		if(potatoes <= MIN_POTATOES){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		potatoes--;
		System.out.println("Took a potato. Potatoes: " + this.potatoes);
	}
}
