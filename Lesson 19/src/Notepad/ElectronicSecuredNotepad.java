package Notepad;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {

	private boolean power;
	
	public ElectronicSecuredNotepad(int size, String pass) {
		super(size, pass);
	}

	@Override
	public void start() {
		this.power = true;
		
	}

	@Override
	public void stop() {
		this.power = false;
		
	}

	@Override
	public boolean isStarted() {
		return this.power;
	}

}
