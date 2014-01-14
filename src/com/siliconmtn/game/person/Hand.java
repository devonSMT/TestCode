package com.siliconmtn.game.person;

import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.game.Card;

/****************************************************************************
 * <b>Title</b>: Hand.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 4:08:39 PM<p/>
 * <b>Changes: </b>
 ****************************************************************************/

public abstract class Hand {
		
    protected List<Card> hand = new ArrayList<Card>();
    private int totalValue = 0;
    
    /**
	 * @return the totalValue
	 */
	public int getTotalValue() {
		return totalValue;
	}
	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(int totalValue) {
		this.totalValue += totalValue;
	}
	/**
     * Method for each subclass to implement to get a hand
     */
    public abstract void assemblyHand();
    /**
     * Allows person to add a card to their hand
     * @param card
     */
    public void addToHand(Card card){
    	hand.add(card);
    }
    /**
     * Method that gets the total value of the hand
     */
    public int evaluateHand(){
    	int value; 
    	for(int i = 0; i < hand.size(); i++){
    	 value = hand.get(i).getHighValue();
    	 setTotalValue(value);
    	}
    	return getTotalValue();
    }
    /**
     * Method that returns a card from itself
     */
    public Card pickACard(int cardPosition){
    	Card card = hand.remove(cardPosition);
    	return card;
    }
    /**
     * 
     * @return
     */
    public List<Card> getHand(){
    	return this.hand;
    }
    /**
     * Method that handles returning cards to Deck
     * @return the entire hand 
     */
    public void returnHand(){
    	hand.removeAll(hand);
    }
}
