package com.siliconmtn.blackjack.rules;

import java.util.Scanner;

public class Rules21 {
	

	private int numOfPlayers = 0;
	private int cardsToDeal = 0;
	private double housesBank = 0;
	public Scanner input = null;
	
	/**
	 * Determines if you got 21 or not
	 * @return
	 */
	public int evaluateCards(int card1, int card2){
		int totalVaule;
		totalVaule = card1 + card2;
		return totalVaule;
	}
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
