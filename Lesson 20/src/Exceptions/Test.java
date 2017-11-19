package Exceptions;

public class Test {

	public static void main(String[] args) {
		int[] a1 = {8, 3, 10, 24, 0, 4, 7, 14};
		int[] a2 = {4, 0, 5, 0, 9, 4};
		int[] a3 = devideArrays(a1, a2);
		for (int i = 0; i < a3.length; i++) {
			System.out.println("Element "+ (i+1) + ": " + a3[i]);
		}
		
	}
	
	public static int[] devideArrays(int[] a1, int[] a2){
		int[] a = null;
		if(a1.length >= a2.length) a = new int[a2.length];
		else a = new int[a1.length];
		
		for (int i = 0; i < a.length; i++) {
			try{
				a[i] = a1[i]/a2[i];
			}
			catch(ArithmeticException e){
				a[i] = 0;
			}
		}
		
		return a; 
	}	
}
