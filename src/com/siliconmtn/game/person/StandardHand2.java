package com.siliconmtn.game.person;

import com.siliconmtn.game.Card;

/****************************************************************************
 * <b>Title</b>: StandardHand2.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 11:16:54 AM<p/>
 * <b>Changes: </b>
 ****************************************************************************/

public class StandardHand2 extends Hand {
	
	private Card card1;
	private Card card2;
	/**
	 * Class Constructor
	 */
	public StandardHand2(Card first, Card second){
		this.card1 = first;
		this.card2 = second;
		this.assemblyHand();
	
	}
	/* (non-Javadoc)
	 * @see com.siliconmtn.game.person.Hand#assemblyHand()
	 */
	@Override
	/**
	 * Assembles standard hand of 2 cards
	 */
	public void assemblyHand() {
		this.hand.add(card1);
		this.hand.add(card2);
	}
}
