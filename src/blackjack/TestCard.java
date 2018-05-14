package blackjack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCard {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConstructor() {
		Card card1 = new Card();
		assertNotNull(card1);
	}
	
	@Test
	public void testConstructorWithArgs() {
		Card card2 = new Card(Suit.CLUBS, "Jack");
		assertNotNull(card2);
	}
	
	@Test
	public void testGetCardValueFace() {
		Card card3 = new Card(Suit.DIAMONDS, "King");
		int expected = 10;
		int actual = card3.getValue();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetCardValueNum() {
		Card card4 = new Card(Suit.DIAMONDS, "5");
		int expected = 5;
		int actual = card4.getValue();
		
		assertEquals(expected, actual);
	}
}
