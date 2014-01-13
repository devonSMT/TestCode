package com.siliconmtn.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
	 * Adds cards to discard list pile
	 * 
	 */
	public List<Card> discards(Card c){
		System.out.print("Adding to discards");
		discardPile.add(c);
		return discardPile;
	}
	/**
	 * Adds selected cards from deck to cards being used pile
	 * @param cards
	 */
	public void addActiveCard(Card card){
		activePile.add(card);
	}
	/**
	 * returns the list of active cards
	 * @return
	 */
	public List<Card> cardsOut(){
		return activePile;
	}
	/**
	 * handles getting cards from deck
	 */
	public Card getACard(){ 
		Card p = gameDeck.remove(0);
		this.addActiveCard(p);
		return p;
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle(){
		Collections.shuffle(gameDeck);
	}
	/**
	 * method that helps handle if deck runs out of cards
	 * @return either the gamedeck or the activedeck
	 * should be used when dealer gets cards from deck
	 */
	public List<Card> getCurrentDeck(){
		if(this.gameDeck.isEmpty()){
			this.gameDeck.addAll(this.discardPile);
			shuffle();
			return this.gameDeck;
		}else return this.gameDeck;
	}
	
	/**
	 * Provides the list of cards that are in use and not in the deck
	 * @return
	 */
	public List<Card> getActiveCards() {
		return this.activePile;
	}
}
