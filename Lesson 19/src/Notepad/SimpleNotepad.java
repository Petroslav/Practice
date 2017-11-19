package Notepad;

public class SimpleNotepad implements INotepad{

	protected Page[] pages;
	
	public SimpleNotepad(int size){
		if(size > 0) this.pages = new Page[size];
		for (int i = 0; i < pages.length; i++) {
			pages[i] = new Page();
		}
	}
	
	@Override
	public void writeOnPage(int num, String text) {
		if(num-1 >= 0 && num-1 < this.pages.length){
			this.pages[num-1].write(text);
			this.pages[num-1].setHeadline("Page " + num);
		}
		
	}

	@Override
	public void writeOverPage(int num, String text) {
		if(num-1 >= 0 && num-1 < this.pages.length){
			this.pages[num-1].clearPage();
			this.pages[num-1].write(text);
		}
		
	}

	@Override
	public void clearPage(int num) {
		if(num-1 >= 0 && num-1 < this.pages.length) this.pages[num-1].clearPage();
	}

	@Override
	public void readNotepad() {
		for (int i = 0; i < this.pages.length; i++) {
			if(this.pages[i].getHeadline() != null) this.pages[i].viewPage();
		}
		
	}

	@Override
	public boolean searchWord(String word) {
		for (int i = 0; i < pages.length; i++) {
			if(pages[i].searchWord(word)) return true;
		}
		return false;
		
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < pages.length; i++) {
			if(pages[i].containsDigits()) {
				pages[i].viewPage();
				System.out.println();
				System.out.println();
			}
		}
		
	}

}
