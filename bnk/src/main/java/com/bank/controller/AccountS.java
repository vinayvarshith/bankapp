package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountS
 */
public class AccountS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if(session == null)
		{
			out.print("<center><h1>Please Login First</h1></center>");
			out.print("<h4><a href='/bank1'>Click here to Login </a> ");
		}else {
			out.println("<h1>Account Opend SuccessFul</h1>");
			out.println("<h1>Your Details:</h1><br><h1>"+session.getAttribute("name")+"</h1>");
			out.println("<h1> Your Customer ID:"+session.getAttribute("cust_id")+"</h1>");
			out.println("<h1> Your AADHAR NO :"+session.getAttribute("aadhar")+"</h1>");
			out.print("<center><h2>This is Your Account Number please Note it:"+session.getAttribute("accountNumber")+"</h2></center>");
			out.print("<h1>Thank You</h1>");
			out.print("<p><a href='/bank1/mainMenu.html'>Click Here to go to MainMenu</a></p>");
			
			
		}
	}

}
