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
		
		// Dealer gets deck and shuffles it
		
		//display a little message with goal

	}
	/**
	 * Plays the game by checking players cards, determines results and
	 * keeps running until they lose all money or give up
	 */
	public void startGame() {
		// call setUpGame

		// Ask how much they want to bet this round

		// dealer deals cards

		// display cards for dealer and players

		// prompt player if they want another card

		// if so give another card

		// if no have dealer reveal other card

		// if dealer has 16 or less have to take another card

		// get dealer and players hand(call cardTotal on each player hand)
		
		// determine if they busted, if they do they lose that round
		
		//compare each players hand to decide who wins
		
		//display message if dealer wins, player wins, or a draw

		// prompt player if they want to play again

		//finishGame method() with statements for game over 
		//if no or out of money give a message with rating. Game ends
	}
	/**
	 * Checks if they busted by going over 21 limit 
	 * @return either true or false
	 */
	public boolean busted(int cardValue){
		boolean bust = false;
		// get total card value and compare it to 21
		
		//if they did set bust to true
		
		return bust;
	}

	/**
	 *asks if player wants another card
	 */
	public boolean hitOrStay(){
		//decide if player wants another card or not
		return false;
	}
	
	/**
	 * Gets the players total hand value
	 * @return
	 */
	public int cardTotal(List<Card> hand){
		int total = 0;
		
		//take list of cards and add together it's values 
	
		//assign to total return the cards total value
		
		return total;
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
			input.close();
			return choice;
		}
	}

}
