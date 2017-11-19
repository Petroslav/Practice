package Notepad;

public interface IElectronicDevice extends ISecuredNotepad{

	void start();
	void stop();
	boolean isStarted();
}
