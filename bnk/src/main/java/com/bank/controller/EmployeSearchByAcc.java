package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BankException;
import com.bank.service.BankSearchService;
import com.bank.serviceimpl.BankSearchServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeSearchByAcc
 */
public class EmployeSearchByAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BankSearchService bnk=new BankSearchServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeSearchByAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		Long q = Long.parseLong(request.getParameter("cust_accno"));
		//session.getAttribute("userId");
		PrintWriter out=response.getWriter();
		System.out.println(q);
		
		try {
			out.print(gson.toJson(bnk.getBalanceByAccountNumber(q)));
			
			System.out.println(bnk.getBalanceByAccountNumber(q));
		} catch (BankException e) {
			
			out.print(e.getMessage());
		
		}
	}

	
}
