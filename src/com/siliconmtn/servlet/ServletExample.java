package com.siliconmtn.servlet;

import java.io.IOException;


//SMTAPPLibraries
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Class will model MVC architecture, will be controller and send out info
 * to the view 
 */

/**
 * Servlet implementation class ServletTest2
 */

public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Config config = new Config();
	
	/**
	 * Class Constructor 
	 */
	public ServletExample() {
		super();
		// empty
	}
	
	/**
	 * Method that does any require initialization for entire life cycle
	 */
	public void init(ServletConfig config) throws ServletException {
		//empty
	}

	/**
	 *Handles a get request, creates a message and forwards it on
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// set the attribute
		String message = "My name is devon what's yours?";
		request.setAttribute("message", message);

		RequestDispatcher view = request
				.getRequestDispatcher(config.getGlobalConfig("JSP_LOCAL"));

		view.forward(request, response);

	}
}
