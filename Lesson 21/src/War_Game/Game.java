package War_Game;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

	public static void main(String[] args) {
		ArrayList<Card> field = new ArrayList<Card>(); // creating a deck
		makeDeck(field); // filling the deck with cards to deal to the players;
		Collections.shuffle(field); // shuffling the deck;
		Player p1 = new Player("Strahil"); //creating players
		Player p2 = new Player("Pesho");
		Player winner = null;
	
		for (int i = 0; i < 52; i++) {  //dealing cards to the players
			if(i < 26) p2.getHand().add(field.get(i));
			else p1.getHand().add(field.get(i));
		}
		field.clear(); // creating a field for the cards to be played on
		System.out.println("=== " + p1.getName() + " =VS= " + p2.getName() + " ===");

		do{
			printRound(p1, p2, field);
			winner = winner(p1,p2); // determine the winner of the round
			if(winner == null){ // if no winner was determined we go into a war
				System.out.println("===WAR!===");
				p1.playCard();
				p2.playCard();
				war(p1, p2, winner, field);
				winner = null;
			}else{
				winner.takeCards(field); // if we have a winner he takes the cards
				p1.playCard();
				p2.playCard();
			}
		}while(!(end(p1, p2)));

		if(p1.getWon().size() == p2.getWon().size()) System.out.println("It's a tie! " + p1.getName() + " won " + p1.getHand().size() + " cards and " + p2.getName() + " won " + p2.getHand().size() + " cards");
		if(p1.getWon().size() > p2.getWon().size()) System.out.println(p1.getName() + " wins the game with " + p1.getWon().size() + " cards won vs " + p2.getWon().size() + " cards won by " + p2.getName());
		if(p1.getWon().size() < p2.getWon().size()) System.out.println(p2.getName() + " wins the game with " + p2.getWon().size() + " cards won vs " + p1.getWon().size() + " cards won by " + p1.getName());
		
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
		try{
			simpleRound(p1, p2, win, field);
			simpleRound(p1, p2, win, field);
		}
		catch(NoMoreCardsException e){
			System.out.println(e.getMessage());
		}
		if(end(p1, p2)){
			System.out.println("No more cards! War ends in a draw, the winner of the last round takes all the cards on the field.");
			if(win != null && field.size() > 0) win.takeCards(field);
			else field.clear();
			return;
		}
		win = null;
		roundOfWar(p1, p2, win, field);
	}
	public static void roundOfWar(Player p1, Player p2, Player win, ArrayList<Card> field){
		win = winner(p1, p2);
		printRound(p1, p2, field);
		p1.playCard();
		p2.playCard();
		if(win != null){
			System.out.println("Cards won: " + field);
			System.out.println();
			win.spoilsOfWar(field);
		}else{
			if(!end(p1,p2)) roundOfWar(p1, p2, win, field);
			else{
				System.out.println("No more cards!");
				return;
			}
		}
	}
	public static boolean end(Player p1, Player p2){
		if(p1.getHand().size() == 0 || p2.getHand().size() == 0) return true;
		else return false;
	}	
	public static Player winner(Player p1, Player p2){
		Player winner = null;
		if(p1.getNextCard().getPwr() > p2.getNextCard().getPwr()) winner = p1;
		if(p1.getNextCard().getPwr() < p2.getNextCard().getPwr()) winner = p2;
		return winner;
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
			if(win != null && field.size() > 0) win.takeCards(field);
			else field.clear();
			throw new NoMoreCardsException();
		}
		win = null;
		win = winner(p1, p2);
		printRound(p1, p2, field);
		p1.playCard();
		p2.playCard();
	}
}