
public class Car {

	private int gasLoaded;
	private int fueltype;
	private int columnNum;
	private GasDispenser column;
	private Owner owner;
	
	public Car() {
		this.owner = new Owner();
		this.owner.setCar(this);
	}
	
	public int getGasLoaded() {
		return gasLoaded;
	}
	public void loadCar(int gasLoaded, int ft) {
		this.fueltype = ft;
		this.gasLoaded = gasLoaded;
	}
	public int getColumn() {
		return columnNum;
	}
	public int getFueltype() {
		return fueltype;
	}
	public void setColumn(int column) {
		this.columnNum = column;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public void loadColumn(GasDispenser d){
		this.column = d;
	}
	public GasDispenser getDispenser(){
		return column;
	}
	
	
}
