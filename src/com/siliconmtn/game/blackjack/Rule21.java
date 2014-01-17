package com.siliconmtn.game.blackjack;


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
        
//establishes rules for blackjack

        public final static int minimumNumOfPlayers = 1;
        public final static int maxNumOfPlayers = 4;
        private int dealtPerTurn = 0;
        private int goal = 21;
        
		/**
		 * Class Constructor
		 */
		public Rule21(){ 
			//General Constructor
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
         * gives back the goal of the game for 21
         * @return the goal
         */
        public int getGoal(){
        	// get back the goal for the game
        	return this.goal;
        }
}