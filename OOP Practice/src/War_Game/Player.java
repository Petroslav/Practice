package War_Game;

import java.util.ArrayList;

public class Player {

	private String name;
	private Card[] hand;
	private ArrayList<Card> won;
	
	String getName() {
		return name;
	}

	Player (String name){
		this.name = name;
		this.hand = new Card[26];
		this.won = new ArrayList<Card>(52);
	}
	
	void addToHand(Card c1){
		for (int i = 0; i < this.hand.length; i++) {
			if(this.hand[i] == null){
				this.hand[i] = c1;
				break;
			}
		}
	}
	
	Card[] getHand() {
		return hand;
	}

	void playCard(){
		for (int i = 0; i < this.hand.length; i++) {
			if(this.hand[i] != null){
				hand[i] = null;
				break;
			}
		}
	}
	
	Card getNextCard(){
		Card card = null;
		for (int i = 0; i < this.hand.length; i++) {
			if(this.hand[i] != null) return hand[i];	
		}
		return card;
	}
	
	int getPower(){
		return this.getNextCard().getPwr();
	}
	
	void takeCards(Card[] pot){
		System.out.println(this.getName() + " wins the round!");
		for (int i = 0; i < pot.length; i++) {
			if(pot[i] != null) {
				this.won.add(pot[i]);
				pot[i] = null;
			}
		}
	}
	
	void printHand(){
		for (int i = 0; i < this.getHand().length; i++) {
			if(this.hand[i] == null) continue;
			if(i == this.getHand().length-1 && this.hand[this.getHand().length-2] == null) System.out.println(this.getName()+"'s hand: ["+this.getHand()[i].getSuit()+"]");
			else{
				if(i == 0 || this.hand[i-1] == null) System.out.print(this.getName()+"'s hand: ["+this.getHand()[i].getSuit()+", ");
				if(i == this.getHand().length-1){
					System.out.print(this.getHand()[i].getSuit()+"]");
					System.out.println();
				}
				if(i > 0 && i < this.getHand().length-1 && this.getHand()[i-1] != null) System.out.print(this.getHand()[i].getSuit()+", ");
			}
		}
	}

	ArrayList<Card> getWon() {
		return won;
	}
	
	
}
