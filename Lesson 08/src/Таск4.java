import java.util.Scanner;

public class Таск4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input two full names separated by a coma");
		String s1 = sc.nextLine();
		String[] names = s1.split(",");
		System.out.println(checkCodeSum(names[0]) > checkCodeSum(names[1]) ? names[0] : names[1]);
	}
	
	static int checkCodeSum(String s){
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum+=s.charAt(i);
		}
		return sum;
	}
}
