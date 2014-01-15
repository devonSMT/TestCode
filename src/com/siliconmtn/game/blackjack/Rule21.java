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

        private int numOfPlayers = 0;
        private int dealtPerTurn = 0;
        private double housesBank = 0;
        
		/**
		 * Class Constructor
		 */
		public Rule21(int players, int dealt, double bank){ 
			this.numOfPlayers = players;
			this.dealtPerTurn = dealt;
			this.housesBank = bank;
			
		}
        /**
         * @return the numOfPlayers
         */
        public int getNumOfPlayers() {
                return numOfPlayers;
        }
        /**
         * @return the cardsToDeal
         */
        public int getDealtPerTurn() {
                return dealtPerTurn;
        }
        /**
         * @return the housesBank
         */
        public double getHousesBank() {
                return housesBank;
        }
                
}