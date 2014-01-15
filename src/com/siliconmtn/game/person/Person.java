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

public class Person {
	
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected Location location;
	
	public Person(String first, String last, String gender, Location loc){

	}
	//create getters and setters for variables so other classes can access
	/**
	 * Returns a String representation persons' name,state, etc..
	 */
	public String toString(){
		return getPerson();
	}
	/**
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 
	 * @return the location for the person
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * gets person's full first and last name
	 * @return full name
	 */
	public String getFullName(){
		return this.getFirstName() + " " + this.getLastName();
	}
	/**
	 * get person's city, state and zip
	 * @return
	 */
	public String getCityStateZip(){
		return this.location.getCity() + "," +  this.location.getState() + 
				" " + this.location.getZip();
	}
	
	public String getPerson(){
		return getFullName() + " from " + getCityStateZip();
	}
}
