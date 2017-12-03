import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Register {

	private BlockingQueue<Owner> clients;
	
	public Register() {
		this.clients = new ArrayBlockingQueue<Owner>(50);
	}
	
	public BlockingQueue<Owner> getClients() {
		return clients;
	}
	
	public void sendClient(Owner o){
		this.clients.offer(o);
	}
	
	
	
}
