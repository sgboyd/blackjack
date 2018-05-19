package blackjack;

public class HumanPlayer extends Player {

	private int balance;
	
	public HumanPlayer(String playerName) {
		super(playerName);
	}
	
	
	@Override
	public Card hit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stick() {
		// TODO Auto-generated method stub

	}

	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

}
