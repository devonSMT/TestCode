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

public abstract class SpiderSite {

	// Set up all variables needed for class
	protected Parser parser;
	protected Connection myConnect;
	protected FileWriter flWriter;
	protected Socket mySkt;

	protected SpiderInfo info = null;
	protected StringBuilder allData = null;
	protected List<String> myParsedLinks = null;
	protected String hostName = "";
	protected int portNumber = 0;

	//Class Constructor
	public SpiderSite() {
	
	}
	/**
	 * Subclass must provide body for method
	 */
	public abstract void spiderProgram();
	
	/**
	 * sets list of links by parsing through collection of total data
	 */
	public void setAllLinks(){
		parser = new Parser(allData);

		myParsedLinks = parser.getTags("<a ", "</a>");

	}

	/**
	 * Takes a source of data and creates a file from it
	 * 
	 * @param writer
	 * @param startPoint
	 * @param endPoint
	 */
	public void writeToFile(List<String> data) {

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