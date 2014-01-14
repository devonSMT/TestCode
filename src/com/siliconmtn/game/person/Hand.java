package com.siliconmtn.game.person;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
public class Hand {
	/**
	 * Collection of cards that make up the hand
	 */
    protected List<Card> cards = new ArrayList<Card>();
    
    /**
     * Allows person to add a card to their hand
     * @param card
     */
    public void addToHand(Card card, boolean visible){
    	card.setVisible(visible);
    	cards.add(card);
    }
    
    /**
     * Method that gets the total value of the hand
     */
    public Map<String, Integer> getHandValue(){
    	Map<String, Integer> values = new LinkedHashMap<String, Integer>(); 
    	values.put(Card.LOW_HAND_VALUE, this.getLowValue());
    	values.put(Card.HIGH_HAND_VALUE, this.getHighValue());
    	
    	return values;
    }
    
    private int getLowValue() {
    	int value = 0; 
    	for(int i = 0; i < cards.size(); i++){
    	 value = cards.get(i).getLowValue();
    	}
    	
    	return value;
    }
    
    private int getHighValue() {
    	int value = 0; 
    	for(int i = 0; i < cards.size(); i++){
    	 value = cards.get(i).getHighValue();
    	}
    	
    	return value;
    }
    
    /**
     * Method that returns a card from itself
     */
    public Card viewCard(int cardPosition, boolean removeFromDeck){
    	Card card = cards.get(cardPosition);
    	if (removeFromDeck) cards.remove(cardPosition);
    	
    	return card;
    }
    
    /**
     * 
     * @return
     */
    public List<Card> getCards(){
    	return this.cards;
    }
    /**
     * Method that handles returning cards to Deck
     * @return the entire hand 
     */
    public void foldHand(){
    	cards.clear();
    }
}
