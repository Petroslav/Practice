import java.util.Scanner;

public class Task15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input n");

		int n = sc.nextInt();
		int sum = 0;
		int i = 0;
		
		do{
			sum+=i;
			i++;
		}while(i <=n);
		System.out.println(sum);
	}
}
