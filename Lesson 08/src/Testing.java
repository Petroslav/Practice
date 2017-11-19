import java.util.Random;
import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(factoriel(n));
		
	}
	
	static void printArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			if(i == 0){
				System.out.print("[ "+arr[i]+", ");
			}else{
				if( i < arr.length-1){
					System.out.print(arr[i]+", ");
				}else{
					System.out.print(arr[i]+" ]");
				}
			}
			
		}
	}
	
	static int[] randomArray(int n){
		int[] arr = new int[n];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(25);
		}
		return arr;
	}
	
	static int[] multiplyArrays(int[] arr1, int[] arr2){
		int max = arr1.length > arr2.length? arr1.length : arr2.length;
		int[] arr3 = new int[max];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr1[i]*arr2[i];
		}
		return arr3;
	}
	
	static int fibonacci(int n){
		int n1 = 0;
		int n2 = 1;
		int fib = 0;
		if(n <= 2){
			if(n == 1){
				return n1;
			}else{
				return n2;
			}
		}else{
			for (int i = 0; i < n-2; i++) {
				fib = n1+n2;
				n1 = n2;
				n2 = fib;
			}
			return fib;
		}
		
	}
	
	static int romanToDecimal(String s){

		int num = 0;
		s.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'I'){
				num+=1;
			}
			if(s.charAt(i) == 'V'){
				num+=5;
			}
			if(s.charAt(i) == 'X'){
				num+=10;
			}
			if(s.charAt(i) == 'L'){
				num+=50;
			}
			if(s.charAt(i) == 'C'){
				num+=100;
			}
			if(s.charAt(i) == 'D'){
				num+=500;
			}
			if(s.charAt(i) == 'M'){
				num+=1000;
			}
		}
		return num;
	}
	
	static int factoriel(int n){
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact*=i;
		}
		return fact;
	}
	
}
