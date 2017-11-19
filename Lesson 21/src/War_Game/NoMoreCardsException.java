package War_Game;

public class NoMoreCardsException extends Exception{
	
	@Override
	public String getMessage() {
		return "No more cards!";
	}
}
