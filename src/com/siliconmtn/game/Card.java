package com.siliconmtn.game;

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

public class Card {
	
	protected String name;
	protected Suit suit;
	protected int rank;
	protected int lowValue = 0;
	protected int highValue = 0;
	
	/**
	 * Class Constructor
	 */
	public Card(Suit suit, int rank, String name, int low, int high){
		this.suit = suit;
		this.rank = rank;
		this.name = name;
		this.lowValue = low;
		this.highValue = high;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getName();
	}
	
		//generate setters and getters
	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @return the lowValue
	 */
	public int getLowValue() {
		return lowValue;
	}

	/**
	 * @return the highValue
	 */
	public int getHighValue() {
		return highValue;
	}
	/**
	 * Returns the name and suit of the card
	 * 
	 * @return
	 */
	public String getName() {
		return name + " of " + this.suit.getSuit();
	}
	/**
	 * 
	 * @return
	 */
	public String getHighLow(){
		return "The values are " + getLowValue() + " and " + getHighValue();
	}
}
