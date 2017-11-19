import java.util.Scanner;

public class ExtraTask6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] symbols = new char[n];
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = sc.next().charAt(0);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < symbols.length; i++) {
			sb = sb.append(symbols[i]);
		}
		System.out.println(sb.toString());
	}
}
