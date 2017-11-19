import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("N:");
		int n = sc.nextInt();
		System.out.println("M:");
		int m = sc.nextInt();
		
		if(n < 10 || m < 10 || m > 5555 || n > 5555){
			System.out.println("no");
			return;
		}
		int temp = n;
		if( n < m){
			n = m;
			m = temp;
		}
		for (int i = n; i >= m; i--) {
			if(i%50 == 0){
				System.out.print(i);
				
				if(i-50 < m){
					System.out.print(".");
				}else{
					System.out.print(", ");
				}
			}
			
		}
	}
}
