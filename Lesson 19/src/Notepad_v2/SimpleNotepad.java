package Notepad_v2;

public class SimpleNotepad implements INotepad{

	protected Page[] pages;
	
	public SimpleNotepad(int size){
		if(size > 0) this.pages = new Page[size];
		for (int i = 0; i < pages.length; i++) {
			pages[i] = new Page();
		}
	}
	
	@Override
	public void writeOnPage(IOperationParams params) {
		SimpleParams param = (SimpleParams) params;
		if(param.getPage()-1 >= 0 && param.getPage()-1 < this.pages.length){
			this.pages[param.getPage()-1].write(param.getText());
			this.pages[param.getPage()-1].setHeadline("Page " + param.getPage());
		}
		
	}

	@Override
	public void writeOverPage(IOperationParams params) {
		SimpleParams param = (SimpleParams) params;
		if(param.getPage()-1 >= 0 && param.getPage()-1 < this.pages.length){
			this.pages[param.getPage()-1].clearPage();
			this.pages[param.getPage()-1].write(param.getText());
		}
		
	}

	@Override
	public void clearPage(IOperationParams params) {
		SimpleParams param = (SimpleParams) params;
		if(param.getPage()-1 >= 0 && param.getPage()-1 < this.pages.length) this.pages[param.getPage()-1].clearPage();
	}

	@Override
	public void readNotepad(IOperationParams params) {
		for (int i = 0; i < this.pages.length; i++) {
			if(this.pages[i].getHeadline() != null) this.pages[i].viewPage();
		}
		
	}

	@Override
	public boolean searchWord(IOperationParams params) {
		SimpleParams param = (SimpleParams) params;
		for (int i = 0; i < pages.length; i++) {
			if(pages[i].searchWord(param.getWord())) return true;
		}
		return false;
		
	}

	@Override
	public void printAllPagesWithDigits(IOperationParams params) {
		for (int i = 0; i < pages.length; i++) {
			if(pages[i].containsDigits()) {
				pages[i].viewPage();
				System.out.println();
				System.out.println();
			}
		}
		
	}

}
