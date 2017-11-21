package reading_material;

import java.util.Date;
import java.util.TreeMap;

public abstract class ReadingMaterial {
	
	public final int CHECKOUT_LENGTH;
	public final double RENT_TAX;
	private Date checkoutDate;
	private String name;
	private String publisher;
	private TreeMap<Date, Date> checkoutHistory;
	
	//Constructor: 
	public ReadingMaterial(String name, String publisher, int lendTime, int tax){
		CHECKOUT_LENGTH = lendTime;
		RENT_TAX = tax;
		this.name = name;
		this.publisher = publisher;
		this.checkoutHistory = new TreeMap<Date, Date>();
	}
	
	//Getters:	
	public String getName() {
		return name;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	
	//Setters:
	
	
	//Methods:
	public void CheckOut(){
		this.checkoutDate = new Date();
		this.checkoutHistory.put(this.checkoutDate, null);
	}
	
	public void Return(){
		this.checkoutHistory.put(this.checkoutDate, new Date());
		
	}
}
