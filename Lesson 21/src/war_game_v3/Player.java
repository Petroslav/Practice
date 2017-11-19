package war_game_v3;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Card> hand;
	private ArrayList<Card> won;

	Player (String name){
		this.name = name;
		this.hand = new ArrayList<Card>();
		this.won = new ArrayList<Card>();
	}
	
	String getName() {
		return name;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	void playCard(){
		if(hand.size() > 0) this.hand.remove(0);
	}
	
	Card getNextCard(){
		return hand.get(0);
	}
	
	int getPower(){
		return this.getNextCard().getPwr();
	}
	
	void takeCards(ArrayList<Card> pot){
		System.out.println(this.getName() + " wins the round!");
		System.out.println();
		this.won.addAll(pot);
		pot.clear();
	}

	void spoilsOfWar(ArrayList<Card> pot){
		System.out.println(this.getName() + " wins the war!");
		System.out.println();
		this.won.addAll(pot);
		pot.clear();
	}
	
	void printHand(){
		System.out.println(this.name + "'s hand: " + this.hand);
	}

	ArrayList<Card> getWon() {
		return won;
	}
	
	
}
