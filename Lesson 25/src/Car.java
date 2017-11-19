
public class Car {

	private String model;
	private int hp;
	private Engine engine;
	private GearBox gears;
	
	public Car(String model, int hp){
		this.model = model;
		this.hp = hp;
		this.engine = new Engine();
		this.gears = new GearBox(false);
	}
	
	class GearBox{
		int maxGears;
		int currentGear;
		boolean isAutomatic;
		
		
		GearBox(boolean auto){
			this.maxGears = 6;
			this.currentGear = 1;
			this.isAutomatic = auto;
		}
		
		private void shiftUp(){
			if(this.currentGear < maxGears)
				this.currentGear++;
		}
		
		private void shiftDown(){
			if(this.currentGear >= 1)
				this.currentGear--;
		}
		
		@Override
		public String toString() {
			return "Gear: " + currentGear;
		}
	}
	
	class Engine{
		private boolean isRunning;
		
		Engine(){
			this.isRunning = false;
		}
		
		private void start(){
			this.isRunning = true;
		}
		private void stop(){
			this.isRunning = false;
		}
	}
	
	public void start(){
		this.engine.start();
	}
	
	public void stop(){
		this.engine.stop();
	}
	
	public void upGear(){
		this.gears.shiftUp();
	}
	public void downGear(){
		this.gears.shiftDown();
	}
	
	public void checkGear(){
		System.out.println(this.gears.toString());
	}
	
	public void slamBrakes(){
		class TailLight{
			static final int STOP_LINE = 10;
			
		}
		
		for (int i = 0; i < TailLight.STOP_LINE; i++) {
			System.out.println("SCHRIIIIIIIIIIIIIIIIIII>>>> " + (TailLight.STOP_LINE+i));
		}
	}
	
	@Override
	public String toString() {
		return "Model: " + this.model + ", Horsepower: " + this.hp + "\n" + ((engine.isRunning == true)? "Car is running" : "Car isn't running") + ", " + this.gears.toString();
	}
}
