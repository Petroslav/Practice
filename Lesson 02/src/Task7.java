import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a number");
		int n = sc.nextInt();
		int dNum = 0;
		for (int i = 0; i < n; i++) { 
			if(i == n-1){
				System.out.print((dNum+=3)+";");
			}else{
				System.out.print((dNum+=3)+", ");
			}
		}
	}
}
