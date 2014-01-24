package com.siliconmtn.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: Test.javaIncomingDataWebService.java
 * <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed
 * <p/>
 * <b>Description: </b> <b>Copyright:</b> Copyright (c) 2014
 * <p/>
 * <b>Company:</b> Silicon Mountain Technologies
 * <p/>
 * 
 * @author Devon
 * @version 1.0
 * @since 3:34:23 PM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/
public abstract class Deck {
	protected List<Card> gameDeck = new ArrayList<Card>();
	private List<Card> activePile = new ArrayList<Card>();
	private List<Card> discardPile = new ArrayList<Card>();

	/**
	 * Method for each subclass to implement to build the class
	 */
	public abstract void buildDeck();

	/**
	 * Prints a string representation of the current deck
	 */
	public String toString() {
		return gameDeck.toString();
	}

	/**
	 * Override method that takes a list of cards, adds to discards pile
	 * 
	 * @param c
	 * @return
	 */
	public List<Card> discards(List<Card> cards) {
		discardPile.addAll(cards);
		return discardPile;
	}

	/**
	 * Add a card to discard list pile
	 */
	public List<Card> discards(Card c) {
		System.out.print("Adding to discards");
		discardPile.add(c);
		return discardPile;
	}

	/**
	 * Adds selected cards from deck to cards being used pile
	 * 
	 * @param cards
	 */
	public void addActiveCard(Card card) {
		activePile.add(card);
	}

	/**
	 * handles getting cards from deck
	 */
	public Card getACard() {
		Card p = gameDeck.remove(0);
		this.addActiveCard(p);
		return p;
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(gameDeck);
	}

	/**
	 * method that helps handle if deck runs out of cards
	 * 
	 * @return either the gamedeck or the activedeck should be used when dealer
	 *         gets cards from deck
	 */
	public List<Card> getCurrentDeck() {
		if (this.gameDeck.isEmpty() || this.gameDeck.size() < 15) {
			this.gameDeck.addAll(this.discardPile);
			shuffle();
			return this.gameDeck;
		} else
			return this.gameDeck;
	}

	/**
	 * Provides the list of cards that are in use and not in the deck
	 * 
	 * @return
	 */
	public List<Card> getActiveCards() {
		return activePile;
	}
}
