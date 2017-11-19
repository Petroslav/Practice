package war_game_v3;

public class NoMoreCardsException extends Exception{
	
	@Override
	public String getMessage() {
		return "No more cards!";
	}
}
