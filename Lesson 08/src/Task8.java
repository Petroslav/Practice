import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		boolean anagram = false;
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i) != text.charAt(text.length()-1-i)){
				anagram = false;
				break;
			}else{
				anagram = true;
			}
		}
		System.out.println(anagram? "Yes." : "No.");
	}
}
