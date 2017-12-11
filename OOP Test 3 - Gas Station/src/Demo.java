
public class Demo {

	public static void main(String[] args) {
		GasStation shell = new GasStation();
		
		for(int i = 0; i < 30; i++){
			shell.serviceCar(new Car());
		}
		
		shell.startWork();
		shell.startGeneratingReports(true);
		try {
			Thread.sleep(70*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
	}
}
