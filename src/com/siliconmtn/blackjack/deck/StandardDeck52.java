package com.siliconmtn.blackjack.deck;

import java.util.Iterator;
import java.util.List;

public class StandardDeck52 extends Deck {

	public List<Card> gDeck = this.gameDeck;
	public List<Card> inplayDeck = this.activePile;
	/**
	 * Class constructor
	 */
	public StandardDeck52() {
		this.buildDeck();
		
	}
	
	/**
	 *  that builds deck
	 * 
	 * @return
	 */
	public List<Card> buildDeck() {
		for (Iterator<Integer> iter = Suit.getSuits().keySet().iterator(); iter
				.hasNext();) {
			Suit s = new Suit(iter.next());
			for (int i = 1; i < 14; i++) {
				Card card = new Card(s, i, determineLabel(i), determineLow(i), 
						determineHigh(i));
				gDeck.add(card);
			}
		}
		return gDeck;
	}

	/**
	 * gets the low value for the card
	 * 
	 * @param i
	 * @return low value
	 */
	private int determineLow(int i) {
		int low;
		if (i == 1) {
			low = 11;
		} else if (i > 10) {
			low = 10;
		} else {
			low = i;
		}
		return low;
	}

	/**
	 * gets the high value for the card
	 * 
	 * @param i
	 * @return high value
	 */
	private int determineHigh(int i) {
		int high;
		if (i == 1) {
			high = 11;
		} else if (i > 10) {
			high = 10;
		} else {
			high = i;
		}
		return high;
	}

	/**
	 * gets the label(name) of the card
	 * 
	 * @param s
	 * @return the label
	 */
	private String determineLabel(int s) {
		String name;
		switch (s) {
		case 1:
			name = "ACE";
			break;
		case 11:
			name = "JACK";
			break;
		case 12:
			name = "QUEEN";
			break;
		case 13:
			name = "KING";
			break;
		default:
			name = s + "";
			break;
		}
		return name;
	}
	
}
