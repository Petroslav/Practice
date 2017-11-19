package bob;

public class Baba extends Thread{

	private Pot gurne;
	
	Baba(Pot pot){
		this.gurne = pot;
	}
	
	@Override
	public void run() {
		while(true){
			gurne.sipiBob(30);
		}
	}
}
