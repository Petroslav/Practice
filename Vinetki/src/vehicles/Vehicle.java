package vehicles;

public abstract class Vehicle {

	private String model;
	private Vignette vignette;
	private int year;
	
	public Vehicle(String model, int year) {
		super();
		this.model = model;
		this.year = year;
	}

	public Vignette getVignette() {
		return vignette;
	}

	public void setVignette(Vignette vignette) {
		this.vignette = vignette;
	}
}
