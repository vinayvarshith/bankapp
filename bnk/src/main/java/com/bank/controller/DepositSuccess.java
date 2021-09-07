package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DepositSuccess
 */
public class DepositSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String x=session.getAttribute("amountD").toString();
		int amount=(int)Double.parseDouble(x);
		RequestDispatcher rd=null;
		if(amount<=0) 
			
			{
			    rd=request.getRequestDispatcher("deposit.html");
			    rd.include(request, response);
			    out.print("<center><span style='color:red;'>invalid amount You entered</span></center>");
						}else {
				
				out.print("<center><h2> Transaction Id:"+session.getAttribute("transid")+"</h2></center>");
				
				out.print("<center><h2>Your Account Number is:"+session.getAttribute("accNo")+"</h2></center>");
				out.print("<center><h2> Your Customer ID:"+session.getAttribute("userid")+"</h2></center>");
				out.print("<center><h2>Your previous Balance is:"+session.getAttribute("opnbal")+"</h2></center>");
				out.print("<center><h2>AMOUNT DEPOSITED:"+session.getAttribute("amountD")+"</h2></center>");
				out.print("<center><h2>Your Updated Balance is:"+session.getAttribute("clsbal")+"</h2></center>");
				
				out.print("<p><a href='/bank1/mainMenu.html'>Click Here to go to MainMenu</a></p>");
			}
	}

	
}
