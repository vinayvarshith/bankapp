package com.bank.serviceimpl;

import com.bank.dao.BankDAO;

import com.bank.daoimpl.BankDAOImpl;
import com.bank.exception.BankException;
import com.bank.model.Customer;
import com.bank.model.Employee;
import com.bank.service.LoginService;
public class LoginServiceImpl implements LoginService {

	private BankDAO bankDAO=new BankDAOImpl();
	@Override
	public boolean isValidLoginCustomer(String cust_id, String cust_pwd) throws BankException {
		
		return bankDAO.isValidLoginCustomer(cust_id, cust_pwd);
	}

	@Override
	public boolean isValidLoginEmployee(String emp_id, String emp_pwd) throws BankException {
		
		return bankDAO.isValidLoginEmployee(emp_id, emp_pwd);
	}

	

	

}
