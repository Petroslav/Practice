package Notepad;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad{

	private String pass;
	
	public SecuredNotepad(int size, String pass) throws WeakPasswordException{
		super(size);
		this.pass = passStrength(pass);
	}
	
	public boolean checkPass(String pass){
		if(this.pass.equals(pass)) return true;
		return false;
	}
	
	public void changePassword(String oldPass, String newPass){
		if(checkPass(oldPass)) this.pass = newPass;
		else System.out.println("Wrong password");
	}
	
	private String passStrength(String pass)throws WeakPasswordException, ShortPasswordException{
		if(pass.length() < 5) throw new ShortPasswordException();
		boolean digits = false;
		boolean lowerCase = false;
		boolean upperCase = false;
		for (int i = 0; i < pass.length(); i++) {
			if(Character.isDigit(pass.charAt(i))) digits = true;
			if(Character.isUpperCase(pass.charAt(i))) upperCase = true;
			if(Character.isLowerCase(pass.charAt(i))) lowerCase = true;
		}
		if(!digits || !lowerCase || !upperCase) throw new WeakPasswordException();
		
		return pass;
	}
	
	
	

}
