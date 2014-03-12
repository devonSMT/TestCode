package com.siliconmtn.spider.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/****************************************************************************
 * <b>Title</b>: Server.javaIncomingDataWebService.java
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
 * @since 12:14:11 PM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class Server {

	ServerSocket mySS = null;
	String line;
	BufferedReader myReader;
	PrintStream os;
	Socket clientSocket = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Server myServ = new Server();
		myServ.run();
	}

	/**
	 * 
	 */
	public void run() throws Exception {

		// Create a server socket object and tell it what port to listen on
		mySS = new ServerSocket(51649);
		
		System.out.println("You're port is " + mySS.getLocalPort());
		
		// create socket to accept any info that comes to this ServerSocket
		clientSocket = mySS.accept();

		// Open input stream
		myReader = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		// Create string to hold input from myReader
		String temp = myReader.readLine();

		// Display to console
		System.out.println(temp);

		//Display only if someone sends some information to server
		if (temp != null) {
			
			// Open output stream
			PrintStream mySSPrint = new PrintStream(
					clientSocket.getOutputStream());

			// give message back to client
			mySSPrint.println("It's going pretty good.");
			
			//display to console
			System.out.println("Information sent to client..");
		}

	}

}
