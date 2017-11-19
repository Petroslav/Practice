package threads;

public class SleepingThreads {

	public static void main(String[] args) throws InterruptedException {
		
		String text = new String ("Hi! This is a robot that serves you! Make a wish!");
		
		Thread t = new Thread(){
			@Override
			public void run() {
				//int delay = 100;
				//while(true){
					
					System.out.println(text);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						System.out.println("I was interrupted. I will now die quietly into the night");
						return;
					}
				//}
			}
		};
		t.start();
		t.join(5000);
		System.out.println("I`m awake!");
		if(t.isAlive()){
			t.interrupt();
		}
	}
}
