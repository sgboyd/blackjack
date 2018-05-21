package blackjack;

public class Card {
	private Suit suit;
	private String name;
	private int value;
	
	public Card() {
		
	}
	
	public Card(Suit suit, String name) {
		this.suit = suit;
		this.name = name;
		setValue();
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue() {
		switch(getName()) {
			case "Ace": 
				this.value = 11;
				break;
			case "King":
			case "Queen":
			case "Jack":
			case "10":
				this.value = 10;
				break;
			default:
				this.value = new Integer(getName());
		}
	}
	
	
	
	
}
