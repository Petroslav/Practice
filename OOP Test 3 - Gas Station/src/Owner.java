
public class Owner {

	private Car car;
	private Receipt receipt;
	
	public Car getCar(){
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public void giveReceipt(Receipt r){
		this.receipt = r;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
}
