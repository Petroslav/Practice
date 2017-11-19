import java.util.Scanner;

public class Task18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 2 numbers between 1 and 9");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a < 1 || b < 1 || a > 9 || b > 9){
			System.out.println("No.");
			return;
		}
		
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				System.out.println(i+"x"+j+" = "+(i*j)+";");
			}
			
		}
	}
}
