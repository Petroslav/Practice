import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class KekOfWar {

	public static void main(String[] args) throws IOException {
		
		KekOfWar.countWithThreads(5);
	}
	
	public static void countWithThreads(int n)throws IOException {
		File war = new File("Blyat/war and mir.txt");
		Scanner sc = new Scanner(war);
		ExecutorService exec = Executors.newFixedThreadPool(n);
		ArrayList<Future<Integer>> tests = new ArrayList<>();
		StringBuilder vim = new StringBuilder();
		while(sc.hasNextLine()){
			String row = sc.nextLine();
			vim.append(row);
		}
		sc.close();
		int length = vim.length();
		while(length % n != 0){
			length++;
		}
		int cutoff = length/n;
		int start = 0;
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			if(cutoff > vim.length()) cutoff = vim.length();
			String ss = vim.substring(start, cutoff);
			start = cutoff;
			cutoff += cutoff;
			Future<Integer> test = exec.submit(new CommaCounter(ss));
			tests.add(test);			
		}
		int commas = 0;
		for(Future<Integer> f : tests){
			try {
				commas += f.get();
			}
			catch (InterruptedException e) {
			}
			catch (ExecutionException e) {
			}
		}
		System.out.println("Commas: " + commas);
		System.out.println("Time taken with " + n + " threads: " + (System.currentTimeMillis() - startTime));
	}
	
	public static class CommaCounter implements Callable<Integer> {
		private String s;
		
		CommaCounter(String s){
			this.s = s;
		}
		
		@Override
		public Integer call() throws Exception {
			int commas = 0;
			for(char k : s.toCharArray()){
				if(k == ',') commas++;
			}
			return commas;
		}
		
	}
}
