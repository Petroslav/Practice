package library;

import reading_material.*;

public class LentBookChecker extends Thread{
	
	private ReadingMaterial book;
	private Library library;
	
	public LentBookChecker(ReadingMaterial book, Library library){
		this.book = book;
		this.library = library;
	}
	
	@Override
	public void run() {
		double rent = 0;
		int rentTime = 0;
		if(this.book instanceof Book){
			rent = Book.RENT_TAX;
			rentTime = Book.CHECKOUT_LENGTH;
		}
		else{
			rent = StudyBook.RENT_TAX;
			rentTime = StudyBook.CHECKOUT_LENGTH;
		}
		try {
			sleep(rentTime*1000);
		} catch (InterruptedException e) {
			return;
		}
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			return;
		}
		rent += (rent/100)*library.INTEREST;
		library.increaseTax(this.book.getName(), rent);		
	}
}
