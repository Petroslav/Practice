import java.util.Scanner;

public class Task11Optional {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input triangle height");
		int n = sc.nextInt();
		int row = 0;
		for (int i = n-1; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < row; j++) {	
				System.out.print(" ");
			}
			if(row > 0){
				System.out.print("*");
			}

			System.out.println();
			row+=2;
		}
		for (int i = 0; i < n+2; i++) {
			System.out.print("*");
		}
	}
}
