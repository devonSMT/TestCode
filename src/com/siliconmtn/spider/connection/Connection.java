package com.siliconmtn.spider.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/****************************************************************************
 * <b>Title</b>: DataFetcher.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: SpiderProjectRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 5:13:06 PM<p/>
 * <b>Changes: </b>
 ****************************************************************************/

public class Connection {

	//Class that connects to a server
	
	//Variables needed for class
	private Socket clientSocket = null;
	
	/**
	 * Class Constructor, pass a source and port number to try to connect to
	 */
	public Connection(){
		// Set values that were given to local variables
	}
	
	/**
	 * Tries to connect to source's end point/server with a given source name
	 * @param sourceAddr - Pass in a source(such as a web site address)
	 * @param portNumber - Port to which source belongs
	 */
	public Socket getConnection(String sourceAddr, int portNumber){
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
	 * Writes to given source through a given socket
	 * @param clientSocket - a socket object
	 * @param fullAddr - full source address(Such as http://web url)
	 */
	public void  writeConnection(Socket clientSocket, String fullAddr){
		
		//Create print stream so can write to source/data/server
		PrintStream clientPrinter = null;
		
		try {
			clientPrinter = new PrintStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			//If cannot open give error message
			System.out.println("Could not open stream");
			e.printStackTrace();
		}

		// Write to source/server
		clientPrinter.println("GET " + fullAddr);
	}
	
	/**
	 * Catches back response from server and builds it together
	 * @param clientSocket
	 * @return StringBuilder object	
	 */
	public StringBuilder dataCompiler(Socket clientSocket){
		
		// Create a StrigBuilder to hold info
		StringBuilder fullSource = new StringBuilder();
		
		// Try to read back info from server
		try {
			BufferedReader myReader = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
					
			String line = null;
		
					while ((line = myReader.readLine()) != null) {
						// add the lines
						fullSource.append(line);
					}
		} catch (IOException e) {
			// give message if failed
			System.out.println("Could not open stream.");
		}
					
		return fullSource;
	}
}
