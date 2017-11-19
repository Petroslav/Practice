package bob;

public class Vnuche extends Thread{

	private Pot gurne;
	
	Vnuche(Pot pot){
		this.gurne = pot;
	}
	
	@Override
	public void run() {
		while(true){
			gurne.hapniBob(30);
		}
	}
}