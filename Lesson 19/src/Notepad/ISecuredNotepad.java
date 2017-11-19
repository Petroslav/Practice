package Notepad;

public interface ISecuredNotepad extends INotepad {

	public boolean checkPass(String pass);
	
	public void changePassword(String oldPass, String newPass);
}
