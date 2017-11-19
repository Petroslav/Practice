import java.util.Scanner;

public class ExtraTask2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String[] initials = name.split(" ");
		for (int i = 0; i < initials.length; i++) {
			System.out.print(initials[i].toUpperCase().charAt(0)+" ");
		}
	}
}
