package executor;

public class EngineMaker implements Runnable{

	public void run() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " - Engine ready");
	};
}
