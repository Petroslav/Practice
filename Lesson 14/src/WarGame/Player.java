package WarGame;

public class Player {

	String name;
	Card[] hand;
	Card[] won;
	int cards;
	
	Player(String name){
		this.name = name;
		this.hand = new Card[26];
		this.won = new Card[52];
		this.cards = 0;
	}
	
	void takePot(Card c){
		for (int j = 0; j < this.won.length; j++) {
			if(this.won[j] == null){
				this.won[j] = c;
				break;
			}
		}
	}
	
	Card getCard(){
		Card nextCard = null;
		for (int i = 0; i < this.hand.length; i++) {
			if(this.hand[i] != null){
				nextCard = this.hand[i];
				break;
			}
		}
		return nextCard;
	}
	
	void removeCard(){
		for (int i = 0; i < this.hand.length; i++) {
			if(this.hand[i] != null){
				this.hand[i] = null;
				break;
			}
		}
	}
	
}
