import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String[] words = text.split(" ");
		int wrds = 0;
		int maxL = words[0].length();
		
		for (int i = 0; i < words.length; i++) {
			wrds++;
			if(words[i].length() > maxL){
				maxL = words[i].length();
			}
		}
		System.out.println(wrds+" words, longest one being "+maxL+" characters long.");
	}
}
