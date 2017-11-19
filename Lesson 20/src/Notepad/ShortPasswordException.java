package Notepad;

public class ShortPasswordException extends WeakPasswordException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Password too short";
	}
}
