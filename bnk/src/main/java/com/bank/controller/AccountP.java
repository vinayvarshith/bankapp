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
import com.bank.model.Account;
import com.bank.service.BankCrudService;
import com.bank.serviceimpl.BankCrudServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class AccountP
 */
public class AccountP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankCrudService bankCrudService = new BankCrudServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountP() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out=response.getWriter();
		RequestDispatcher requestDispatcher=null;
		response.setContentType("text/html");

			Gson gson = new Gson();
			Account account=new Account();
			session.setAttribute("userId1", account.getCust_id());
			session.setAttribute("openingBalance", account.getOpen_bal());
			try {
				account = bankCrudService.createAccount(account);
				session.setAttribute("accountNumber", account.getCust_accno());
				response.sendRedirect("AccountS");
				
			} catch (BankException e) {
				requestDispatcher=request.getRequestDispatcher("account.html");
				requestDispatcher.include(request, response);
				out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
			}
		
		out.print("<a href='logout'>Click Here to LOGOUT</a>");
	}

}
