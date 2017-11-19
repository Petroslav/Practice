import java.util.Arrays;
import java.util.Scanner;

public class ExtraTask11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		char attempt;
		int attempts = 5;
		int lettersRemaining = word.length();
		boolean win = false;
		boolean guess = false;
		char[] view = new char[word.length()];
		char[] hangman = word.toCharArray();
		for (int i = 0; i < view.length; i++) {
			view[i] = '_';
		}
		System.out.println("Your word has "+view.length+" letters. Please guess a letter");
		System.out.println(Arrays.toString(view));
		
		do{
			guess = false;
			attempt = sc.next().charAt(0);
			for (int i = 0; i < hangman.length; i++) {
				if(hangman[i] == attempt){
					if(view[i] == attempt){
						System.out.println("Oops, you already guessed that letter!");
						guess = true;
						continue;
					}else{
						view[i] = attempt;
						lettersRemaining--;
						guess = true;
					}
					
				}
			}
			if(!guess){
				System.out.println("Wrong letter!");
				System.out.println("Attempts remaining: "+(--attempts));
			}else{
				System.out.println("Correct letter!");
				System.out.println("Attempts: "+attempts+"; "+"Letters remaining: "+lettersRemaining);
				System.out.println(Arrays.toString(view));
			}
			if(lettersRemaining == 0){
				win = true;
				break;
			}
		}while(attempts > 0);
		
		if(win){
			System.out.println("Congratulations! You win!");
			System.out.println("You guessed the word "+word);
		}else{
			System.out.println("Sorry, try again next time! The word was: ");
			System.out.println(word);
		}
	}
}
