import java.util.Arrays;
import java.util.Scanner;

public class Task9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input array size: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Input cell "+(i+1)+" value:");
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[(arr.length-1) - i];
			arr[(arr.length-1) - i] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
