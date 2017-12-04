import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GasDispenser {

	private BlockingQueue<Car> carswaiting;
	private int number;
	private boolean busy;
	private static int NUMS = 1;
	private int lastLoadedFuel;
	private int lastFuelType;
	
	public GasDispenser(){
		this.carswaiting = new ArrayBlockingQueue<Car>(50);
		this.busy = false;
		this.number = NUMS++;
	}

	public BlockingQueue<Car> getCarswaiting() {
		return carswaiting;
	}

	public void addCar(Car car) {
		car.setColumn(this.number);
		car.loadColumn(this);
		this.carswaiting.offer(car);
	}

	public int getNumber() {
		return number;
	}
	
	public int getLastFuelType() {
		return lastFuelType;
	}
	
	public int getLastLoadedFuel() {
		return lastLoadedFuel;
	}
	
	public int loadFuel(int fuel){
		this.lastLoadedFuel = fuel;
		return fuel;
	}
	
	public int loadType(int type){
		this.lastFuelType = type;
		return type;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
	public void makeBusy(){
		this.busy = true;
	}
	public void freeColumn(){
		this.busy = false;
	}
	
	
}
