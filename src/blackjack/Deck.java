package blackjack;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
	
	// linked list to hold the cards in the deck
	LinkedList<Card> deck = new LinkedList<Card>();
	int cardID = 0;

	String[] cardNums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	
	// constructor for deck
	public Deck() {
		for(Suit suit: Suit.values()) {
			for(int loop = 0; loop < cardNums.length; loop++) {
				
				Card c = new Card(suit, cardNums[loop]);
				
				deck.add(c);

			}
		}
	}
	
	// method to shuffle the deck
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	// method to deal the starting cards to the dealer and the player
	public void deal(Player player) {
		
		player.setHand(deck.poll());
	}

	
}
