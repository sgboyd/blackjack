package blackjack;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		// create deck
		Deck myDeck = new Deck();
		
		// shuffle deck
		myDeck.shuffle();
		
		for(int loop = 0; loop < myDeck.deck.size(); loop++) {
			System.out.println(myDeck.deck.get(loop).getName() + " of " + myDeck.deck.get(loop).getSuit());
		}
		
		
		// create players
		Dealer dealer = new Dealer();
		
		// get human player name
		System.out.println("Please enter your name");
		Scanner scanner = new Scanner(System.in);
		String playerName = scanner.next();
		
		// create human player
		HumanPlayer hp = new HumanPlayer(playerName);
		
		// greeting
		System.out.println("Welcome to Blackjack, " + hp.getName());
		
		// deal starting cards
		for(int loop = 0; loop < 4; loop++) {
			if(loop % 2 == 0) {
				myDeck.deal(hp);
			} else {
				myDeck.deal(dealer);
			}
		}
		
		// Show dealer's first card
		System.out.println("----------");
		System.out.println("Dealer has " + dealer.getHand().get(0).getName() + " of " + dealer.getHand().get(0).getSuit());
		System.out.println("Value: " + dealer.getHand().get(0).getValue());
		System.out.println("----------");
		
		// Show player's hand
		System.out.println("----------");
		System.out.println("Your hand: ");
		int handValue = 0;
		for(int loop = 0; loop < hp.getHand().size(); loop++) {
			System.out.println(hp.getHand().get(loop).getName() + " of " + hp.getHand().get(loop).getSuit());
			handValue += hp.getHand().get(loop).getValue();
		}
		System.out.println("Hand value: " + handValue);
		System.out.println("----------");
		
		// ask player to hit or stick
	
		String userChoice = "";
		
		System.out.println("Would you like to hit or stick?");
		System.out.println("Enter h for hit, s for stick");
		
		userChoice = scanner.next();
		
		if(userChoice == "h") {
			myDeck.deal(hp);
		} else if(userChoice == "s") {
			
			// show dealer hand
			int dealerFinalHand = 0;
			for(int loop = 0; loop < dealer.getHand().size(); loop++) {
				System.out.println(dealer.getHand().get(loop).getName() + " of " + dealer.getHand().get(loop).getSuit());
				dealerFinalHand += dealer.getHand().get(loop).getValue();
			}
			System.out.println("Hand value: " + dealerFinalHand);
			
			// show player hand
			int playerFinalHand = 0;
			for(int loop = 0; loop < hp.getHand().size(); loop++) {
				System.out.println(hp.getHand().get(loop).getName() + " of " + hp.getHand().get(loop).getSuit());
				playerFinalHand += hp.getHand().get(loop).getValue();
			}
			System.out.println("Hand value: " + playerFinalHand);
			
			// decide winner
			if(dealerFinalHand > 21 && playerFinalHand > 21) {
				System.out.println("You are both bust");
			} else if(dealerFinalHand > 21) {
				System.out.println("You win, " + hp.getName() + "!");
			} else if(playerFinalHand > 21 && dealerFinalHand < 21) {
				System.out.println("You lost, " + hp.getName() + ". Dealer wins!");
			} else {
				if(playerFinalHand > dealerFinalHand) {
					System.out.println("You win, " + hp.getName() + "!");
				} else if(dealerFinalHand > playerFinalHand) {
					System.out.println("You lost, " + hp.getName() + ". Dealer wins!");
				} else {
					System.out.println("It's a draw. Stake returned.");
				}
			}
			
		}
		
		
		
		
		
		
		
		
	}

}
