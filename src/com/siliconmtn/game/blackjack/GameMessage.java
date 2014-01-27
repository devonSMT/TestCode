package com.siliconmtn.game.blackjack;

import java.util.HashMap;

/****************************************************************************
 * <b>Title</b>: GameMessage.javaIncomingDataWebService.java
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
 * @since 8:38:46 AM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class GameMessage {

	
	private HashMap<String, String> messages = new HashMap<String, String>();

	// Class Constructor that returns all messages automatically
	public GameMessage() {
		this.getAllMessages();
	}
	
	/**
	 *Give a string and return the value for that message 
	 * @param msg
	 * @return value based on the key
	 */
	public String getMessage(String msg){
		return messages.get(msg);
	}
	
	/**
	 * Returns all messages
	 * @return game messages
	 */
	protected HashMap<String, String> getAllMessages() {
		// set all messages
		messages.put("WELCOME",
				"Welcome to the game of BlackJack, your goal is to get 21.");
		messages.put("TABLE","Table minimum is $");
		messages.put("START_AMOUNT", "Everyone here starts with $");
		messages.put("ANOTHER_CARD", "Would you like another card?");
		messages.put("BET_SIZE", "How much would you like to bet this round?");
		messages.put("PLAY_AGAIN", " \n Would you like to play again?");
		messages.put("GAME_OVER", "Thanks for playing BlackJack! GAME OVER");
		messages.put("TOO_SMALL", "[Dealer's hand was too small, takes a card]");
		messages.put("CARDS_VALUES", "Card values are ");
		messages.put("DEALER_DEALS","[Dealer deals cards out...]");
		messages.put("ENTER_CHOICE", " Enter 1=YES, 2=NO");
		messages.put("LOSE", "You lose this round");
		messages.put("BUSTED", "Sorry you busted, you lose.");
		messages.put("DEALER_BUST", "[Dealer busted],Everyone wins this round!");
		messages.put("DEALER_WINS", " Sorry you lose.");
		messages.put("PLAYER_WINS", " Your hand is better, you win");
		messages.put("PUSH", "Dealer's hand is same as yours. Is a Push");
		messages.put("INCORRECT", "Please choose a correct response");
		messages.put("MINIMUM", "You have to bet a least the minimum");
		messages.put("NOT_ENOUGH", "You don't have that much money");
		messages.put("MONEY_OUT", "\n Out of money..[game gives you minimum]");
		messages.put("CASH", "Your total cash is ");
		messages.put("DEALERS_CARDS", "Dealer's cards are ");
		messages.put("DEALERS_FIRST", "Dealer's first card is ");
		messages.put("CARD_VALUES", " Card values are");
		messages.put("NEW_LINE", "\n");
		// return messages
		return messages;
	}

}