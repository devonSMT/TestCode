package com.siliconmtn.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import com.siliconmtn.servlet.listener.Listener;

/*
 * Class will map to specific URL to intercept a request to a given URL and 
 * perform actions before letting the request continue on
 */

/**
 * Servlet Filter implementation class FilterExample
 */
public class FilterExample implements Filter {
 
	private static final Logger myLog = Logger.getLogger(Listener.class.getName());
	
	/**
	 * called before the filter ends
	 */
	public void destroy() {
		
	}

	/**
	 * Handles the initialization of the filter
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	/**
	 * will print out the client address and name of server
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String client = request.getRemoteAddr();
		String host = request.getLocalName();
		
		myLog.info("Client address:" + client +" HostName:" + host);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
