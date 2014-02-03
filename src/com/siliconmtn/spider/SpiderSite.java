package com.siliconmtn.spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.siliconmtn.spider.file.ToFile;
/****************************************************************************
 * <b>Title</b>: Client.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: WorkingWithStreamsRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 12:04:16 PM<p/>
 * <b>Changes: </b>
 ****************************************************************************/


public class SpiderSite {

	// Variables that are needed
	private ToFile converter = null;
	private SpiderInfo msg = new SpiderInfo();
	private String subList = "";
	private final String siteName = "www.siliconmtn.com";
	
	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		SpiderSite mySpider = new SpiderSite();
		mySpider.run();

	}

	/**
	 * Creates a socket, writes to it, then receives info back
	 * 
	 * @throws Exception
	 */
	public void run() throws Exception {

		// get socket and write to it
		Socket mySkt = getSocket("");

		// Get the main page and create a sublist from it
		getInitialPage(mySkt);

		//Parse out the page to save each top menu file
		parseToSave();
	}

	/**
	 * Gets the initial page to start parsing process
	 * 
	 * @param mainSocket
	 * @throws Exception
	 */
	public void getInitialPage(Socket mainSocket) throws Exception {
		// Read back info from server
		BufferedReader myReader = new BufferedReader(new InputStreamReader(
				mainSocket.getInputStream()));

		// Turn stream into a string
		StringBuilder wholePage = buildString(myReader);

		// Make a sublist of the wholePage, sublist will now be set
		setSubList(wholePage);

		// When finished close socket
		mainSocket.close();
	}
	
	/**
	 * Method that parses the page then saves each file to computer
	 * @throws Exception
	 */
	public void parseToSave () throws Exception{

		// Parse through smaller list to get all start places of <a tags
		List<Integer> startLocation = getLocation(msg.getInfo("<A"));

		// Do the same for the end positions of <a tags
		List<Integer> endLocation = getLocation(msg.getInfo("</A>"));

		// Parse out the names to get actual page then save each one
		savePage(getLink(startLocation, endLocation));

	}
	/**
	 * 
	 * @param links
	 * @throws Exception
	 */
	public void savePage(List<String> links) throws Exception {

		// Create an instance of inputStream class
		converter = new ToFile();
		
		//loop through each link and save them
		for (String link : links) {
			// create a start and finish index to get out just the menu name
			int begin = makeIndex(link, msg.getInfo("HREF="));
			int end = makeIndex(link, msg.getInfo("END_TAG"));

			// get just the menu name
			String menu = link.substring(begin + 6, end - 1);

			// get socket for SMT web site
			Socket otherSkt = getSocket(menu);

			// Create and save the file
			converter.convertToFile(otherSkt.getInputStream(), menu);

			// When finished close socket
			otherSkt.close();

		}
	}

	/**
	 * Creates a socket, writes to it
	 * 
	 * @param menu
	 * @return the socket
	 * @throws Exception
	 */
	public Socket getSocket(String menu) throws Exception {

		// Create a client socket to try to connect to server
		Socket clientSkt = new Socket(siteName, 80);

		// Open out put stream to send to server
		PrintStream myPrint = new PrintStream(clientSkt.getOutputStream());

		// Write to server
		myPrint.println(msg.getInfo("GET_HTTP") + siteName + menu);

		return clientSkt;
	}

	/**
	 * Parse's through a block of code and returns a list of links
	 * 
	 * @param data
	 * @return
	 */
	public List<String> getLink(List<Integer> dataStart,
			List<Integer> dataFinish) {

		// Create List of Strings
		List<String> titles = new ArrayList<String>();
		// loop through list of numbers and pull out each one
		for (int i = 0; i < dataStart.size(); i++) {

			// create more indexes to get menu names
			int str = dataStart.get(i);
			int fin = dataFinish.get(i);

			// parse through sublist and add to list
			String menu = subList.substring(str, fin);
			titles.add(menu);
			System.out.println(titles);
		}

		return titles;
	}

	/**
	 * Loops through a block of code and returns positions into a list
	 * 
	 * @return
	 */
	public List<Integer> getLocation(String parseInfo) {
		// Create list to hold values
		List<Integer> values = new ArrayList<Integer>();

		// Loop through small list of data
		int bit = 0;
		while (bit > -1) {
			bit = subList.indexOf(parseInfo, bit);

			// If it finds a match will put location into list
			if (bit > -1) {
				values.add(bit);
				bit++;
			}
		}
		return values;
	}

	/**
	 * Takes a StringBuilder and parses through and returns a sublist
	 * 
	 * @param totalData
	 */
	public void setSubList(StringBuilder totalData) {

		// Create parameters to start and finish parsing through
		int start = makeIndex(totalData.toString(), msg.getInfo("SMT_MENU"));
		int end = makeIndex(totalData.toString(), msg.getInfo("</UL>"));

		// pull out info and put into list
		subList = totalData.toString().substring(start, end);

		System.out.println(subList);
	}

	/**
	 * 
	 * Reads a stream, and builds it together
	 * 
	 * @throws Exception
	 */
	public StringBuilder buildString(BufferedReader reader) throws Exception {
		// Create a String to hold each line from input
		String line = null;

		// Make StringBuilder to add all strings together
		StringBuilder builder = new StringBuilder();

		// Display to console
		while ((line = reader.readLine()) != null) {
			// add the lines
			builder.append(line);
		}
		return builder;
	}

	/**
	 * Creates an index from a source
	 * 
	 * @param index
	 * @return
	 */
	public int makeIndex(String source, String word) {

		// create integer to hold index
		int index = -1;

		// index the source and return a number
		index = source.indexOf(word);

		return index;
	}

}
