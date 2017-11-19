import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
		System.out.println("input a number between 10 and 200");
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n > 200 || n < 10){
			System.out.println("no ");
			return;
		}
		for (int i = n; i > 9; i--) {
			if(i%7 == 0){
				System.out.println(i);
			}
		}
		
		
	}
}
