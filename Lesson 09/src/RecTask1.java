import java.util.Scanner;

public class RecTask1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sum(n));
		System.out.println(fibonacci(n));
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int x = sc.nextInt();
		System.out.println(arrContains(arr, x, 0));
		
	}
	
	static int sum(int n){
		if(n == 1){
			return 1;
		}
		return n+sum(n-1);
	}
	
	static int fibonacci(int n){
		if(n == 1){
			return 0;
		}
		if(n == 2){
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	static boolean arrContains(int[] arr, int x, int i){
		if(i >= arr.length){
			return false;
		}
		if(arr[i] == x){
			return true;
		}else{
			return arrContains(arr, x, i+1);
			
		}
		
	}
}
