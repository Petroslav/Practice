import java.util.Date;

public class Cashier extends Staff {

	@Override
	public void run() {
		while(true){
			Owner client = getWorkplace().getRegister().getClients().poll();
			GasDispenser gas = client.getCar().getDispenser();
			Receipt receipt = new Receipt(gas.getLastLoadedFuel(), gas.getLastFuelType(), gas.getNumber(), new Date());
			client.giveReceipt(receipt);
			getWorkplace().archiveReceipt(receipt);

			try {
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
			}
			
			gas.freeColumn();
			
		}
		
	}
	
}
