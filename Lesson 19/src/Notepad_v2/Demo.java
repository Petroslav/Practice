package Notepad_v2;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		IOperationParams params; 
		INotepad note;
		
		System.out.println("What kind of note would you like to create?");
		System.out.println("1. Regular");
		System.out.println("2. Secured");
		int pick = sc.nextInt();
		System.out.println("How many pages would you like to have in your note?");
		int size = sc.nextInt();
		if(pick == 1) {
			note = new SimpleNotepad(size);
		}else {
			System.out.println("Pick a password for your note: ");
			sc.nextLine();
			String pass = sc.nextLine();
			note = new SecuredNotepad(size, pass);
		}
		
		int choice = -1;
		do{
			System.out.println("Please choose what to do: ");
			System.out.println("1. Write on a page");
			System.out.println("2. Write over a used page");
			System.out.println("3. Clear a page");
			System.out.println("4. Read the notepad");
			System.out.println("5: Search for a word");
			System.out.println("6: Print pages with digits");
			System.out.println("7: Close the notepad");
			choice = sc.nextInt();
			if(note instanceof SecuredNotepad){
				do{
					System.out.print("To continue, please input your password: ");
					sc.nextLine();
					params = new SecuredParams();
					((SecuredParams) params).setPass(sc.nextLine());
					if(((SecuredNotepad) note).checkPass(params)){
						System.out.println("Wrong password, please try again.");
					}
				}while(!((SecuredNotepad) note).checkPass(params));
				
			}else{
				params = new SimpleParams();
			}
			switch(choice){
			case 1:
				System.out.print("Page: ");
				params.setPage(sc.nextInt());
				System.out.print("Text: ");
				sc.nextLine();
				String text = sc.nextLine();
				params.setText(text);
				note.writeOnPage(params);
				break;

			case 2:
				System.out.print("Page: ");
				params.setPage(sc.nextInt());
				sc.nextLine();
				System.out.print("Text: ");
				text = sc.nextLine();
				params.setText(text);
				note.writeOverPage(params);
				break;
			case 3:
				System.out.print("Page: ");
				params.setPage(sc.nextInt());
				note.clearPage(params);
			case 4:
				note.readNotepad(params);
				break;
			case 5:
				System.out.print("Which word are you looking for? ");
				sc.nextLine();
				text = sc.nextLine();
				if(note.searchWord(params)) System.out.println("The word was found in your note");
				else System.out.println("The word does not exist in the note");
				break;
			case 6:
				note.printAllPagesWithDigits(params);
				System.out.println("These are all the pages that contain digits.");
				break;
			case 7:
				break;
			default:
				continue;
			}
		}while(choice != 7);

		
	}
}
