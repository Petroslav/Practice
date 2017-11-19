package War_Game;

public class Card {

	private int pwr;
	private String suit;

	Card(int pwr, String suit){
		this.setPwr(pwr);
		this.setSuit(suit);
	}
	
	public int getPwr() {
		return pwr;
	}

	public void setPwr(int pwr) {
		this.pwr = pwr;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return suit;
	}
}
