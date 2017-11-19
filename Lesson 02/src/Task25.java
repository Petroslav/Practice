import java.util.Scanner;

public class Task25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input N: ");
		int n = sc.nextInt();
		int all = 1;
		int n2 = 1;
		do{
			all*=n2;
			n2++;
		}while(n2 <= n);
		System.out.println("N! = "+all);
	}
}
