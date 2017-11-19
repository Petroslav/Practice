import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input text of no more than 40 characters in length");
		String text1 = sc.nextLine();
		System.out.println("Input more text of no more than 40 characters in length");
		String text2 = sc.nextLine();
		
		if(text1.length() > 40){
			text1 = text1.substring(0, 39);
		}
		if(text2.length() > 40){
			text2 = text2.substring(0, 39);
		}
		toUpperAndLowerCase(text1);
		toUpperAndLowerCase(text2);
		
	}
	
	static void toUpperAndLowerCase(String s){
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println();
	}
	
}
