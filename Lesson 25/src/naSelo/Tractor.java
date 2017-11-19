package naSelo;

public class Tractor {

	private int hp;
	private String model;
	private static int gumi = 4;
	private Trailer remarke;
	protected Engine dvigatel;
	
	public Tractor(int hp, String model) {
		this.hp = hp;
		this.model = model;
		Engine.material = "chogun";
		this.remarke = new Trailer();
		this.dvigatel = new Engine();
	}
	
	private static class Engine{
		private int sparks = 4;
		private static String material = "Steel";
		
		void start(){
			System.out.println("brum brum");
		}
	}
	
	private static class Trailer{//remarke
		
	}
	
	void start(){
		System.out.println("palim!");
		this.dvigatel.start();
	}
	
	@Override
	public String toString() {
		return "Tractor with " + hp + " hp and model " + model; 
	}
	
	public int getHp() {
		return hp;
	}
	
	public String getModel() {
		return model;
	}
}
