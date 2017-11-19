package threads;

public class Mare implements Runnable {

	private String name;
	
	Mare(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " runs gently " + (i+1)*10 + " meters");
		}
		System.out.println(name + " FINISHED! " + ++Demo.position);
	}
}
