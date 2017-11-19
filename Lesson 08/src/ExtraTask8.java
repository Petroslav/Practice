import java.util.Scanner;

public class ExtraTask8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//input numbers as text
		String text = sc.nextLine();
		//clean everything but the numbers
		text = text.replaceAll("[^2-9]", "");
		System.out.println(text);
		int keypress = 1;
		//print a letter depending on the keypresses
		for (int i = 0; i < text.length()-1; i++) {
			if(text.charAt(i) != text.charAt(i+1)){
				printLetter(text.charAt(i), keypress);
				keypress = 1;
			}
			if(text.charAt(i) == text.charAt(i+1)){
				keypress++;
			}
			if(keypress == 3){
				printLetter(text.charAt(i), keypress-1);
				keypress = 1;
			}
			if(i == text.length()-1){
				printLetter(text.charAt(i-1), keypress);
				keypress = 1;
				if(text.charAt(i) != text.charAt(i+1)){
					printLetter(text.charAt(i+1), keypress);
				}
			}
		}
		int a = text.charAt(4);
		System.out.println(a);

	}
	
	static void printLetter(char a1, int keypress){
		char a = a1;
		int end = a;
		for (int i = 0; i < end-50; i++) {
			a+=3;
		}
		a+= keypress+14;
		System.out.print(a);
	}
}
