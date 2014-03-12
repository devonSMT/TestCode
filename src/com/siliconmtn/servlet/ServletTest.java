package com.siliconmtn.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletConfig;
//SMTAPPLibraries
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *Class will receive back either a post or get request and send an appropriate 
 * response back
 */

/**
 * Servlet implementation class ServletTest
 */

public class ServletTest extends HttpServlet {

	// Class variables
	private static final long serialVersionUID = 1L;
	private String message;

	/**
	 * Method that does any require initialization for entire life cycle
	 */
	public void init(ServletConfig config) throws ServletException {
		//Initialize the servlet
		super.init(config);
		message = "Hello out there";
	}

	/**
	 * Handles a post request when sent to servlet and returns a response form
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// catch back name from submitted form
		String name = request.getParameter("name");
		String pass = request.getParameter("password");

	    // Set refresh, auto load time as 5 seconds
	    response.setIntHeader("Refresh", 10);
		
		// Set response content type
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		out.println("<h1>" + message + "</h1> <h3> " + name + "</h3>");
		out.println("<h3> your password is " + pass + "</h3>");

		out.println("<a href=\"ServletExample\">Return to Previous Page</a>");

		out.close();
	}
	
	/* 
	 * Method to handle GET request
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	    // Set refresh, auto load time as 5 seconds
	    resp.setIntHeader("Refresh", 10);
	    
		PrintWriter pw = resp.getWriter();
		
		pw.println("<title>Example with GET request</title>");
		pw.println("<h2> You referred to this page with a get request </h2>");
		pw.println("<a href=\"ServletExample\">Return to Previous Page</a>");
		pw.close();
	}
	/**
	 * Method that handles any clean up when servlet is finished makes the
	 * servlet eligible for GC
	 */
	@Override
	public void destroy() {
		super.destroy();
		// Does nothing for now
	}

}
