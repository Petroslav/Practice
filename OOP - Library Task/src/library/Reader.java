package library;

import exceptions.CannotBeLentException;
import reading_material.*;

public class Reader {
	public static Library library;
	private String name;
	private ReadingMaterial rented;
	
	public void rentBook(){
		try {
			this.rented = library.rentBook();
		} catch (CannotBeLentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void returnBook(){
		library.returnBook(this.rented);
	}
	
}
