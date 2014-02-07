package com.siliconmtn.spider.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/****************************************************************************
 * <b>Title</b>: InputStreamToFile.javaIncomingDataWebService.java
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
 * @since 8:24:52 AM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class FileWriter {

	// Set defaults for variables
	private OutputStream outputStream = null;
	
	/**
	 * General Class Constructor
	 */
	public FileWriter(){
		//empty constructor
	}

	/**
	 * Takes a stream and writes to specific file location
	 * @param data - an input stream source
	 * @param pathToFile - a full path to where file should be stored
	 * @throws Exception - May throw error if file cannot be written to location
	 */
	public void fileWriter(InputStream data, String pathToFile)
			throws Exception {

		// write the inputStream to a FileOutputStream
		outputStream = new FileOutputStream(new File(pathToFile));

		int read = 0;

		// Create a byte array and give a default size
		byte[] bytes = new byte[1000];

		// read will first go through the stream, read the stream as bytes
		// and store it in a byte array.
		// Then return the # of bytes read as an integer.
		// If at end of file will return -1
		while ((read = data.read(bytes)) != -1) {
			
			// write takes three parameters.
			// first the data to write
			// second where to start at
			// third the number of bytes to write
			outputStream.write(bytes, 0, read);
		}
		// Give message if succeeded
		System.out.println("File was created!");

		// When finished clean up
		cleanUp(data, outputStream);

	}

	/**
	 * Closes a input and output stream
	 * 
	 * @param in
	 * @param out
	 */
	protected void cleanUp(InputStream in, OutputStream out) {

		// Input is already open so just close it
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Output stream default is set to null so if not null has been opened
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		
	}
}
