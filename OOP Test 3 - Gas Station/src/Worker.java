import java.util.Random;

public class Worker extends Staff {
	
	@Override
	public void run() {
		Random rng = new Random();
		while(true){
			GasDispenser nextDispenser = getWorkplace().getColumns().get(rng.nextInt(5));
			Car car = null;
			if(nextDispenser.isBusy()){
				continue;
			}else{
				car = nextDispenser.getCarswaiting().poll();				
				if(car == null) { 
					continue;
				}
			}
		
			car.getDispenser().makeBusy();
			car.loadCar((nextDispenser.loadFuel(rng.nextInt(30) + 11)) , nextDispenser.loadType(rng.nextInt(3)));
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("rip");
			}
			
			getWorkplace().getRegister().getClients().offer(car.getOwner());
		}
	}
}
