package com.siliconmtn.servlet;

// J2EE 1.5
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
	protected ServletContext ctx = null;
	
	String jspFile = null;
	
	/**
	 * Method that does any require initialization for entire life cycle
	 */
	public void init(ServletConfig scon) throws ServletException {
		super.init(scon);
		ctx = scon.getServletContext();
		jspFile = config.getGlobalConfig(Config.JSP_LOCAL_FILE);
	}

	/**
	 *Handles a get request, creates a message and forwards it on
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		// set the attribute
		String message = "My name is devon what's yours?";
		request.setAttribute("message", message);

		request.getRequestDispatcher(jspFile).forward(request, response);

	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
