package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bank.exception.BankException;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.service.BankCrudService;
import com.bank.serviceimpl.BankCrudServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class BankCrudController
 */
public class BankCrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static Logger log = Logger.getLogger(BankCrudController.class);
    public BankCrudController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private BankCrudService bankCrudService=new BankCrudServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		try {
			out.print(gson.toJson(bankCrudService.getAllAccounts()));
		} catch (BankException e) {
			
			log.info(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		Customer customer=gson.fromJson(request.getReader(), Customer.class);
		RequestDispatcher requestDispatcher1=null;
		try {
			customer=bankCrudService.registerAccount(customer);
			HttpSession session=request.getSession();
			session.setAttribute("cust_name", customer.getCust_name());
			//	response.sendRedirect("rsuccess");
			RequestDispatcher rd=request.getRequestDispatcher("rsuccess");
			rd.forward(request, response);
		//	log.info(customer);
		} catch (BankException e) {
			System.out.println(e);
			PrintWriter out=response.getWriter();
			requestDispatcher1=request.getRequestDispatcher("welcome.html");
			requestDispatcher1.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print(gson.toJson(customer));
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		Transaction transaction=gson.fromJson(request.getReader(), Transaction.class);
		try {
			transaction=bankCrudService.depositAmount(transaction);
		} catch (BankException e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
