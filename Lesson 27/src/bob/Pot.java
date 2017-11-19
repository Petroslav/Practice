package bob;

public class Pot {
	
	private static final int MAX_BOB = 500;
	private static final int MIN_BOB = 50;

	private int bob = 200;
	
	public synchronized void sipiBob(int newBob){
		if(bob >=MAX_BOB){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.bob+=newBob;
		notifyAll();
		System.out.println("Sipahme bob, ostava " + bob);
	}

	public synchronized void hapniBob(int izqdenBob){
		if(bob <=MIN_BOB){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.bob-=izqdenBob;
		notifyAll();
		System.out.println("Hapnahme bob, ostava " + bob);
	}
}
