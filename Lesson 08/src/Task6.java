import java.util.Scanner;

import javax.xml.soap.Text;

public class Task6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		System.out.println(firstLetterToUpperCase(text));
	}
	
	static String firstLetterToUpperCase(String s1){
		String[] words = s1.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append(" ");
		}
		
		return sb.toString().trim();
	}
}
