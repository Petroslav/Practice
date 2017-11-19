import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input a number");
		int num = sc.nextInt();
		int n = num-1;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(n);
			}
			n+=2;
			System.out.println();
		}
		
	}
}
