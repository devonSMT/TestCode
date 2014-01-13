package com.siliconmtn.blackjack.person;

import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.blackjack.deck.Card;
import com.siliconmtn.blackjack.rules.Rules21;

public class Dealer extends Player {

	private List<Card> dealersHand = new ArrayList<Card>();
	public Rules21 rules = new Rules21();
	
	/**
	 * Class Constructor
	 * @param first
	 * @param last
	 * @param gender
	 * @param loc
	 */
	public Dealer(String first, String last, String gender, Location loc) {
		super(first, last, gender, loc);
		this.firstName = first;
		this.lastName = last;
		this.gender = gender;
		this.location = loc;
	}

	/**
	 * Deal cards to players
	 * @return
	 */
	public Card dealCards(List<Card> cards){
		Card oneCard = cards.remove(0);
		return oneCard;
	}	
	/**
	 * Show dealers current hand
	 * @return
	 */
	public List<Card> getHand(){
		return this.dealersHand;
	}
}
