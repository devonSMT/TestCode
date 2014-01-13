package com.siliconmtn.game.person;

public class Location {
	private String city;
	private String state;
	private int zip;
	
	/**
	 * public constructor
	 */
	public Location(String city, String state, int zip){		
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	//generate getter and setters
	/**
	 * @return the city they are from
	 */
	public String getCity() {
		return city;
	}
	/**
	 * set the city name 
	 * @param city 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * set the state for person
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 
	 * @return the zipcode for person
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * set the zipcode for person
	 * @param zip
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
}
