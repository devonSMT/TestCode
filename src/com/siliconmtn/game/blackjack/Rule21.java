package com.siliconmtn.game.blackjack;

import java.util.List;
import java.util.Scanner;

import com.siliconmtn.game.Card;
import com.siliconmtn.game.person.Hand;


/****************************************************************************
 * <b>Title</b>: Rule21.java <p/>
 * <b>Project</b>: TestCode <p/>
 * <b>Description: </b>
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author james
 * @version 1.0
 * @since Jan 13, 2014<p/>
 * <b>Changes: </b>
 ****************************************************************************/
public class Rule21 {
        
//Class establishes rules for blackjack

        public final static int minimumNumOfPlayers = 1;
        public final static int maxNumOfPlayers = 4;
        public final static int goal = 21;
        public final static int dealtPerTurn = 1;
    	private Scanner input = null;
	
    	/**
		 * Class Constructor
		 */
		public Rule21(){
			//Empty Constructor
		}

        /**
         * @return the cardsToDeal
         */
        public int getDealtPerTurn() {
            //get number of cards to be dealt    
        	return dealtPerTurn;
        }
        
        /**
         * Sets the amount of cards to be dealt
         */
        public void setDealtPerTurn(){
        	// set cards to be dealt
        }
        
    	/**
    	 * Checks if they busted by going over 21 limit
    	 * 
    	 * @return either true or false
    	 */
    	public boolean isBusted(Hand h) {
    		boolean bust = false;
    		// get total card value and compare it to 21

    		// if they did set bust to true

    		return bust;
    	}

    	/**
    	 * Gets the players total hand value
    	 * 
    	 * @return
    	 */
    	public int cardTotal(List<Card> hand) {
    		int total = 0;

    		// take list of cards and add together it's values

    		// assign to total return the cards total value

    		return total;
    	}

    	/**
    	 * Checks # of players to ensure they are not over limit
    	 * 
    	 * @return number of players
    	 */
    	public int checkPlayer(int min, int max) {
    		// check to make sure they do not have more or less players
    		// then the rules allow
    		input = new Scanner(System.in);
    		while (true) {
    			int answer = input.nextInt();
    			if (answer < min || answer > max) {
    				System.out.println("Please choose an approiate amount of players.");
    				continue;
    			}
    			return answer;
    		}
    	}

}