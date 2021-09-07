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
 * Servlet implementation class RegistrationsuccessController
 */
public class RegistrationsuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationsuccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		out.print("<h1>Welcome "+session.getAttribute("cust_name")+" ..... You have Registered successfully with michealson Bank at "+new Date()+"</h1>");
		
		out.print("<a href='/bank1'>Click Here to LOGIN</a>");
	}


	

}
