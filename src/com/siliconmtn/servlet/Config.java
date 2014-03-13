package com.siliconmtn.servlet;

import java.util.HashMap;

/****************************************************************************
 * <b>Title</b>: Config.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: WebTestRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 8:00:08 AM<p/>
 * <b>Changes: </b>
 ****************************************************************************/

public class Config {

	private HashMap<String, String> config = new HashMap<String, String>();

	public static final String JSP_LOCAL_FILE = "jspLocal";
	public static final String LOGGER_NAME = "logName";
	
	// Class Constructor that returns all configurations automatically
	public Config() {
		this.getAllConfigs();
	}
	
	/**
	 *Give a string and return the value for that config 
	 * @param msg
	 * @return value based on the key
	 */
	public String getGlobalConfig(String msg){
		return config.get(msg);
	}
	
	/**
	 * Returns all configs
	 * @return configs for application
	 */
	protected HashMap<String, String> getAllConfigs() {
		config.put(LOGGER_NAME, "log4jConfig");
		config.put(JSP_LOCAL_FILE, "/WEB-INF/include/test.jsp");
		return config;
	}
}
