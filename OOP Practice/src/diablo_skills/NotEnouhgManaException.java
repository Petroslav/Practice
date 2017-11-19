package diablo_skills;

public class NotEnouhgManaException extends Exception {

	@Override
	public String getMessage() {
		return "Not enough mana!";
	}
}
