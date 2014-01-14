package com.siliconmtn.game.person;


/****************************************************************************
 * <b>Title</b>: Test.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 3:34:23 PM<p/>
 * <b>Changes: </b>
 ****************************************************************************/
public class Player extends Person {

	protected Hand hand;
	private double totalMoney = 0;
	
	/**
	 * Class Constructor
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
	 * 
	 * @return the amount of money they have
	 */
	public double getTotalMoney() {
		return totalMoney;
	}

	/**
	 * set amount of money they have
	 * @param totalMoney
	 */
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

}
