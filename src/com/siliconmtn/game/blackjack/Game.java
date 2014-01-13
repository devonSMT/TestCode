package com.siliconmtn.game.blackjack;

import com.siliconmtn.game.Deck;
import com.siliconmtn.game.StandardDeck52;
import com.siliconmtn.game.person.Dealer;
import com.siliconmtn.game.person.Location;

public class Game {

	public static void main(String[] args) {
		// Main method
		Location l = new Location("las vegas", "nevada", 89124);
		Dealer person = new Dealer("mary","sue", "female", l);
		System.out.println(person.getFullName() + " " + person.getCityStateZip());
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
		person.rules.moneyLimits(5, 15, 30);
	}
}
