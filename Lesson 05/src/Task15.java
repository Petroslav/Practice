import java.util.Scanner;

public class Task15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input array size: ");
		int size = sc.nextInt();
		double[] arr = new double[size];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Input cell "+(i+1)+" value:");
			arr[i] = sc.nextDouble();
		}
		double max = 0;
		int maxI = 0;
		double sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] < 0){
					arr[j]*=-1;
				}
				if(arr[j] > max){
					max = arr[j];
					maxI = j;
				}
			}
			System.out.println(max);
			max = 0;
			arr[maxI] = 0;
		}
	}
}
