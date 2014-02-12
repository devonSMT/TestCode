package com.siliconmtn.spider.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/****************************************************************************
 * <b>Title</b>: DataFetcher.javaIncomingDataWebService.java
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
 * @since 5:13:06 PM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class Connection {

	// Variables needed for class
	private Socket clientSocket = null;

	/**
	 * Class Constructor 
	 */
	public Connection() {
		//empty constructor
	}

	/**
	 * Tries to connect to source's end point/server with a given source name
	 * 
	 * @param hostName
	 *            - Pass in a source(such as a web site address)
	 * @param portNumber
	 *            - Port to which source belongs
	 */
	public Socket getSocketConnection(String sourceAddr, int portNumber){
		//Should try to connect to source/data that was given

		try {
		//Create a SocketAddress first
		InetAddress addr = InetAddress.getByName(sourceAddr);

		SocketAddress sockAdr = new InetSocketAddress(addr, portNumber);

		//Create a new socket and assign to global socket
		this.clientSocket = new Socket();

		//Set a timeout for connecting to server/source
		clientSocket.connect(sockAdr, 5000);

		//Give message if succeeded
		System.out.println("Connection was successful");


		} catch (UnknownHostException e) {
		//give message if cannot found the host
		System.out.println("Unknown host. Please check host name.");

		} catch (IOException e) {
		// otherwise give other error why could not connect
		System.out.println("Connection failed. Please verify information.");
		}

		return clientSocket;

		}

	/**
	 * Writes to given source through a given socket with several headers
	 * 
	 * @param clientSocket
	 *            - a socket object
	 * @param requestURL
	 *            - full source address(Such as http://web url)
	 */
	public void writeSocket(Socket clientSocket, String hostName, String requestURL, String userAgent) {

		// Create print stream so can write to source/data/server
		PrintStream clientPrinter = null;

		try {
			clientPrinter = new PrintStream(clientSocket.getOutputStream());
			// Write to source/server
			clientPrinter.println("GET " + requestURL + " HTTP/1.1");
			clientPrinter.println("Host: " + hostName);
			clientPrinter.println("Accept: */*");
			clientPrinter.println("User-Agent: " + userAgent); 																													
			clientPrinter.println(""); // Make sure to end request here						
			
		} catch (IOException e) {
			// If cannot open give error message
			System.out.println("Could not open stream.");

		}
	}

	/**
	 * Catches back response from server and builds it together
	 * 
	 * @param clientSocket
	 * @return StringBuilder object
	 */
	public StringBuilder dataCompiler(Socket clientSocket) {

		// Create a StrigBuilder to hold info
		StringBuilder fullSource = new StringBuilder();
	

		// Try to read back info from server
		try {
			InputStream myReader = clientSocket.getInputStream();
			
			int line = 0;
			
			int c = 0;

			while ((c = myReader.read()) > -1) {
				fullSource.append((char) c);
			}
			
			//myReader.close();
			
		} catch (IOException e) {
			// give message if failed
			//System.out.println("error here");
			e.printStackTrace();
		}

		return fullSource;
		
	}

}
