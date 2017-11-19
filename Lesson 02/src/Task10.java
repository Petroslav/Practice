import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a number");
		int num = sc.nextInt();
		for (int i = 2; i <= num; i++) {
			if(num%i == 0 && i != num){
				System.out.println("Number is not prime");
				break;
			}
			if(i == num){
				System.out.println("Number is prime");
			}
		}
	}
}
