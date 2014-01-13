package com.siliconmtn.game.person;

import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.game.Card;

public class Player extends Person {

	private List<Card> hand = new ArrayList<Card>();
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
	/**
	 * Show players current hand
	 * @return
	 */
	public List<Card> getHand(){
		return this.hand;
	}

}
