package Notepad_v2;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad{

	private String pass;
	
	public SecuredNotepad(int size, String pass) {
		super(size);
		this.pass = pass;
	}
	
	public boolean checkPass(IOperationParams params){
		SecuredParams param = (SecuredParams) params;
		if(this.pass.equals(param.getPass())) return true;
		return false;
	}

	@Override
	public void writeOnPage(IOperationParams params) {
		if(checkPass(params)) super.writeOnPage(params);
	}

	@Override
	public void writeOverPage(IOperationParams params) {
		if(checkPass(params)) super.writeOverPage(params);
	}

	@Override
	public void clearPage(IOperationParams params) {
		if(checkPass(params)) super.clearPage(params);
	}

	@Override
	public void readNotepad(IOperationParams params) {
		if(checkPass(params)) super.readNotepad(params);
	}

	@Override
	public boolean searchWord(IOperationParams params) {
		if(checkPass(params)) return super.searchWord(params);
		else{
			System.out.println("Wrong password");
			return false;
		}
	}

	@Override
	public void printAllPagesWithDigits(IOperationParams params) {

		if(checkPass(params)) super.printAllPagesWithDigits(params);
	}
	
	
}
