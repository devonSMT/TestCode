package com.siliconmtn.spider;

import java.util.List;

import com.siliconmtn.spider.file.FileWriter;

/****************************************************************************
 * <b>Title</b>: SpiderSMT.javaIncomingDataWebService.java
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
 * @since 1:00:45 PM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class SpiderSMT extends SpiderSite {

	/*
	 * Concrete class that spiders main site using methods from generic
	 * SpiderSite + it's own methods
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SpiderSMT mySpider = new SpiderSMT();

		mySpider.setUp();

		mySpider.spiderProgram();

	}

	/**
	 * Sets up the class for use
	 */
	public void setUp() {

		info = new SpiderInfo();

		hostName = "www.siliconmtn.com";
		portNumber = 80;

		setSocket(this.hostName, this.portNumber);

		myConnect.writeSocket(mySkt, this.hostName);

		allData = myConnect.dataCompiler(mySkt);

		closeSocket(mySkt);

	}

	/*
	 * (non-Javadoc) Runs program to spider standard version of site
	 */
	@Override
	public void spiderProgram() {

		System.out.println(info.getInfo("STARTING"));

		System.out.println(allData);

		this.setAllLinks();

		// get just the raw links
		List<String> myFinalData = parser.parseLink(myParsedLinks, 1, 9);

		flWriter = new FileWriter();

		this.writeToFile(myFinalData);

		// End class
		if (flWriter != null)
			System.out.println();
		System.out.println(info.getInfo("SUCCESS"));
	}
}
