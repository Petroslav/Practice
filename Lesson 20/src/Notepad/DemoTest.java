package Notepad;

import java.util.Scanner;

public class DemoTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pages = sc.nextInt();
		sc.nextLine();
		String pass = sc.nextLine();
		System.out.println(pass);
		SecuredNotepad note = null;
		while(true){
			try{
				note = new SecuredNotepad(pages, pass);
				break;
			}
			catch(ShortPasswordException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				pass = sc.nextLine();
			}
			catch(WeakPasswordException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				pass = sc.nextLine();
			}
		}
		note.writeOnPage(1, sc.nextLine());
		note.readNotepad();
		sc.close();
	}
}
