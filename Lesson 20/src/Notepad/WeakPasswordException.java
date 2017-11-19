package Notepad;

public class WeakPasswordException extends Exception{
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Password too weak";
		
	}

}
