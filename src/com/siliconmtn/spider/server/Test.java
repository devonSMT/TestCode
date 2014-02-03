package com.siliconmtn.spider.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/****************************************************************************
 * <b>Title</b>: Test.javaIncomingDataWebService.java
 * <p/>
 * <b>Project</b>: WorkingWithStreamsRAMDataFeed
 * <p/>
 * <b>Description: </b> <b>Copyright:</b> Copyright (c) 2014
 * <p/>
 * <b>Company:</b> Silicon Mountain Technologies
 * <p/>
 * 
 * @author Devon
 * @version 1.0
 * @since 8:43:40 AM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class Test {

	// A test class

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// client example

		// create a socket
		Socket mySocket = new Socket("localhost", 51649);

		// Create output stream to talk to server
		PrintStream specialPen = new PrintStream(mySocket.getOutputStream());

		// Say something to server
		specialPen.println("How's your day going?");

		// Create input stream to receive info from server
		BufferedReader specialGlasses = new BufferedReader(
				new InputStreamReader(mySocket.getInputStream()));
		
		//Create string to hold that info
		String ohISee = specialGlasses.readLine();
		
		//Display to console
		System.out.println(ohISee);
		
		//Close the socket
		mySocket.close();
		
	}

}
