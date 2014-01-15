package com.siliconmtn.game;

import java.util.Scanner;

import com.siliconmtn.game.blackjack.Rule21;
import com.siliconmtn.game.person.Dealer;
import com.siliconmtn.game.person.Location;
import com.siliconmtn.game.person.Player;

/****************************************************************************
 * <b>Title</b>: DataSetter.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 11:59:22 AM<p/>
 * <b>Changes: </b>
 ****************************************************************************/

public class DataSetter {
	
	private Scanner input = null;
	/**
	 * Sets all the data needed for the game
	 */
	public void setData(){
		System.out.println("Welcome to the game of BlackJack!");
		Location y = new Location("denver", "colorado", 80220);
		Player bob = new Player("Bob", "Hope", "male", y);
		System.out.println("Hello " + bob.getPerson() + "\n");
		System.out
		.println("How much money do you want to start with? 100, 300, or 500.");
		int pocket = moneyLimit(100, 300, 500);
		bob.setTotalMoney(pocket);
		System.out
		.println("Please choose how much to bet per round. 5, 15, or 30. ");
		int bet = moneyLimit(5, 15, 30);
		bob.setMoneyToBet(bet);
		System.out.println("Your choice was $" + bet);
		Location l = new Location("las vegas", "nevada", 89124);
		Dealer sue = new Dealer("mary", "sue", "female", l);
		System.out.println("Your dealer this game is " + sue);
		System.out.print("Dealer gets the deck for you to see.");
		Deck deck = new StandardDeck52();
		System.out.println(deck);
		System.out.println("Dealer shuffles the deck...");
		deck.shuffle();
		System.out.println(deck);
		Rule21 rule = new Rule21(1,2,1000.00);
		sue.setRule(rule);
		System.out.print("The amount of money the Casino's table has for now is $");
		System.out.println(sue.checkRules().getHousesBank());
		
	}
	/**
	 * determines the lowest and highest amount of money to bet per round
	 * 
	 * @return the user's choice
	 */
	public int moneyLimit(int low, int middle, int high) {
		input = new Scanner(System.in);
		while (true) {
			int choice = input.nextInt();
			if (choice != low && choice != middle && choice != high) {
				System.out.println("Please choose one of the three choices. ");
				continue;
			}
			return choice;
		}
	}
}	
