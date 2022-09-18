package com.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TestDAO test;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    	String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
    	String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	
    	System.out.println(jdbcURL);
    	try {
			test = new TestDAO(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    	String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
    	String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	
    	System.out.println(jdbcURL);
    	try {
			test = new TestDAO(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("login")) {
			
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			
			System.out.println(user);
			System.out.println(pass);
			
			try {
				
				if(test.ingresar(user, pass)) {
					System.out.println("Exito");
				}else {
					System.out.println("Fail :(");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		 
	 
		
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
