package diablo_skills;

public class AbilityNotReadyException extends Exception {
	
	@Override
	public String getMessage() {
		return "Ability not ready yet!";
	}
}
