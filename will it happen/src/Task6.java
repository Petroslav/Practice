import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("a1 = ");
		int a1 = sc.nextInt();
		System.out.print("a2 = ");
		int a2 = sc.nextInt();
		System.out.print("a3 = ");
		int a3 = sc.nextInt();
		int temp = a1;
		a1 = a2;
		a2 = a3;
		a3 = temp;
		System.out.println("===NEW VALUES===");
		System.out.println("a1 = "+a1+"\n"+"a2 = "+a2+"\n"+"a3 = "+a3);
				
	}
}
