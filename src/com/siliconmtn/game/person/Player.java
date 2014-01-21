package com.siliconmtn.game.person;

import java.util.Scanner;

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
public class Player extends Person {

	protected Hand hand;
	private double moneyToBet = 0;
	private double totalMoney = 0;
	Scanner input = null;

	/**
	 * Class Constructor
	 * 
	 * @param first
	 * @param last
	 * @param gender
	 * @param loc
	 */
	public Player(String first, String last, String gender, Location loc) {
		super(first, last, gender, loc);
		this.firstName = first;
		this.lastName = last;
		this.gender = gender;
		this.location = loc;
	}

	/**
	 * @return the totalMoney
	 */
	public double getTotalMoney() {
		return totalMoney;
	}

	/**
	 * @param totalMoney
	 *            the totalMoney to set
	 */
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * 
	 * @return the amount of money they have
	 */
	public double getMoneyToBet() {
		return moneyToBet;
	}

	/**
	 * set amount of money they have
	 * 
	 * @param totalMoney
	 */
	public void setMoneyToBet(int moneyToBet) {
		this.moneyToBet = moneyToBet;
	}
	/**
	 * Let player decide to keep playing or not
	 * 
	 * @return
	 */
	public boolean isKeepPlaying() {
		// assign variable to false
		boolean answer = false;
		// get user response
		input = new Scanner(System.in);
		while (true) {
			int k = input.nextInt();
			if (k < 1 || k > 2) {
				System.out.println("Please choose either one or 2");
				continue;
				//if they want to keep playing set answer to true
			} else if (k == 1) {
				answer = true;
			}
			return answer;

		}

	}

}
