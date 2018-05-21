package blackjack;

import java.util.ArrayList;

public abstract class Player {
	
	private String name;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue; 
	
	public Player() {
		
	}
	
	public Player(String name) {
		this.name = name;
	}

	public abstract Card hit();
	
	public abstract void stick();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(Card card) {
		this.hand.add(card);
	}

	public int getHandValue() {
		return handValue;
	}

	public void setHandValue() {
		int hv = 0;
		for(Card card: hand) {
			hv += card.getValue();
		}
		this.handValue = hv;
	}
	
	
}
