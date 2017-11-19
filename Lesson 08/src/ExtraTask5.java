import java.util.Scanner;

public class ExtraTask5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String text2 = sc.nextLine();
		
		int[] letters = new int[26];
		text = text.toUpperCase();
		
		int[] letters2 = new int[26];
		text2 = text2.toUpperCase();
		
		char[] ltrs = text.toCharArray();
		char[] ltrs2 = text2.toCharArray();
		
		for (int i = 0; i < ltrs.length; i++) {
			int ascii = ltrs[i];
			letters[ascii-65]++; 
		}
		
		for (int i = 0; i < ltrs2.length; i++) {
			int ascii = ltrs2[i];
			letters2[ascii-65]++; 
		}
		
		boolean anagram = false;
		
		for (int i = 0; i < letters.length; i++) {
			if(letters[i] == letters2[i]){
				anagram = true;
			}else{
				anagram = false;
			}
		}
		System.out.println(anagram ? "Yes" : "No");
	}
}
