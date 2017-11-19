package vehicles;
import java.util.Date;

public class Vignette {

	private Date dateOfIssue;
	private String color;
	private Date expiryDate;
	private boolean valid;
	private int price;
	
	public Vignette(int type, int validity) {
		switch(type){
		case 0:
			this.color = "Green";
			break;
		case 1:
			this.color = "Red";
			break;
		case 2:
			this.color = "Blue";
			break;
			
		}
	}

	public int getPrice() {
		return price;
	}
	
	
}
