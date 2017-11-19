package homework_task_and_exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class CarFactory {

	public static void main(String[] args) {
		ArrayList<Car> garage = new ArrayList<Car>();
		ArrayList<Runnable> tasks = new ArrayList<Runnable>();
		BlockingQueue<Engine> engineStock = new LinkedBlockingQueue<Engine>();
		BlockingQueue<Frame> frameStock = new LinkedBlockingQueue<Frame>();
		BlockingQueue<Tyre> tyreStock = new LinkedBlockingQueue<Tyre>();
		BlockingQueue<Seat> seatStock = new LinkedBlockingQueue<Seat>();
		Thread tyre = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("No tyre now =/");
				}
				tyreStock.offer(new Tyre());
				System.out.println(Thread.currentThread().getName() + " - New tyre!");
			}
		};
		Thread seat = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("No seat now =/");
				}
				seatStock.offer(new Seat());
				System.out.println(Thread.currentThread().getName() + " - New seat!");
			}
		};
		Thread frame = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("No frame now =/");
				}
				frameStock.offer(new Frame());
				System.out.println(Thread.currentThread().getName() + " - New frame!");
			}
		};
		Thread engine = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					System.out.println("No engine now =/");
				}
				engineStock.offer(new Engine());
				System.out.println(Thread.currentThread().getName() + " - New engine!");
			}
		};
		for(int i = 0; i < 10; i++){
			tasks.add(engine);
			tasks.add(frame);
			for (int j = 0; j < 5; j++) {
				if(i < 4)tasks.add(tyre);
				tasks.add(seat);
			}
		}
		Collections.shuffle(tasks);
		long start = System.currentTimeMillis();
		ExecutorService exec = Executors.newFixedThreadPool(3);
		for(Runnable x : tasks){
			exec.execute(x);
		}
		exec.shutdown();
		while(true){
			if(tyreStock.size() >= 4 && seatStock.size() >= 5 && frameStock.size() >= 1 && engineStock.size() >= 1){
				garage.add(new Car(engineStock, frameStock, seatStock, tyreStock));
				System.out.println("Cars built: " + garage.size());
			}
			if(garage.size() >= 10) break;
		}
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		System.out.println("Cars built: " + garage.size());
	}
	public static class Tyre{
	}	
	public static class Seat{
	}
	public static class Frame{
	}
	public static class Engine{
	}
	public static class Car{
		private Engine engine;
		private Frame frame;
		private ArrayList<Tyre> tyres;
		private ArrayList<Seat> seats;

		public Car(Queue<Engine> engine, Queue<Frame> frame, Queue<Seat> seat, Queue<Tyre> tyre){
			this.engine = engine.remove();
			this.frame = frame.remove();
			this.tyres = new ArrayList<Tyre>();
			for(int i = 0; i < 4; i++){this.tyres.add(tyre.remove());
			}
			this.seats = new ArrayList<Seat>();
			for(int i = 0; i < 5; i++){
				this.seats.add(seat.remove());
			}
			System.out.println("A car has been built!");
		}
	}
}