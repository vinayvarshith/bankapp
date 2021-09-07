package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuccessServlet
 */
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter out=response.getWriter();
         HttpSession session=request.getSession(false);  
	    String emp_id=(String)session.getAttribute("emp_id"); 
		out.print("<h1>Welcome "+emp_id+" ..... You have logged in successfully at "+new Date()+"</h1>");
		
		out.print("<a href='employetask.html'> click Here to Perform Employee Oprtions");
		out.print("<a href='/bank1'>Click Here to LOGOUT</a>");
		
	}

}
