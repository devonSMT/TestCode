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
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * 
	 * @return the zipcode for person
	 */
	public int getZip() {
		return zip;
	}
}
