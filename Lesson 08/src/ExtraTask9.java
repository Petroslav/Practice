import java.util.Scanner;

public class ExtraTask9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			sb = sb.append(i);
		}
		
		System.out.println(sb.toString());
	}
}
