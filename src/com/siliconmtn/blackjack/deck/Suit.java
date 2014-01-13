package com.siliconmtn.blackjack.deck;

import java.util.HashMap;

public class Suit {
		//set general constants for easier use
	public static final int HEARTS = 1;
	public static final int SPADES = 2;
	public static final int CLUBS = 3;
	public static final int DIAMONDS = 4;
	
	private int value = 0;
	
	private static HashMap<Integer, String> suits = new HashMap<Integer, String>();
	
	/**Method Constructor
	 * constructor that puts values of constants into hashmap with value pair
	 */
	public Suit(int suit) {
		//when called have to pass in #
		if(suit > 4 || suit < 1){
			this.setValue(1);
		}else {
			this.setValue(suit);
		}
	}

	/**
	 * Returns the suit name from the value
	 * @return
	 */
	public String getSuit() {
		return suits.get(value);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	/**
	 * sets value to this value
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * method that returns all different suites
	 * @return
	 */
	public static HashMap<Integer ,String> getSuits(){
		suits.put(Suit.HEARTS, "Hearts");
		suits.put(Suit.SPADES, "Spades");
		suits.put(Suit.CLUBS, "Clubs");
		suits.put(Suit.DIAMONDS, "Diamonds");
		return suits;
	}
}
