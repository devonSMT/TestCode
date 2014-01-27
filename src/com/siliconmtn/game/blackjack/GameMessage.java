/**
 * 
 */
package com.siliconmtn.game.blackjack;

import java.util.HashMap;
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: GameMessage.java <p/>
 * <b>Project</b>: TestCode <p/>
 * <b>Description: </b>
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author james
 * @version 1.0
 * @since Jan 21, 2014<p/>
 * <b>Changes: </b>
 ****************************************************************************/
public class GameMessage {
	
	private HashMap<String, String> messages = new HashMap<String, String>();
	
	/**
	 * 
	 */
	public GameMessage() {
		this.assignMessages();
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getMessage(String key) {
		return messages.get(key);
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<String> getMessageKeys() {
		return messages.keySet();
	}
	
	/**
	 * Sets all messages needed for game to use
	 */
	private void assignMessages(){
		//set every message that you need
		messages.put("WELCOME", "Welcome to BlackJack. Dealer will deal you cards.");
		messages.put("GAME_OVER", "Thanks for playing BlackJack. GAME OVER. ");
		messages.put("ANOTHER_HIT", "Would you like another card?");
		messages.put("BET_AMOUNT", "How much would you like to bet this round?");
		messages.put("PLAY_AGAIN", "Would you like to play another round.");
	}

}