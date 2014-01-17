package com.siliconmtn.game.blackjack;

import java.util.List;
import java.util.Scanner;

import com.siliconmtn.game.Card;

/****************************************************************************
 * <b>Title</b>: Test.javaIncomingDataWebService.java
 * <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed
 * <p/>
 * <b>Description: </b> <b>Copyright:</b> Copyright (c) 2014
 * <p/>
 * <b>Company:</b> Silicon Mountain Technologies
 * <p/>
 * 
 * @author Devon
 * @version 1.0
 * @since 3:34:23 PM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/
public class Game {

	// Main method
	public static void main(String[] args) {
		Game game = new Game();
	}
	/**
	 * Sets up data needed for game
	 */
	public void setUpGame() {
		//get rules
		
		// get minimum number of players
		
		// get minimum bet table for players to seat at

		// get amount of money players start with
		
		//get players, get dealer

	}
	/**
	 * Starts the game
	 */
	public void startGame() {
		// call setUpGame

		// give a welcome message

		// Ask how much they want to bet this round

		// Dealer gets deck and shuffles it

		// dealer deals cards

		// display cards for dealer and players

		// prompt player if they want another card

		// if so give another card

		// if no have dealer reveal other card

		// if dealer has 16 or less have to take another card

		// compare dealer and players hand to decide who wins

		// prompt player if they want to play again

		// if no or out of money give a message with rating. Game ends
	}
	
	/**
	 *asks if player wants another card
	 */
	public boolean hitOrStay(){
		//decide if player wants another card or not
		return false;
	}
	
	/**
	 * Evaluates if dealer or player wins
	 * @return
	 */
	public String compareCards(List<Card> hand){
		//compare players cards vs dealer
		
		//set message if dealer wins
	
		//or set message if player wins
		return null;
	}
	
	/**
	 * gives three options and returns one
	 * 
	 * @return the user's choice
	 */
	public int moneySetter(int low, int middle, int high) {
		Scanner input = new Scanner(System.in);
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
