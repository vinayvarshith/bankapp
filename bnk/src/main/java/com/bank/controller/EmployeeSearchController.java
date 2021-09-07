package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BankException;
import com.bank.service.BankCrudService;
import com.bank.serviceimpl.BankCrudServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeeSearchController
 */
public class EmployeeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BankCrudService bnk=new BankCrudServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
			try {
				out.print(gson.toJson(bnk.getAllAccounts()));
			} catch (BankException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
