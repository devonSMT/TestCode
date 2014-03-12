package com.siliconmtn.spider.parser;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: Parser.javaIncomingDataWebService.java
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
 * @since 9:15:46 AM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class Parser {

	// Class that helps to parse through a given source

	// variables needed for class
	private List<String> parsedData = null;
	private StringBuilder source = null;
	private List<Integer> startList = null;
	private List<Integer> endList = null;

	/**
	 * Class constructor, requires a source to initialize
	 * 
	 * @param sourceData
	 */
	public Parser(StringBuilder sourceData) {
		this.source = sourceData;
	}

	/**
	 * Gets all the desire tags for a given source
	 * *---Warning should only be used with HTML tags for expected results---*
	 * @return - A list of desired tags in the order they are found
	 */
	public List<String> getTags(String startTag, String endTag) {

		parsedData = new ArrayList<String>();

		// make a list of #'s for the start and end tags locations
		startList = getLocation(startTag);
		endList = getLocation(endTag);

		// loop through source to find based on tags locations
		for (int i = 0; i < startList.size(); i++) {

			// Create parameters for a start and end point
			int start = startList.get(i);
			int end = endList.get(i);
			
			// parse out info and put into list
			parsedData.add(source.toString().substring(start, end));
		}
		return parsedData;
	}

	/**
	 * Parses source and returns locations of a given string
	 * 
	 * @return - a list of #'s representing every location of parseInfo instance
	 */
	public List<Integer> getLocation(String parseInfo) {
		// Create list to hold values
		List<Integer> values = new ArrayList<Integer>();

		// Loop through data
		int bit = 0;
		while (bit > -1) {
			bit = source.toString().indexOf(parseInfo, bit);

			// If it finds a match will put location into list
			if (bit > -1) {
				values.add(bit);
				bit++;
			}
		}
		return values;
	}


	/**
	 * Parses through collection a <a tags to get just bare link
	 * 
	 * @param startPoint  where to start parsing of data
	 * @param endPoint  where to end parsing of data from collection
	 * @return - parsed out link(s)
	 */
	public List<String> parseLink(List<String>parsedLinks, int startPoint, int endPoint) {

		List<String> linkList = new ArrayList<String>();

		for (int i = startPoint; i < endPoint; i++) {

			String eachLink = parsedLinks.get(i);

			int begin = eachLink.indexOf("href=", 0);
			int end = eachLink.indexOf(">", 0);

			// get just the menu name
			String link = eachLink.substring(begin + 6, end -1);
			System.out.println(link);
			linkList.add(link);

		}
		return linkList;
	}

	/**
	 * @return the parsedData
	 */
	public List<String> getParsedData() {
		return parsedData;
	}

	/**
	 * @return the source
	 */
	public StringBuilder getSource() {
		return source;
	}

	/**
	 * @return the startList
	 */
	public List<Integer> getStartList() {
		return startList;
	}

	/**
	 * @return the endList
	 */
	public List<Integer> getEndList() {
		return endList;
	}

}
