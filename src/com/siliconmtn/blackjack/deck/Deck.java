package com.siliconmtn.blackjack.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	public List<Card> gameDeck = new ArrayList<Card>();
	public List<Card> activePile = new ArrayList<Card>();
	public List<Card> discardPile = new ArrayList<Card>();
	
	/** 
	 * Class constructor	
	 */
	public Deck(){	
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
	public void activeCards(Card cards){
		activePile.add(cards);
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
	public Card getACard(List<Card> cards){ 
		Card p = cards.remove(0);
		this.activeCards(p);
		return p;
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle(List<Card> card){
		Collections.shuffle(card);
	}
	/**
	 * method that helps handle if deck runs out of cards
	 * @return either the gamedeck or the activedeck
	 * should be used when dealer gets cards from deck
	 */
	public List<Card> getCurrentDeck(){
		if(this.gameDeck.isEmpty()){
			this.gameDeck.addAll(this.discardPile);
			shuffle(gameDeck);
			return this.gameDeck;
		}else return this.gameDeck;
	}
}
