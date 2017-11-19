import java.util.Arrays;
import java.util.Scanner;

public class ExtraTask4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int[] letters = new int[26];
		text = text.toUpperCase();
		char[] ltrs = text.toCharArray();
		System.out.println(Arrays.toString(ltrs));
		for (int i = 0; i < ltrs.length; i++) {
			int ascii = ltrs[i];
			letters[ascii-65]++; 
		}
		for (int i = 0; i < letters.length; i++) {
			if(letters[i] != 0){
				char bukva = 0;
				bukva+=65+i;
				System.out.println(bukva+": "+letters[i]+" times");
			}
		}
	}
}
