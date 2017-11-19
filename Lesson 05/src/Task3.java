import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input input a number");
		int a = sc.nextInt();
		int[] arr = new int[10];
		arr[0] = a;
		arr[1] = a;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		System.out.println(Arrays.toString(arr));
	}
}
