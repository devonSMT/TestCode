package com.siliconmtn.game;

import java.util.Iterator;

/****************************************************************************
 * <b>Title</b>: Test.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 3:34:23 PM<p/>
 * <b>Changes: </b>
 ****************************************************************************/

public class StandardDeck52 extends Deck {

	/**
	 * Class constructor
	 */
	public StandardDeck52() {
		this.buildDeck();
		
	}
	/**
	 * builds deck of 52 cards
	 * 
	 * @return
	 */
	public void buildDeck() {
		for (Iterator<Integer> iter = Suit.getSuits().keySet().iterator(); iter.hasNext();) {
			Suit s = new Suit(iter.next());
			for (int i = 1; i < 14; i++) {
				Card card = new Card(s, i, determineLabel(i), determineLow(i), determineHigh(i));
				this.gameDeck.add(card);
			}
		}
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
