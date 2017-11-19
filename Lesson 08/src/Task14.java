import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factoriel(n));
	}
	
	static int factoriel(int n){
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact*=i;
		}
		return fact;
	}
	
}
