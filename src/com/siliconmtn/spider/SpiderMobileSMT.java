package com.siliconmtn.spider;

import java.util.List;

/****************************************************************************
 * <b>Title</b>: SpiderMobile.javaIncomingDataWebService.java
 * <p/>
 * <b>Project</b>: SpiderProjectRAMDataFeed
 * <p/>
 * <b>Description: </b> <b>Copyright:</b> Copyright (c) 2014
 * <p/>
 * <b>Company:</b> Silicon Mountain Technologies
 * <p/>
 * 
 * @author Devon
 * @version 1.0
 * @since 1:41:49 PM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class SpiderMobileSMT extends SpiderSite {

	/*
	 * Concrete class that spiders mobile site using methods from generic
	 * SpiderSite + it's own method
	 */

	String userAgent = "Mozilla/5.0 (Linux; U; Android 4.1.1; WOW64; rv:26.0) Gecko/20100101 Mobile Safari/534.0";

	//Main Method
	public static void main(String[] args) {

		SpiderMobileSMT myMobile = new SpiderMobileSMT();

		// setup class
		myMobile.setUp();

		// run class
		myMobile.spiderProgram();

	}

	/**
	 * sets up the class for mobile version
	 */
	public void setUp() {

		this.hostName = "www.siliconmtn.com";
		this.portNumber = 80;
		this.info = new SpiderInfo();
		
		this.setSocket(this.hostName, this.portNumber);

		this.myConnect.writeSocket(mySkt, this.hostName,
				"http://www.siliconmtn.com", this.userAgent);

		this.allData = myConnect.dataCompiler2(mySkt);

		this.setAllLinks();

		this.getMobileLink();

		closeSocket(mySkt);

		// Redirect then get page for mobile
		System.out.println(info.getInfo("REDIRECT"));

		setSocket(this.hostName, this.portNumber);

		myConnect.writeSocket(mySkt, this.hostName);

		// Catch back info from server/source
		allData = myConnect.dataCompiler(mySkt);

		closeSocket(mySkt);
	}

	/*
	 * (non-Javadoc) Runs the class to spider mobile version
	 */
	@Override
	public void spiderProgram() {

		System.out.println(info.getInfo("STARTING"));

		System.out.println(allData);

		setAllLinks();

		// get just the raw links
		List<String> myFinalData = parser.parseLink(myParsedLinks, 0, 20);

		System.out.println(myFinalData);
	}
	
	/**
	 * parse through data to get mobile link for redirect
	 */
	public void getMobileLink(){
		String redirect = parser.parseLink(myParsedLinks,0, 1).get(0);

		int begin = redirect.indexOf("http://", 0);
		int end = redirect.indexOf("c", 0);

		// get just the link name for redirect
		String redirectLink = redirect.substring(begin + 7, end + 10);
		
		this.hostName = redirectLink;
	}

}
