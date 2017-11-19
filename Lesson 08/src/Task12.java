import java.util.Arrays;
import java.util.Scanner;

public class Task12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Arrays.toString(returnArray(n)));
	}
	
	static int[] returnArray(int n){
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		return arr;
		
	}
}
