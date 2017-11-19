import java.util.Scanner;

public class Task17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input  the size of the square:");
		int b = sc.nextInt();
		System.out.println("Input the filling of the square:");
		char c = sc.next().charAt(0);
		for (int i = 0; i < b; i++) {
			System.out.print("*");
			
		}
		System.out.println();
		for (int i = 0; i < b-2; i++) {
			System.out.print("*");
			for (int j = 0; j < b-2; j++) {
				System.out.print(c);
				
			}
			System.out.print("*");
			System.out.println();
		}
		for (int i = 0; i < b; i++) {
			System.out.print("*");
			
		}
	}
}