package com.siliconmtn.game.blackjack;

import java.util.Scanner;

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
        

        private int numOfPlayers = 0;
        private int cardsToDeal = 0;
        private double housesBank = 0;
        private Scanner input = null;
        /**
         * determines the lowest and highest amount of money to bet per round
         * @return
         */
        public int moneyLimits(int low, int middle, int high ){
                input = new Scanner(System.in);
                while(true){
                        int choice =  input.nextInt();
                        if(choice != low && choice != middle && choice != high){
                                System.out.println("Please choose one of the three choices. ");
                                continue;
                        }
                        return choice;
                }
        }
                //Generated getter and setters
        /**
         * @return the numOfPlayers
         */
        public int getNumOfPlayers() {
                return numOfPlayers;
        }
        /**
         * @param numOfPlayers the numOfPlayers to set
         */
        public void setNumOfPlayers(int numOfPlayers) {
                this.numOfPlayers = numOfPlayers;
        }
        /**
         * @return the cardsToDeal
         */
        public int getCardsToDeal() {
                return cardsToDeal;
        }
        /**
         * @param cardsToDeal the cardsToDeal to set
         */
        public void setCardsToDeal(int cardsToDeal) {
                this.cardsToDeal = cardsToDeal;
        }
        /**
         * @return the housesBank
         */
        public double getHousesBank() {
                return housesBank;
        }
        /**
         * @param housesBank the housesBank to set
         */
        public void setHousesBank(double housesBank) {
                this.housesBank = housesBank;
        }
                
}