package threads;

public class Demo {
	
	public static int position = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(Thread.currentThread().getName() + " says Hi!");
		System.out.println(Thread.currentThread().getName() + " says I`m the main thread");
		System.out.println(Thread.currentThread().getName() + " says Bye!");
		
		Horse stavri = new Horse("Stavri");
		Horse miro = new Horse("Miro");
		Horse david = new Horse("David");
		Mare stanka = new Mare("Stanka");
		Thread stankaThread = new Thread(stanka);
		
		Thread magare = new Thread("Marko"){
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(getName() + " kuca " + (i+1)*10 + " meters");
				}
				System.out.println(getName() + " FINISHED! " + ++Demo.position);
			}
		};
		
		Thread katur = new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Katura kuca " + (i+1)*10 + " meters");
				}
				System.out.println("Katura FINISHED! " + ++Demo.position);
			}
		});
		
		new Thread(
				() -> {
					for (int i = 0; i < 10; i++) {
						System.out.println("Lambda katur kuca " + (i+1)*10 + " meters");
					}
					System.out.println("Lambda katur  FINISHED! " + ++Demo.position);
				}
				).start();
		
		magare.start();
		stavri.start();
		miro.start();
		david.start();
		stankaThread.start();
		katur.start();

		System.out.println("Now we wait for Marko");
		magare.join();
		System.out.println("Now we wait for Stavri");
		stavri.join();
		System.out.println("Now we wait for Miro");
		miro.join();
		System.out.println("Now we wait for David");
		david.join();
		System.out.println("Now we wait for Stanka");
		stankaThread.join();
		System.out.println("Now we wait for Katur");
		katur.join();
		katur.interrupt();
		
		System.out.println("THE RACE IS OVER");
		
	}
}
