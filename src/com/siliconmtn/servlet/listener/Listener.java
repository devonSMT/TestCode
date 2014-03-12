package com.siliconmtn.servlet.listener;

//servlet-api
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//Log4j 1.2.15
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.siliconmtn.servlet.Config;

/****************************************************************************
 * <b>Title</b>: Listerner.javaIncomingDataWebService.java
 * <p/>
 * <b>Project</b>: WebTestRAMDataFeed
 * <p/>
 * <b>Description: </b> <b>Copyright:</b> Copyright (c) 2014
 * <p/>
 * <b>Company:</b> Silicon Mountain Technologies
 * <p/>
 * 
 * @author Devon
 * @version 1.0
 * @since 11:45:56 AM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/

public class Listener implements ServletContextListener {

	/*
	 * This class runs once and only once when the server starts and does any
	 * configuration that the application needs
	 */

	private static final Logger myLog = Logger.getLogger(Listener.class.getName());

	private Config cf = new Config();
	private String actualPath;

	@Override
	/**
	 *  Handles the event when the app is initialized(starts)
	 */
	public void contextInitialized(ServletContextEvent sce) {

		try {
			ServletContext sc = sce.getServletContext();
			String root = sc.getInitParameter(cf.getGlobalConfig("LOGGER_NAME"));
			actualPath = sc.getRealPath(root);

			PropertyConfigurator.configure(actualPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//won't show
		myLog.debug(actualPath);
		//will show
		myLog.error(actualPath);
	

	}

	@Override
	/**
	 * Handles the event when the app is destroyed(ends)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		myLog.error("Life cycle is over.");

	}

}
