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
        
		/**
		 * Class Constructor
		 */
		public Rule21(){ 
			
		}

        /**
         * @return the cardsToDeal
         */
        public int getDealtPerTurn() {
                return dealtPerTurn;
        }
}