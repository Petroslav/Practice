package future_and_callable_tests;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoAdder {
	
	public static void main(String[] args) {
		DemoAdder sadder = new DemoAdder();
		int pakapaka = sadder.parallelSum(5, 26);
		int paknepak = sadder.sequentialSum(5, 26);
		System.out.println("Equals? : " + (pakapaka == paknepak));
		
	}
	
	public Integer parallelSum(int first, int last){
		
		ExecutorService exec = Executors.newFixedThreadPool(10);
		ArrayList<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		int count = 1;
		int prev = first;
		for(int i = first; i <= last; i++){
			if(i == last && count == 1){
				Future<Integer> future = exec.submit(new Adder(0, i));
				futureList.add(future);
			}
			if(count == 2){
				System.out.println("Prev: " + prev + " current: " + i);
				Future<Integer> future = exec.submit(new Adder(prev, i));
				futureList.add(future);
				count = 1;
				continue;
			}
			prev = i;
			count++;
		}
		int totalSum = 0;
		for(Future<Integer> futs : futureList){
			try {
				totalSum += futs.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		exec.shutdown();
		System.out.println("Total sum: " + totalSum);
		return totalSum;
	}
    
	public int sequentialSum(int first, int last){                      
		//long t1 = System.currentTimeMillis();
		   Integer totsum=0;                        
		   for(int i = first; i <= last; i++){
		       totsum += i;                                              
		   }                       
		   //long t2 = System.currentTimeMillis();                       
		   System.out.println("sequentialSum Total Sum is " + totsum);
		   //System.out.println("Time taken by sequentialSum " + (t2-t1));
		   return totsum;
	}  
}
