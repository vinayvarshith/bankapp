package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.Account;
import com.bank.service.BankCrudService;
import com.bank.serviceimpl.BankCrudServiceImpl;

/**
 * Servlet implementation class OpenAccount
 */
public class OpenAccount extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private BankCrudService bankCrudService = new BankCrudServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		response.setContentType("text/html");
		
		String cust_id=(String)session.getAttribute("userid");
		String name=request.getParameter("name");
		String aadhar=request.getParameter("aadhar");
		double openbal=Double.parseDouble(request.getParameter("openbal"));
		Account account=new Account();
		account.setAadhar(aadhar);
		account.setOpen_bal(openbal);
		
		account.setCust_name(name);
		account.setUserId1(cust_id);
		System.out.println(cust_id+"this is customer id");
		
		try {
			account = bankCrudService.createAccount(account);
			
		
			    session.setAttribute("name",account.getCust_name());
			    session.setAttribute("cust_id", cust_id);
			    session.setAttribute("aadhar", account.getAadhar());
				session.setAttribute("accountNumber", account.getCust_accno());
				 rd=request.getRequestDispatcher("AccountS");
				rd.forward(request, response);
				
		
		}catch(Exception e) {
			rd=request.getRequestDispatcher("openacc.html");
			rd.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
		
		
	}

}
