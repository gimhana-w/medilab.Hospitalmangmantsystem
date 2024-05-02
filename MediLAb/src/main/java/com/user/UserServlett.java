package com.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlett
 */
@WebServlet("/UserServlett")
public class UserServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("uid");
		String password=request.getParameter("pass");
		
		
		try {
			
		List<User> ussDetails = UserDButil.validate(email, password);    //for if any error,print
		request.setAttribute("UssDetails", ussDetails); 
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis =request.getRequestDispatcher("profile.jsp");
		
		dis.forward(request, response);
	
		
		
	}

}
