package Notepad;

public interface INotepad {
	
	void writeOnPage(int num, String text);
	
	void writeOverPage(int num, String text);

	void clearPage(int num);
	
	void readNotepad();
	
	boolean searchWord(String word);
	
	void printAllPagesWithDigits();
}
