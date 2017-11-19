package war_game_v3;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

	public static void main(String[] args) {
		Player p1 = new Player("Strahil");							//creating players
		Player p2 = new Player("Pesho");
		Player winner = null;
		ArrayList<Card> field = new ArrayList<Card>(); 				// creating a deck
		makeDeck(field); 											// filling the deck with cards to deal to the players
		Collections.shuffle(field); 								// shuffling the deck
		dealCards(p1, p2, field);									// deal the cards
		
		System.out.println("=== " + p1.getName() + " =VS= " + p2.getName() + " ===");
		do{
			printRound(p1, p2, field); 								// visualize the round
			winner = winner(p1,p2); 								// determine the winner of the round
			if(winner == null){ 									// if no winner was determined we go into a war
				System.out.println("===WAR!===");
				war(p1, p2, winner, field);
			}else{
				winner.takeCards(field); // if we have a winner he takes the cards
				p1.playCard();
				p2.playCard();
			}
		}while(!(end(p1, p2)));

		if(p1.getWon().size() == p2.getWon().size()) System.out.println("It's a tie! " + p1.getName() + " won " + p1.getWon().size() + " cards and " + p2.getName() + " won " + p2.getWon().size() + " cards");
		if(p1.getWon().size() > p2.getWon().size()) System.out.println(p1.getName() + " wins the game with " + p1.getWon().size() + " cards won vs " + p2.getWon().size() + " cards won by " + p2.getName());
		if(p1.getWon().size() < p2.getWon().size()) System.out.println(p2.getName() + " wins the game with " + p2.getWon().size() + " cards won vs " + p1.getWon().size() + " cards won by " + p1.getName());
		
	}
	private static void dealCards(Player p1, Player p2, ArrayList<Card> field) {		
		for (int i = 0; i < 52; i++) {
			if(i < 26) p2.getHand().add(field.get(i));
			else p1.getHand().add(field.get(i));
		}
		field.clear();			
	}
	public static void makeDeck(ArrayList<Card> deck){
		String[] pwr = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		char[] suit = {'\u2660', '\u2665', '\u2666', '\u2663'};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < pwr.length; j++) {
				deck.add(new Card(j+2, pwr[j]+suit[i]));
			}
		}
	}
	public static void war(Player p1, Player p2, Player win, ArrayList<Card> field){
		p1.playCard();
		p2.playCard();
		try{
			simpleRound(p1, p2, win, field);
			simpleRound(p1, p2, win, field);
			roundOfWar(p1, p2, win, field);
		}
		catch(NoMoreCardsException e){
			System.out.println(e.getMessage());
		}
	}
	public static void roundOfWar(Player p1, Player p2, Player win, ArrayList<Card> field) throws NoMoreCardsException {
		if(end(p1, p2)){
			try{
				win.takeCards(field);
				return;
			}
			catch(NullPointerException e){
				throw new NoMoreCardsException();
			}
		}
		win = winner(p1, p2);
		printRound(p1, p2, field);
		p1.playCard();
		p2.playCard();
		if(win == null){
			if(!end(p1,p2)) roundOfWar(p1, p2, win, field);
			else{
				throw new NoMoreCardsException();
			}
		}
		else{
			System.out.println("Cards won: " + field);
			System.out.println();
			win.spoilsOfWar(field);
		}
	}
	public static boolean end(Player p1, Player p2){
		if(p1.getHand().size() == 0 || p2.getHand().size() == 0) return true;
		else return false;
	}	
	public static Player winner(Player p1, Player p2){
		if(p1.getNextCard().getPwr() > p2.getNextCard().getPwr()) return p1;
		if(p1.getNextCard().getPwr() < p2.getNextCard().getPwr()) return p2;
		return null;
	}	
	public static void printRound(Player p1, Player p2, ArrayList<Card> field){
		p1.printHand(); 
		p2.printHand();
		System.out.println(p1.getNextCard().toString() + " VS " + p2.getNextCard().toString());
		field.add(p1.getNextCard());
		field.add(p2.getNextCard());
	}
	
	public static void simpleRound(Player p1, Player p2, Player win, ArrayList<Card> field) throws NoMoreCardsException {
		if(end(p1, p2)){
			try{
				win.takeCards(field);
			}
			catch(NullPointerException e){
				throw new NoMoreCardsException();
			}
			throw new NoMoreCardsException();
		}
		win = winner(p1, p2);
		printRound(p1, p2, field);
		p1.playCard();
		p2.playCard();
	}
}