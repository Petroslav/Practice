import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input triangle height");
		int n = sc.nextInt();
		int row = 1;
		for (int i = n; i > 0; i--) {
			for (int j = i-1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < row; j++) {
				System.out.print("*");					
			}

			System.out.println();
			row=row+2;
		}
	}
}
