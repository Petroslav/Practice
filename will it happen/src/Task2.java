import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		if(a < b){
			double f = a;
			a = b;
			b = f;
		}
		System.out.println("Sum: "+(a+b));
		System.out.println("Product: "+(a*b));
		System.out.println("Difference: "+(a-b));
		System.out.println("Division: "+(a/b));
		System.out.println("Super divison: "+(a%b));
	}
}
