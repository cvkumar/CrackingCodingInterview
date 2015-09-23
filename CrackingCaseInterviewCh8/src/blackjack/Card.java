package blackjack;

import blackjack.Deck.Suit;

public abstract class Card {
	private boolean available = true;

	protected int faceValue;
	protected Suit suit;

	public Card(int c, Suit s) {
		faceValue = c;
		suit = s;
	}

	public abstract int value();

	public Suit suit() {
		return suit;
	}

	public boolean isAvailable() {return available;}
	public void takeCard() {
		available = false;
	}
	
	public void giveCard() {
		available = true;
	}
	
}
