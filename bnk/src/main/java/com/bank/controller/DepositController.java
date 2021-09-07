package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.exception.BankException;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.service.BankCrudService;
import com.bank.service.BankSearchService;
import com.bank.serviceimpl.BankCrudServiceImpl;
import com.bank.serviceimpl.BankSearchServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class DepositController
 */
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankCrudService bankCrudService = new BankCrudServiceImpl();
	private BankSearchService bankSearchService = new BankSearchServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out=response.getWriter();
		RequestDispatcher requestDispatcher=null;
		response.setContentType("text/html");
		String id=(String)session.getAttribute("userid");
		Long accountNumber=0l;
		try {
			Account acc=bankSearchService.getDetailsByCustomerId(id);
			 accountNumber=acc.getCust_accno();
		} catch (BankException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(accountNumber==0l) {
			requestDispatcher=request.getRequestDispatcher("deposit.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>iNVALID CUSTUMER iD Or You Dont Opened Your Account Yet ...first open Your account</span></center>");
		}

			Gson gson=new Gson();
			double amount=Double.parseDouble(request.getParameter("amount"));
			Transaction transaction=new Transaction();
			 try {
			
				 Account account = bankSearchService.getBalanceByAccountNumber(accountNumber);
				 double openingBalance = account.getOpen_bal();
				 Transaction transaction1=new Transaction(accountNumber, amount, openingBalance,openingBalance+amount , "Deposit");
					transaction = bankCrudService.depositAmount(transaction1);
					session.setAttribute("accNo", transaction1.getCust_accno());
					session.setAttribute("opnbal", transaction1.getOpen_bal1());
					session.setAttribute("clsbal", transaction1.getClose_bal());
					session.setAttribute("transid", transaction.getTrans_id());
					session.setAttribute("amountD", amount);
					System.out.println(transaction1);
				} catch (BankException e) {
					requestDispatcher=request.getRequestDispatcher("deposit.html");
					requestDispatcher.include(request, response);
					out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
				}
			out.print("<a href='mainMenu.html'>click here to go to main menu</a> ");

			 response.sendRedirect("DepositSuccess");
				response.setContentType("application/json;charset=UTF-8");
		}

		
		
	

}
