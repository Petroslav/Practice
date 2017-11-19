import java.util.Scanner;

public class ArrTask5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		int n;
		do{
			System.out.println("Input number of rows: ");
			m = sc.nextInt();
		}while(m < 1);
		do{
			System.out.println("Input number of columns: ");
			n = sc.nextInt();
		}while(n < 1);
		
		int[][] arr = new int[m][n];
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum+=arr[i][j];
			}
			if(sum > max){
				max = sum;
					
			}
		}
		System.out.println("Max sum is: "+max);
	}
}
