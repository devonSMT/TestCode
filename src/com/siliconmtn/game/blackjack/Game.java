package com.siliconmtn.game.blackjack;

import com.siliconmtn.game.Deck;
import com.siliconmtn.game.StandardDeck52;
import com.siliconmtn.game.person.Dealer;
import com.siliconmtn.game.person.Location;

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
public class Game {

	public static void main(String[] args) {
		// Main method
		Location l = new Location("las vegas", "nevada", 89124);
		Dealer person = new Dealer("mary","sue", "female", l);
		System.out.println(person);
		Deck deck = new StandardDeck52();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.getACard());
		System.out.println(deck.getACard());
		System.out.println(deck.getACard());
		System.out.println(deck.getACard());
		System.out.println(deck.getActiveCards());

		System.out.println(deck.getCurrentDeck() + "\n");
		
		System.out.println("Please choose how much to bet per round. 5, 15, or 30. ");
	}
}
