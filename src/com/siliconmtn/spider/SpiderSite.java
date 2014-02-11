package com.siliconmtn.spider;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.spider.connection.Connection;
import com.siliconmtn.spider.file.FileWriter;
import com.siliconmtn.spider.parser.Parser;

/****************************************************************************
 * <b>Title</b>: SpiderTestDrive.javaIncomingDataWebService.java
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
 * @since 9:11:50 AM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class SpiderSite {

	// Set up all variables needed for class
	private Parser parser;
	private Connection myConnect;
	private FileWriter flWriter;
	private Socket mySkt;
	
	private SpiderInfo info = null;
	private StringBuilder myData = null;
	private List<String> myParsedData = null;
	private String hostName = "www.siliconmtn.com";
	private String requestUrl = "http://www.siliconmtn.com";
	private String userAgent = "Java";
	private int portNumber = 80;
	private boolean getMobile = false;

	/**
	 * Main Method, sets up the class then runs it
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		SpiderSite spider = new SpiderSite(false);

		// choose which setup to use
		spider.setUp();

		// run the class
		spider.startSpider();

	}

	/**
	 * Class constructor, When called have to specify if you want mobile or
	 * desktop version by input of true or false
	 * 
	 * @param useMobile
	 *            - use true of false for which set to render
	 */
	public SpiderSite(boolean useMobile) {
		this.getMobile = useMobile;
	}

	/**
	 * Sets up the class for use
	 */
	public void setUp() {

		// Check to see user want to spider mobile site
		if (getMobile == true) {
			// create a fake mobile system
			this.userAgent = "Mozilla/5.0 (Linux; U; Android 4.1.1; WOW64; rv:26.0) Gecko/20100101 Mobile Safari/534.0";
		}

		// Connect to server
		setSocket(this.hostName, this.portNumber);

		// Write request to server
		myConnect.writeSocket(mySkt, this.hostName, this.requestUrl, this.userAgent);

		// Catch back info from server/source
		myData = myConnect.dataCompiler(mySkt);

		// Close the socket
		//closeSocket();

		// Create instance of info for messages
		info = new SpiderInfo();

		// Create a new writer
		flWriter = new FileWriter();

	}

	/**
	 * handles the redirecting for mobile site
	 */
	private void mobileSetUp() {

		// parse through data to get just link
		String redirect = getLink(0, 1).get(0);

		// create a start and finish index to get out just the link name
		int begin = redirect.indexOf("http://", 0);
		int end = redirect.indexOf("c", 0);

		// get just the link name
		String redirectLink = redirect.substring(begin + 7, end + 10);

		// throw back as the host name
		this.hostName = redirectLink;

		getMobile = false;

		// run through normal process again
		setUp();

		System.out.println(info.getInfo("REDIRECT"));

		startSpider();
	}

	/**
	 * Starts the spider site program, which gets html from smt.com
	 */
	public void startSpider() {

		// Give message stating you are starting parsing info
		System.out.println(info.getInfo("STARTING"));

		System.out.println(myData);

		// Parse info to get all a link tags
		parser = new Parser(myData);

		myParsedData = parser.getTags("<a ", "</a>");
		System.out.println(myParsedData);

		// checks to see if user wants to spider mobile version
		if (getMobile == true) {
			mobileSetUp();
		}

		// Send links to fileManager to write to files
		writeToFile(flWriter);

		// End class
		System.out.println(info.getInfo("SUCCESS"));
	}

	/**
	 * Parses through collection of <a href tags and gets just the links
	 * 
	 * @param startPoint - where to start parsing of data
	 * @param endPoint - where to end parsing of data from collection
	 * @return - parsed out link(s)
	 */
	protected List<String> getLink(int startPoint, int endPoint) {

		List<String> linkList = new ArrayList<String>();

		for (int i = startPoint; i < endPoint; i++) {
			// Get each menu separately
			String eachLink = myParsedData.get(i);

			// create a start and finish index to get out just the menu name
			int begin = eachLink.indexOf("href=", 0);
			int end = eachLink.indexOf(">", 0);

			// get just the menu name
			String link = eachLink.substring(begin + 6, end - 1);
			System.out.println(link);
			linkList.add(link);

		}
		System.out.println(linkList);
		return linkList;
	}

	/**
	 * Takes a source of data and creates a file from it
	 * 
	 * @param writer
	 * @param startPoint
	 * @param endPoint
	 */
	public void writeToFile(FileWriter writer) {

		for (String menu : getLink(1, 9)) {

			// open global socket
			setSocket(this.hostName, this.portNumber);

			// Write request to server
			myConnect.writeSocket(mySkt, this.hostName, this.requestUrl + menu,
					this.userAgent);

			// save each link to a file
			try {
				flWriter.fileWriter(
						mySkt.getInputStream(),
						info.getInfo("FILE_LOCATION") + menu
								+ info.getInfo("FILE_TYPE_HTML"));

				// other wise give error message
			} catch (IOException e) {
				System.out.println("ERRor over here");
			} catch (Exception e) {
				System.out.println("no over here");
			}

			closeSocket();
		}

	}

	/**
	 * Sets the socket
	 * 
	 * @param src
	 * @param portNum
	 */
	public void setSocket(String host, int portNum) {
		// Connect to server
		myConnect = new Connection();

		mySkt = myConnect.getSocketConnection(host, portNum);

	}

	/**
	 * Closes the socket
	 */
	public void closeSocket() {

		// close socket
		try {
			mySkt.close();
		} catch (IOException e) {
			// give message if failed to close
			System.out.println(info.getInfo("ERROR_SOCKET"));
		}
	}
}