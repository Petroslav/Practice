import java.util.Scanner;

public class ExtraTask10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m;
		do{	
			m = sc.nextInt();
		}while(m > n && m < 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			sb = sb.append(i);
			if(m == i){
				System.out.println("Index num is: "+m);
			}
		}

		System.out.println(sb.toString());
	}
}
