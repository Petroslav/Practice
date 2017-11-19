import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		System.out.println("Please input a number");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int sum = 0;
		for (int i = 0; i < num+1; i++) {
			sum+=i;

		}
		System.out.println(sum);
	}
}
