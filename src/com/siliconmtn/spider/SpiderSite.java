package com.siliconmtn.spider;

import java.io.IOException;
import java.net.Socket;
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
	private Connection connect;
	private FileWriter flWriter;

	private SpiderInfo info = null;
	private StringBuilder spiderBuilder = null;
	private List<String> links = null;
	private Socket mySkt;
	private String sourceAddr = "www.siliconmtn.com";
	private String fullSource = "http://www.siliconmtn.com";
	private int portNumber = 80;

	/**
	 * Main Method, sets up the class then runs it
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		SpiderSite spider = new SpiderSite();

		// set up class
		spider.setUp();

		// run the class
		spider.startSpider();

	}

	/**
	 * Class Constructor, takes source data and port #
	 */
	public SpiderSite() {
		// empty Constructor
	}

	/**
	 * Sets up the class so the class can be used
	 */
	public void setUp() {

		// Connect to server
		setSocket("", this.portNumber);

		// Catch back info from server/source
		spiderBuilder = connect.dataCompiler(mySkt);

		// Close the socket
		closeSocket();

		// Create instance of info for messages
		info = new SpiderInfo();

		// Create a new writer
		flWriter = new FileWriter();
	}

	/**
	 * Starts the spider site program, which gets html from smt.com
	 */
	public void startSpider() {

		// Give message stating you are starting parsing info
		System.out.println(info.getInfo("STARTING"));

		// Parse info to get all a link tags
		parser = new Parser(spiderBuilder);

		links = parser.getTags("<a ", "</a>");
		System.out.println(links);

		// Send links to fileManager to write to files
		writeToFile(flWriter, 1, 9);

		// End class
		if (mySkt.isClosed()) {
			System.out.println(info.getInfo("SUCCESS"));
		}

	}

	public void writeToFile(FileWriter writer, int startPoint, int endPoint) {
		// loop through list of links
		for (int i = startPoint; i < endPoint; i++) {
			// Get each menu separately
			String eachLink = links.get(i);

			// create a start and finish index to get out just the menu name
			int begin = eachLink.indexOf("href=", 0);
			int end = eachLink.indexOf(">", 0);

			// get just the menu name
			String menu = eachLink.substring(begin + 6, end - 1);
			System.out.println(menu);

			// open global socket
			setSocket(menu, this.portNumber);

			// save each link to a file
			try {
				flWriter.fileWriter(
						mySkt.getInputStream(),info.getInfo("FILE_LOCATION") 
						+ menu+ info.getInfo("FILE_TYPE_HTML"));

				// other wise give error message
			} catch (IOException e) {
				System.out.println(info.getInfo("ERROR_FILE"));
			} catch (Exception e) {
				System.out.println(info.getInfo("ERROR_FILE"));
			}

			// close socket
			closeSocket();
		}

	}

	/**
	 * Sets the socket and writes to it
	 * 
	 * @param src
	 * @param portNum
	 */
	public void setSocket(String menu, int portNum) {
		// Connect to server
		connect = new Connection();

		mySkt = connect.getConnection(this.sourceAddr, portNum);

		// Write request to server
		connect.writeConnection(mySkt, this.fullSource + menu);
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
