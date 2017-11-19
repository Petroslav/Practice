package abstraction;

public interface Vehicle {
	
	public static final String SPEED_MEASURE = "km/h";
	
	int x = 4; // This is actually public static final int x = 4;

	public void turn(String direction);
	
	public void stop();
	
	public void accelerate();
	
}
