package blackjack;

public class HumanPlayer extends Player {

	private int balance = 100;
	
	public HumanPlayer() {
		super();
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
