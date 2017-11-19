package executor;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarFactory {

	public static void main(String[] args) {
		
		ArrayList<Runnable> tasks = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			tasks.add(new TyreMaker());
		}
		tasks.add(new EngineMaker());
		tasks.add(new FrameMaker());
		for (int i = 0; i < 5; i++) {
			tasks.add(new SeatMaker());
		}
		
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(Runnable task : tasks){
			executor.execute(task);
		}
		
		executor.shutdown();
		
		while(!executor.isTerminated()){
		}
		long end = System.currentTimeMillis() - start;
		System.out.println(end);
		
	}
}
