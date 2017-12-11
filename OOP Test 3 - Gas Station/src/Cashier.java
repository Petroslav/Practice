import java.util.Date;

public class Cashier extends Staff {

	@Override
	public void run() {
		while(true){
			Owner client = null;
			try {
				client = getWorkplace().getRegister().getClients().take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(client == null) continue;
			System.out.println(Thread.currentThread().getName() + " - Servicing new owner");
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
			System.out.println(Thread.currentThread().getName() + " - Owner paid and left");
			
		}
		
	}
	
}
