package com.siliconmtn.game.blackjack;

import java.util.List;

import com.siliconmtn.game.Card;
import com.siliconmtn.game.person.Hand;
import com.siliconmtn.game.person.Player;

/****************************************************************************
 * <b>Title</b>: Rule21.java
 * <p/>
 * <b>Project</b>: TestCode
 * <p/>
 * <b>Description: </b>
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2014
 * <p/>
 * <b>Company:</b> Silicon Mountain Technologies
 * <p/>
 * 
 * @author james
 * @version 1.0
 * @since Jan 13, 2014
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/
public class Rule21 {

	// Class establishes rules for blackjack

	public final static int MINIMUM_NUM_PLAYERS = 1;
	public final static int MAX_NUM_PLAYERS = 4;
	public final static int GOAL = 21;
	public final static int DEALT_PER_TURN = 1;
	public final static int DEAL_TO_START = 2;

	// get messages needed for game
	private GameMessage msg = new GameMessage();

	/**
	 * Class Constructor
	 */
	public Rule21() {
		// Empty Constructor
	}

	/**
	 * checks to see if dealer busted/went over limit
	 * 
	 * @return true or false
	 */
	public boolean isBusted(Hand hand) {
		boolean bust = false;
		if (hand.getHandValue().get(Card.LOW_HAND_VALUE) > 21
				&& hand.getHandValue().get(Card.HIGH_HAND_VALUE) > 21) {
			System.out.println(msg.getMessage("BUSTED"));
			bust = true;
		}
		return bust;
	}

	/**
	 * Checks if dealers hand is under 16 value
	 */
	public boolean isUnderLimit(Hand hand) {
		boolean under = false;
		if (hand.getHandValue().get(Card.LOW_HAND_VALUE) < 16
				&& hand.getHandValue().get(Card.HIGH_HAND_VALUE) < 16) {
			under = true;
		}
		return under;
	}

	/**
	 * Compares dealer's hand to each players hand
	 * 
	 * @return
	 */
	public int evaluateCards(Hand dealerHand, Hand playerHand) {
		int val = 0;

		// if dealer wins
		if (dealerHand.getHandValue().get(Card.HIGH_HAND_VALUE) > playerHand
				.getHandValue().get(Card.HIGH_HAND_VALUE)) {
			val = 1;
		}
		// check if their hands were exactly the same value, a draw
		else if (dealerHand.getHandValue().get(Card.HIGH_HAND_VALUE) == playerHand
				.getHandValue().get(Card.HIGH_HAND_VALUE)) {
			val = 2;

		} else { // the player wins
			val = 3;
		}

		return val;
	}

	/**
	 * Determines who win's the round and displays message
	 */
	public void getWinner(int value, Player player) {
		// use switch for different case
		switch (value) {
		case 1:
			// dealer wins
			System.out.println(player.getFirstName()
					+ msg.getMessage("DEALER_WINS"));
			System.out.println(msg.getMessage("CASH") + player.getTotalMoney());
			break;
		case 2:
			// tie, return their money
			player.setTotalMoney(player.getTotalMoney()
					+ player.getMoneyToBet());
			System.out.println(msg.getMessage("PUSH"));
			System.out.println(msg.getMessage("CASH") + player.getTotalMoney());
			break;
		case 3:
			// Player wins and doubles money
			moneyIncrease(player);
			System.out.println(player.getFirstName()
					+ msg.getMessage("PLAYER_WINS"));
			System.out.println(msg.getMessage("CASH") + player.getTotalMoney());
			break;
		}
	}

	/**
	 * If someone wins double their bet
	 */
	public void moneyIncrease(Player player) {

		// take players bet money and doubles it
		double winnings = player.getMoneyToBet() * 2;

		// add it back to their total
		player.setTotalMoney(player.getTotalMoney() + winnings);
	}

	/**
	 * Checks # of players to ensure they are not over limit
	 * 
	 * @return number of players
	 */
	public void checkPlayer(List<Player> players) {
		// check to make sure they do not have more or less players
		// then the rules allow
		if (players.size() < MINIMUM_NUM_PLAYERS
				|| players.size() > MAX_NUM_PLAYERS) {
			System.out.println("Please choose an approiate amount of players.");
		}

	}

}