package Notepad_v2;

public interface INotepad {
	
	void writeOnPage(IOperationParams params);
	
	void writeOverPage(IOperationParams params);

	void clearPage(IOperationParams params);
	
	void readNotepad(IOperationParams params);
	
	boolean searchWord(IOperationParams params);
	
	void printAllPagesWithDigits(IOperationParams params);
}
