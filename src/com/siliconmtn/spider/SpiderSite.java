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
	private String userAgent = "Mozilla/5.0 (Linux; U; Android 4.1.1; WOW64; rv:26.0) Gecko/20100101 Mobile Safari/534.0";
	private int portNumber = 80;
	private boolean getMobile = false;

	/**
	 * Main Method, sets up the class then runs it
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		SpiderSite spider = new SpiderSite(true);

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
	 *            - use true of false for which site to parse through
	 */
	public SpiderSite(boolean useMobile) {
		this.getMobile = useMobile;
	}

	/**
	 * Sets up the class for use
	 */
	public void setUp() {

		info = new SpiderInfo();
		
		// If user wants mobile use mobile setup
		if (getMobile == true) {
			mobileSetUp();
			
		} else {
			//Just spider desktop version of site
			setSocket(this.hostName, this.portNumber);

			myConnect.writeSocket(mySkt, this.hostName);

			myData = myConnect.dataCompiler(mySkt);

			closeSocket(mySkt);

		}

	}

	/**
	 * sets up the class for mobile version
	 */
	private void mobileSetUp() {

		setSocket(this.hostName, this.portNumber);

		myConnect.writeSocket(mySkt, this.hostName, this.requestUrl,
				this.userAgent);

		myData = myConnect.dataCompilerReset(mySkt);

		setAllLinks();
		
		getMobileLink();

		closeSocket(mySkt);
		
		// Redirect then get page for mobile
		System.out.println(info.getInfo("REDIRECT"));

		setSocket(this.hostName, this.portNumber);

		myConnect.writeSocket(mySkt, this.hostName);

		// Catch back info from server/source
		myData = myConnect.dataCompiler(mySkt);

		closeSocket(mySkt);
	}

	/**
	 * Starts the spider site program, which gets html from smt.com
	 */
	public void startSpider() {

		// Give message stating you are starting parsing info
		System.out.println(info.getInfo("STARTING"));
		
		System.out.println(myData);

		setAllLinks();

		// get just the raw links
		List<String> myFinalData = parseLink(1, 9);

		flWriter = new FileWriter();
		writeToFile(flWriter, myFinalData);

		// End class
		if(flWriter != null)System.out.println(info.getInfo("SUCCESS"));
	}
	
	/**
	 * method to help get mobile link for redirect
	 */
	public void getMobileLink(){
		// parse through data to get just link
		String redirect = parseLink(0, 1).get(0);

		// create a start and finish index to get out just the link name
		int begin = redirect.indexOf("http://", 0);
		int end = redirect.indexOf("c", 0);

		// get just the link name
		String redirectLink = redirect.substring(begin + 7, end + 10);
		
		this.hostName = redirectLink;
	}
	
	/**
	 * sets list of links by parsing through collection of total data
	 */
	private void setAllLinks(){
		parser = new Parser(myData);

		myParsedData = parser.getTags("<a ", "</a>");

	}

	/**
	 * Parses through collection of <a href tags and gets just the links
	 * 
	 * @param startPoint
	 *            - where to start parsing of data
	 * @param endPoint
	 *            - where to end parsing of data from collection
	 * @return - parsed out link(s)
	 */
	public List<String> parseLink(int startPoint, int endPoint) {

		List<String> linkList = new ArrayList<String>();

		for (int i = startPoint; i < endPoint; i++) {

			String eachLink = myParsedData.get(i);

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
	public void writeToFile(FileWriter writer, List<String> data) {

		for (String menu : data) {

			// open global socket
			setSocket(this.hostName, this.portNumber);

			myConnect.writeSocket(mySkt, this.hostName + menu);

			// save each link to a file
			try {
				flWriter.fileWriter(
						mySkt.getInputStream(),
						info.getInfo("FILE_LOCATION") + menu
								+ info.getInfo("FILE_TYPE_HTML"));

				// other wise give error message
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			closeSocket(mySkt);
		}

	}

	/**
	 * Sets the socket
	 * 
	 * @param src
	 * @param portNum
	 */
	public void setSocket(String host, int portNum) {

		myConnect = new Connection();

		mySkt = myConnect.getSocketConnection(host, portNum);

	}

	/**
	 * Tries to close the socket
	 */
	public void closeSocket(Socket socket) {

		try {
			socket.close();
		} catch (IOException e) {
			System.out.println(info.getInfo("ERROR_SOCKET"));
		}
	}
}