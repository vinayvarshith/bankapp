package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.exception.BankException;
import com.bank.model.Employee;
import com.bank.service.LoginService;
import com.bank.serviceimpl.LoginServiceImpl;


/**
 * Servlet implementation class EmployeLoginServlet
 */
public class EmployeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeLoginServlet() {
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
		Employee emp=new Employee();
		
		String emp_id=request.getParameter("emp_id");
		String emp_pwd=request.getParameter("emp_pwd");
		
		
		LoginService loginService=new LoginServiceImpl();
		RequestDispatcher requestDispatcher=null;
		System.out.println("hello.....");
		try {
			if(loginService.isValidLoginEmployee(emp_id,emp_pwd)) {
			
				System.out.println("welcome.... ");
				
			   HttpSession session=request.getSession();
						session.setAttribute("emp_id", emp_id);


				requestDispatcher=request.getRequestDispatcher("SuccessServlet");
				requestDispatcher.include(request, response);
				requestDispatcher.forward(request, response);
			}
		} catch (BankException e) {
			//failure
			PrintWriter out=response.getWriter();
			requestDispatcher=request.getRequestDispatcher("welcome.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'> try again "+e.getMessage()+"</span></center>");
			
		}
	}

}
