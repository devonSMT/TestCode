package com.siliconmtn.game.person;

import java.util.List;

import com.siliconmtn.game.Card;
import com.siliconmtn.game.StandardDeck52;
import com.siliconmtn.game.blackjack.Rule21;

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
public class Dealer extends Player {
	
	private Rule21 ruleSet;
	private StandardDeck52 gameDeck;
	private int numOfPlayers = 0;
	private double tableMinimum = 0;
	/**
	 * Class Constructor
	 * @param first
	 * @param last
	 * @param gender
	 * @param loc
	 */
	public Dealer(String first, String last, String gender, Location loc ) {
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
	 * 
	 * @return
	 */
	public void setRule(Rule21 rule){
		this.ruleSet = rule;
	}
	/**
	 * Allows dealer to verify the rules of the game
	 */
	public Rule21 getRules(){
		return this.ruleSet;
	}
	/**
	 * Returns the dealers hand
	 */
	public Hand getHand(){
		return this.hand;
	}
	
	/**
	 * asks if player wants another card
	 */
	public boolean isHitOrStay() {
		// decide if player wants another card or not
		
		// prompt player if they want another card (Dealer)
					//loop here too
		return false;
	}
	/**
	 * @return the gameDeck
	 */
	public StandardDeck52 getGameDeck() {
		return gameDeck;
	}
	/**
	 * @param gameDeck the gameDeck to set
	 */
	public void setGameDeck(StandardDeck52 gameDeck) {
		this.gameDeck = gameDeck;
	}
	/**
	 * @return the numOfPlayers
	 */
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	/**
	 * @param numOfPlayers the numOfPlayers to set
	 */
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	/**
	 * @return the tableMinimum
	 */
	public double getTableMinimum() {
		return tableMinimum;
	}
	/**
	 * @param tableMinimum the tableMinimum to set
	 */
	public void setTableMinimum(double tableMinimum) {
		this.tableMinimum = tableMinimum;
	}

}
