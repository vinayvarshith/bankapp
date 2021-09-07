package com.bank.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BankException;
import com.bank.model.Customer;
//import com.projec1.model.User;
import com.bank.service.LoginService;
import com.bank.serviceimpl.LoginServiceImpl;
//import com.project1.exception.BankingException;

/**
 * Servlet implementation class custLoginServlet
 */
public class custLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public custLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	
		String cust_id=request.getParameter("id");
		String cust_pwd=request.getParameter("password");
		
		LoginService loginService=new LoginServiceImpl();
		
		RequestDispatcher requestDispatcher=null;
		
		try {
			if(loginService.isValidLoginCustomer(cust_id,cust_pwd)){
				requestDispatcher=request.getRequestDispatcher("customertask.html");
				requestDispatcher.include(request, response);
			}
		} catch (BankException e) {
			//failure
			PrintWriter out=response.getWriter();
			requestDispatcher=request.getRequestDispatcher("index.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
			
		}
	}

}
