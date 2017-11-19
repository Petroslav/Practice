package racing;

public class Account {

	private int balance = 0;
	Object lock = new Object();
	
	public synchronized void add(int money){
		System.out.println("Adding " + money);
		balance += money;
	}
	
	public synchronized void get(int money){
		System.out.println("Removing " + money);
		balance -= money;
	}
	
	public synchronized void check(){
		System.out.println("Balance = " + balance);
	}
	
	public void report(){
		System.out.println("Hi");
		System.out.println("This is a report");

		synchronized (lock) {
			//dangerous code
			//....
			//...
		}
		
		System.out.println("End of report");
		System.out.println("Bye");
	}
}
