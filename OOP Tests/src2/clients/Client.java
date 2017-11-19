package clients;
import java.util.ArrayList;
import java.util.Random;
import menu.IItem;
import restaurant.Waiter;

public abstract class Client {

	private final String NAME;
	protected double cash;
	private Waiter server;
	private int bill;
	private static int ID = 1;
	protected ArrayList<IItem> order;
	protected final double ORDER_CAP = 0.9;
	protected Random rng = new Random();
	
	public Client() {
		NAME = "Darius " + ID++;
		this.bill = 0;
		this.order = new ArrayList<IItem>();
	}
	
	public abstract void makeOrder();
	
	public int requestBill(){
		this.bill = this.server.bill(this);
		return bill;
	}
	public void payBill(){
		if(rng.nextInt(101) <= 80){
			double tip = (rng.nextInt(6) + 5) / 100.0;
			this.server.tip(this.bill * tip);
		}
		
		this.server.getPaid(this.bill);
		this.cash -= this.bill;
	}
	
	public void setWaiter(Waiter w){
		this.server = w;
		w.getClients().put(this, new ArrayList<IItem>());
	}
	
	public Waiter getServer() {
		return server;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NAME == null) ? 0 : NAME.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return NAME;
	}
}
