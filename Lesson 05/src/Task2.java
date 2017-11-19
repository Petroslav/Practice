import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		System.out.println(5/2);
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		int[] arr2 = new int[size];
		for (int i = 0; i < arr2.length; i++) {
			arr[i] = sc.nextInt();
			if(i < (arr.length/2)){
				arr2[i]=arr[i];
			}
		}
		for (int i = 1; i < arr2.length/2; i++) {
			for (int j = arr.length/2; j < arr2.length; j++) {
				arr2[j] = arr[arr2.length-i];
				i++;
			};
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}
}
