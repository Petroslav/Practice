package racing;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

	public static void main(String[] args) {
		
		Account myAcc = new Account();
		Account myAcc2 = new Account();
		
		Thread t1 = new Thread(()-> myAcc.add(100));
		Thread t2 = new Thread(()-> myAcc.get(100));
		Thread t3 = new Thread(()-> myAcc.check());
		
		Thread t4 = new Thread(()-> myAcc2.add(100));
		Thread t5 = new Thread(()-> myAcc2.get(100));
		Thread t6 = new Thread(()-> myAcc2.check());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		AtomicInteger a = new AtomicInteger(5);
		a.incrementAndGet();//++a;
		a.getAndIncrement();//a++;
		a.decrementAndGet();//--a;
		a.getAndDecrement();//a--;
		int b = 5;
		b +=4;
		//return b;
		AtomicInteger atom = new AtomicInteger(5);
	}
}
