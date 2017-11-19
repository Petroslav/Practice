package threads;

public class Horse extends Thread {
	
	Horse(String name){
		setName(name);
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + " runs " + (i+1)*10 + " meters");
		}
		System.out.println(getName() + " FINISHED! " + ++Demo.position);
	}
}
