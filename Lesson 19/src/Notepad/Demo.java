package Notepad;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		INotepad note = null;
		int choice = -1;
		int page = 0;
		String text = null;
		
		System.out.println("What kind of note would you like to create?");
		System.out.println("1. Regular");
		System.out.println("2. Secured");
		System.out.println("3. Electronic, secured");
		int pick = sc.nextInt();
		System.out.println("How many pages would you like to have in your note?");
		page = sc.nextInt();
		String pass = null;
		switch(pick){
		case 1:
			note = new SimpleNotepad(page);
			break;
		case 2:
			sc.nextLine();
			System.out.println("Please input a password for your note");
			pass = sc.nextLine();
			note = new SecuredNotepad(page, pass);
			break;
		case 3:
			sc.nextLine();
			System.out.println("Please input a password for your note");
			pass = sc.nextLine();
			note = new ElectronicSecuredNotepad(page, pass);
			break;
			
		}
		
		do{
			if(note instanceof IElectronicDevice){
				if(!((IElectronicDevice) note).isStarted()){
					System.out.println("To start working you have to turn the device ON");
					System.out.println("Y / N?");
					String decision;
					do{
						sc.nextLine();
						decision = sc.nextLine();
						if(Character.toUpperCase(decision.charAt(0)) == 'Y') ((IElectronicDevice) note).start();
						if(Character.toUpperCase(decision.charAt(0)) == 'N'){
							System.out.println("You can't use the device unless it's turned on.");
						}else{
							System.out.println("Please input Y or N");
						}
					}while((Character.toUpperCase(decision.charAt(0))) != 'Y' || (Character.toUpperCase(decision.charAt(0))) != 'N');
					if(!((IElectronicDevice) note).isStarted()){
						System.out.println("Terminating current action...");
						break;
					}
				}
			}
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
				System.out.print("To continue, please input your password: ");
				sc.nextLine();
				pass = sc.nextLine();
				while(!((SecuredNotepad) note).checkPass(pass)){
					System.out.println("Wrong password");
					pass = sc.nextLine();
				}
			}
			switch(choice){
			case 1:
				System.out.print("Page: ");
				page = sc.nextInt();
				sc.nextLine();
				System.out.print("Text: ");
				text = sc.nextLine();
				note.writeOnPage(page, text);
				break;

			case 2:
				System.out.print("Page: ");
				page = sc.nextInt();
				sc.nextLine();
				System.out.print("Text: ");
				text = sc.nextLine();
				note.writeOverPage(page, text);
				break;
			case 3:
				System.out.print("Page: ");
				page = sc.nextInt();
				note.clearPage(page);
			case 4:
				note.readNotepad();
				break;
			case 5:
				System.out.print("Which word are you looking for? ");
				sc.nextLine();
				text = sc.nextLine();
				if(note.searchWord(text)) System.out.println("The word was found in your note");
				break;
			case 6:
				note.printAllPagesWithDigits();
				System.out.println("These are all the pages that contain digits.");
				break;
			case 7:
				break;
			default:
				continue;
			}
		}while(choice != 5);

		
	}
}
