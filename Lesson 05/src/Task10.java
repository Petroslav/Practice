import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum+= arr[i];
		}
		sum = sum/7;
		int close = sum - arr[0];
		int num = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			int closer = sum-arr[i];
			if(closer < 0){
				closer*=-1;
			}
			if(closer < close){
				close = closer;
				num = arr[i];
			}
			
		}
		System.out.println(num);
		
	}
}
