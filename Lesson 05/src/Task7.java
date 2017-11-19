import java.util.Arrays;
import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("size");
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] newArr = new int[size];
		newArr[0] = arr[0];
		newArr[newArr.length-1] = arr[arr.length-1];
		for (int i = 1; i < newArr.length-1; i++) {
			newArr[i] = arr[i-1]+arr[i+1];
		}
		System.out.println(Arrays.toString(newArr));
	}
}
