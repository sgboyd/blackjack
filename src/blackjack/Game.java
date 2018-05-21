package blackjack;

import java.util.Scanner;

public class Game {

	// create deck
	protected static Deck myDeck = new Deck();

	// create players
	protected static Dealer dealer = new Dealer();
	public static HumanPlayer hp = new HumanPlayer();

	// boolean condition for hand loop
	public static boolean handOver = false;

	// boolean condition for game loop
	public static boolean bankrupt = false;

	public static void main(String[] args) {

		// shuffle deck
		myDeck.shuffle();

		for (int loop = 0; loop < myDeck.deck.size(); loop++) {
			System.out.println(myDeck.deck.get(loop).getName() + " of " + myDeck.deck.get(loop).getSuit());
		}

		// get human player name
		System.out.println("Please enter your name");
		Scanner scanner = new Scanner(System.in);
		String playerName = scanner.next();

		// set human player name
		hp.setName(playerName);

		// greeting
		System.out.println("Welcome to Blackjack, " + hp.getName());

		while (!bankrupt) {
			
			// shuffle deck
			myDeck.shuffle();
			
			// deal starting cards
			for (int loop = 0; loop < 4; loop++) {
				if (loop % 2 == 0) {
					myDeck.deal(hp);
				} else {
					myDeck.deal(dealer);
				}
			}

			while (!handOver) {

				// Show dealer's first card
				System.out.println("----------");
				System.out.println(
						"Dealer has " + dealer.getHand().get(0).getName() + " of " + dealer.getHand().get(0).getSuit());
				System.out.println("Value: " + dealer.getHand().get(0).getValue());
				System.out.println("----------");

				// Show player's hand
				System.out.println("----------");
				System.out.println("Your hand: ");

				for (int loop = 0; loop < hp.getHand().size(); loop++) {
					System.out.println(hp.getHand().get(loop).getName() + " of " + hp.getHand().get(loop).getSuit());
				}

				hp.setHandValue();
				System.out.println("Hand value: " + hp.getHandValue());
				System.out.println("----------");

				// ask player to hit or stick

				String userChoice = "";

				System.out.println("Would you like to hit or stick?");
				System.out.println("Enter h for hit, s for stick");

				userChoice = scanner.next();

				if (userChoice.equalsIgnoreCase("h")) {
					// get another card
					myDeck.deal(hp);
					hp.setHandValue();

					System.out.println("----------");
					System.out.println("Your hand:");
					for (int loop = 0; loop < hp.getHand().size(); loop++) {
						System.out
								.println(hp.getHand().get(loop).getName() + " of " + hp.getHand().get(loop).getSuit());
					}

					hp.setHandValue();
					System.out.println("Hand value: " + hp.getHandValue());

					System.out.println("----------");

					// check if bust
					checkBust(hp.getHandValue());

				} else if (userChoice.equalsIgnoreCase("s")) {

					// show dealer hand
					System.out.println("----------");
					System.out.println("Dealer's hand:");
					for (int loop = 0; loop < dealer.getHand().size(); loop++) {
						System.out.println(
								dealer.getHand().get(loop).getName() + " of " + dealer.getHand().get(loop).getSuit());
					}

					dealer.setHandValue();
					System.out.println("Hand value: " + dealer.getHandValue());

					// show player hand
					System.out.println("----------");
					System.out.println("Your hand:");
					for (int loop = 0; loop < hp.getHand().size(); loop++) {
						System.out
								.println(hp.getHand().get(loop).getName() + " of " + hp.getHand().get(loop).getSuit());
					}

					hp.setHandValue();
					System.out.println("Hand value: " + hp.getHandValue());

					System.out.println("----------");
					checkWinner(dealer.getHandValue(), hp.getHandValue());
				} else {
					return;
				}
			}
			
			// check if player bankrupt
			bankrupt();
			
			// reset handOver
			handOver = false;
			
			// put cards back into deck
			myDeck.deck.addAll(dealer.getHand());
			myDeck.deck.addAll(hp.getHand());
			
			
			// clear hands from players
			dealer.getHand().clear();
			hp.getHand().clear();
			
		}

	}

	/**
	 * Method to check winner of hand once player has decided to stick
	 * 
	 * @param dealerFinalHand
	 * @param playerFinalHand
	 */
	public static void checkWinner(int dealerFinalHand, int playerFinalHand) {
		// decide winner
		if (dealerFinalHand > 21 && playerFinalHand > 21) {
			System.out.println("You are both bust");
		} else if (dealerFinalHand > 21) {
			System.out.println("You win, " + hp.getName() + "!");
		} else if (playerFinalHand > 21 && dealerFinalHand < 21) {
			System.out.println("You lost, " + hp.getName() + ". Dealer wins!");
		} else {
			if (playerFinalHand > dealerFinalHand) {
				System.out.println("You win, " + hp.getName() + "!");
			} else if (dealerFinalHand > playerFinalHand) {
				System.out.println("You lost, " + hp.getName() + ". Dealer wins!");
			} else {
				System.out.println("It's a draw. Stake returned.");
			}
		}

		handOver();
	}

	/**
	 * Method to check if player is bust after player hits
	 * 
	 * @param playerCurrentHand
	 */
	public static void checkBust(int playerCurrentHand) {
		if (playerCurrentHand > 21) {
			System.out.println("Sorry, you are bust");
			handOver();
		}

	}

	/**
	 * Method to determine the hand is over and break the hand game loop
	 * 
	 * @return
	 */
	public static boolean handOver() {
		return handOver = true;
	}

	public static boolean bankrupt() {
		if(hp.getBalance() <= 0) {
			return bankrupt = true;
		} else {
			return bankrupt = false;
		}
		
		
	}
}
