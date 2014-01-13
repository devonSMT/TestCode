package com.siliconmtn.blackjack.person;

public class Person {
	
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected Location location;
	
	public Person(String first, String last, String gender, Location loc){

	}
	//create getters and setters for variables so other classes can access
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
}
