package WarGame;

public class Card {

	int pwr;
	String suit;
	
	public int getPwr() {
		return pwr;
	}

	public void setPwr(int pwr) {
		this.pwr = pwr;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	Card(int pwr, String suit){
		this.setPwr(pwr);
		this.setSuit(suit);
	}
}
