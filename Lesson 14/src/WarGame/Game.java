package WarGame;

import java.util.Random;

public class Game {

	public static void main(String[] args) {
		Player p1 = new Player("Johnny");
		Player p2 = new Player("Marcel");
		Card[] deck = new Card[52];
		Card[] warDeck = new Card[52];
		makeDeck(deck);
		dealCards(p1, p2, deck);
		boolean gameEnd = false;
		System.out.println(p1.name+" VS "+p2.name);
		while(!(gameEnd)){
			if(p1.getCard() == null){
				break;
			}
			if(compareCards(p1.getCard().pwr, p2.getCard().pwr) == 1){	
				System.out.println(p1.getCard().suit + " VS " + p2.getCard().suit);
				System.out.println(p1.name+" wins the round");
				p1.takePot(p2.getCard());
				p1.takePot(p1.getCard());
				p1.removeCard();
				p2.removeCard();
				p1.cards+=2;
			
			}
			if(compareCards(p1.getCard().pwr, p2.getCard().pwr) == -1){
				System.out.println(p1.getCard().suit + " VS " + p2.getCard().suit);
				System.out.println(p2.name+" wins the round");
				p2.takePot(p1.getCard());
				p2.takePot(p2.getCard());
				p2.removeCard();
				p1.removeCard();
				p2.cards+=2;
			
			}
			if(p1.getCard() != null && compareCards(p1.getCard().pwr, p2.getCard().pwr) == 0){
				System.out.println(p1.getCard().suit + " VS " + p2.getCard().suit);
				System.out.println("===WAR===");
				for (int i = 0; i <= 4; i+=2) {
					if(p1.getCard() == null){
						System.out.println("Not enough cards");
						gameEnd = true;
						break;
					}
					warDeck[i] = p1.getCard();
					p1.removeCard();
					warDeck[i+1] = p2.getCard();
					p2.removeCard();
					System.out.println(p1.getCard().suit + " VS " + p2.getCard().suit);
					
				}
				while(p1.getCard() != null && compareCards(p1.getCard().pwr, p2.getCard().pwr) == 0){
					for (int i = 0; i < warDeck.length; i+=2) {
						if(warDeck[i] == null){
							warDeck[i] = p1.getCard();
							p1.removeCard();
							warDeck[i+1] = p2.getCard();
							p2.removeCard();
							System.out.println(p1.getCard().suit + " VS " + p2.getCard().suit);
						}
					}
				}
				if(compareCards(p1.getCard().pwr, p2.getCard().pwr) == 1){
					System.out.println(p1.name + " wins the war");
					p1.removeCard();
					p2.removeCard();
					for (int i = 0; i < warDeck.length; i++) {
						p1.takePot(warDeck[i]);
						p1.cards++;
					}
				}else{
					System.out.println(p2.name + " wins the war");
					p1.removeCard();
					p2.removeCard();
					for (int i = 0; i < warDeck.length; i++) {
						p2.takePot(warDeck[i]);
						p2.cards++;
					}
				}
				warDeck = new Card[52];
			}
			if(gameEnd) break;
		}
		
		System.out.println();
		System.out.println("===WINNER===");
		System.out.println(p1.cards > p2.cards ? p1.name + " wins the game!" : p2.name + " wins the game!");

	}
	
	static void makeDeck(Card[] deck){
		int pwr = 2;
		int suit = 0;
		for (int i = 0; i < deck.length; i++) {
			if(pwr <= 10){
				deck[i] = new Card(pwr, (pwr+getSuit(suit)));
			}else{
				deck[i] = new Card(pwr, (getPwr(pwr)+getSuit(suit)));
			}
			if(suit < 4){
				suit++;
			}
			if(suit ==4){
				pwr++;
				suit = 0;
			}
		}
	}
	
	static void shuffleDeck(Card[] deck){
		int index;
		Random r = new Random(52);
		for (int i = 0; i < deck.length; i++) {
			index = r.nextInt(52);
			Card temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
	}
	
	static void dealCards(Player p1, Player p2, Card[] deck){
		int index = 0;
		for (int i = 0; i < deck.length; i++) {
			if(i%2==0){
				p1.hand[index] = deck[i];
			}else{
				p2.hand[index] = deck[i];
				index++;
			}
		}
	}
	
	static String getSuit(int num){
		switch(num){
		case 0: return "\u2660";
		case 1: return "\u2665";
		case 2: return "\u2666";
		case 3: return "\u2663";
		default: return "BOOM";
		}
	}

	static String getPwr(int num){
		switch(num){
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		case 14: return "A";
		default: return "?";
		}
	}
	
	static int compareCards(int pwr, int pwr2){
		if(pwr > pwr2) return -1;
		if(pwr < pwr2) return 1;
		else{
			return 0;
		}
	}
	
	static void addToPot(Card[] pot, Card c1){
		for (int i = 0; i < pot.length; i++) {
			if(pot[i] == null){
				pot[i] = c1;
				break;
			}
		}
	}
}