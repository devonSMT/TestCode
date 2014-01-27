package com.siliconmtn.game.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.siliconmtn.game.Card;
import com.siliconmtn.game.StandardDeck52;
import com.siliconmtn.game.blackjack.GameMessage;
import com.siliconmtn.game.blackjack.Rule21;

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
public class Dealer extends Player {

	// Variables that dealer needs to keep track of
	private Rule21 ruleSet;
	private StandardDeck52 gameDeck;
	private double tableMinimum = 0;
	private List<Player> gamePlayers = new ArrayList<Player>();

	// Variables used throughout game
	private GameMessage messg = null;
	Scanner input = null;

	/**
	 * Class Constructor
	 * 
	 * @param first
	 * @param last
	 * @param gender
	 * @param loc
	 */
	public Dealer(String first, String last, String gender, Location loc) {
		super(first, last, gender, loc);
		this.firstName = first;
		this.lastName = last;
		this.gender = gender;
		this.location = loc;

	}

	/**
	 * Handles running most of the game
	 * 
	 * @return true or false
	 */
	public void runGame() {
		messg = new GameMessage();

		// get each players bet and set it to the amount they bet this round
		getBet(gamePlayers);

		// dealer should check deck before dealing
		this.gameDeck.getCurrentDeck();

		// Dealer deals
		System.out.println(messg.getMessage("DEALER_DEALS"));

		// dealer deals cards to self first, two to start
		dealCards(this.hand, Rule21.DEAL_TO_START);

		// Display dealers first card
		displayFirst();

		// prompt player if they want another card (Dealer)
		runDealing();

		// once all players are done taking cards reveal dealers card
		System.out.println(messg.getMessage("DEALERS_CARDS")
				+ this.hand.getCards() + messg.getMessage("NEW_LINE"));

		// make dealer take a card if under 16
		checkHand();

		// determine if dealer busted, if so everyone wins
		if (ruleSet.isBusted(this.hand)) {
			System.out.println(messg.getMessage("DEALER_BUST"));
			
			// double everyone's money
			for (Player player : this.gamePlayers) {
				ruleSet.moneyIncrease(player);
				disposeCards(player.hand);
			}
			// get rid of dealers hand, end round
			disposeCards(this.hand);
			return;
		}

		// compare dealer to players hand and get winner
		getResults(this.gamePlayers);

		// get rid of dealer's hand
		disposeCards(this.hand);
		// END OF ROUND

		// check how much money they have left
		checkMoney(gamePlayers);

	}

	/**
	 * Does the handling of dealing cards to players
	 */
	public void runDealing() {
		for (Player gamePlayer : this.gamePlayers) {

			// dealer deals cards to player(s), two to start
			dealCards(gamePlayer.hand, Rule21.DEAL_TO_START);

			// while loop
			while (true) {
				// display player(s) current cards
				displayCards(gamePlayer);

				System.out.println(gamePlayer.getFullName() + " "
						+ messg.getMessage("ANOTHER_CARD"));
				// if they want to hit give them another card
				if (userInput() == 1) {
					dealCards(gamePlayer.hand, Rule21.DEALT_PER_TURN);

					// then evaluate to see they busted
					if (ruleSet.isBusted(gamePlayer.hand)) {
						displayCards(gamePlayer);
						// take their cards
						disposeCards(gamePlayer.hand);
						break;
					}
					// check if get 21 also

				} else {
					// they said no so break loop
					break;
				}
			}
			// move on to next player and repeat previous steps
		}
	}

	/**
	 * If dealers hand is under 16 takes another card
	 */
	public void checkHand() {
		while (ruleSet.isUnderLimit(this.hand)) {

			// if under 16 for both values have to take another card
			Card card = this.gameDeck.getACard();
			hand.addToHand(card, true);
			System.out.println(messg.getMessage("TOO_SMALL"));
			System.out.println(messg.getMessage("DEALERS_CARDS")
					+ hand.getCards());
		}
	}

	/**
	 * Checks to see if player is out of money
	 * 
	 * @param gamePlayer
	 */
	public void checkMoney(List<Player> gamePlayer) {
		for (Player player : gamePlayer) {
			if (player.getTotalMoney() == 0) {
				// resets their money
				System.out.println(messg.getMessage("MONEY_OUT"));
				player.setTotalMoney(tableMinimum);
			}
		}
	}

	/**
	 * Gets input from user
	 * 
	 * @param gamePlayer
	 * @return their input
	 */
	public int userInput() {
		input = new Scanner(System.in);
		int reply = 0;
		// loop through players in game
		while (true) {
			System.out.println(messg.getMessage("ENTER_CHOICE"));

			reply = input.nextInt();

			if (evalInput(reply)) {
				break;
			}

		}
		return reply;
	}

	/**
	 * evaluates their bet based on ranges you put in
	 * 
	 * @return
	 */
	public boolean evalInput(int answer) {

		boolean valid = true;
		if (answer != 1 && answer != 2) {
			// give error
			System.out.println(messg.getMessage("INCORRECT"));
			valid = false;
			return valid;

		}
		return valid;
	}

	/**
	 * Handles displaying of a card with it's value
	 */
	public void displayFirst() {
		System.out.println(messg.getMessage("DEALERS_FIRST")
				+ this.hand.viewCard(0, false) + messg.getMessage("NEW_LINE"));
	}

	/**
	 * Handles displaying of cards for multiple players
	 * their values
	 */
	public void displayCards(Player player) {
		System.out.print(player.firstName + player.hand.getCards());
		System.out.println(messg.getMessage("CARD_VALUES")
				+ player.hand.getHandValue() + messg.getMessage("NEW_LINE"));

	}

	/**
	 * method that will compare and evaluate players hand to dealers gives
	 * message back if they win, lose, draw
	 */
	public void getResults(List<Player> gamePlayers) {
		// loop through each player
		for (Player player : gamePlayers) {

			int value = ruleSet.evaluateCards(this.hand, player.hand);

			// evaluate if they win or not
			ruleSet.getWinner(value, player);
			
			// then clear hand for next round
			disposeCards(player.hand);
		}

	}

	/**
	 * Deal cards based on number you give it
	 * 
	 * @return dealt cards
	 */
	public void dealCards(Hand hand, int numOfCards) {

		// loop through number of cards they pass in
		for (int i = 0; i < numOfCards; i++) {

			// Needs to get deck first to deal a card
			Card card = this.gameDeck.getACard();

			// add card to players hand
			hand.addToHand(card, true);
		}

		// set way to deal cards per round based on rules of game
	}

	/**
	 * adds cards to discards and clears their hand
	 * 
	 * @param playerhand
	 */
	public void disposeCards(Hand playerHand) {
		gameDeck.discards(playerHand.getCards());
		playerHand.foldHand();
	}

	public void getBet(List<Player> player) {
		input = new Scanner(System.in);
		// loop through list of players
		for (Player currentPlayer : player) {
			while (true) {
				System.out.println(currentPlayer.getFullName() + " "
						+ messg.getMessage("BET_SIZE"));
				double bet = (double) (input.nextInt());

				// get bet and make sure it's okay
				if (evaluateBet(bet, currentPlayer)) {

					// assign their bet
					currentPlayer.setMoneyToBet(bet);

					// subtract their bet from their total
					currentPlayer.setTotalMoney(currentPlayer.getTotalMoney()
							- bet);
					// If all is good, break loop
					break;
				}
			}
		}

	}

	/**
	 * evaluates bet to ensure they type in correct info
	 * 
	 * @return
	 */
	public boolean evaluateBet(double bet, Player player) {
		boolean validBet = true;

		// ensure they bet at least the table minimum
		if (bet < this.tableMinimum) {
			System.out.println(messg.getMessage("MINIMUM"));
			validBet = false;
		}
		// ensure they don't bet over their limit
		if (bet > player.getTotalMoney()) {
			System.out.println(messg.getMessage("NOT_ENOUGH"));
			validBet = false;
		}

		return validBet;
	}


	/**
	 * Allows to set rules to dealer
	 * 
	 * @return
	 */
	public void setRule(Rule21 rule) {
		this.ruleSet = rule;
	}

	/**
	 * Allows dealer to verify the rules of the game
	 */
	public Rule21 getRules() {
		return this.ruleSet;
	}

	/**
	 * Returns the dealers hand
	 */
	public Hand getHand() {
		return this.hand;
	}

	/**
	 * @return the gameDeck
	 */
	public StandardDeck52 getGameDeck() {
		return gameDeck;
	}

	/**
	 * @param gameDeck
	 *            the gameDeck to set
	 */
	public void setGameDeck(StandardDeck52 gameDeck) {
		this.gameDeck = gameDeck;
	}

	/**
	 * @return the tableMinimum
	 */
	public double getTableMinimum() {
		return tableMinimum;
	}

	/**
	 * @param tableMinimum
	 *            the tableMinimum to set
	 */
	public void setTableMinimum(double tableMinimum) {
		this.tableMinimum = tableMinimum;
	}

	/**
	 * @return a list of gamePlayers
	 */
	public List<Player> getGamePlayers() {
		return gamePlayers;
	}

}