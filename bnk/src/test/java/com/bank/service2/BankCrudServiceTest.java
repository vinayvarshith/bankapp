package com.bank.service2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bank.exception.BankException;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.service.BankCrudService;
import com.bank.serviceimpl.BankCrudServiceImpl;

class BankCrudServiceTest {
private static BankCrudService service;
	
	@BeforeAll
	public static void setUp() {
		service=new BankCrudServiceImpl();
	}
	@Test
	void testRegisterAccount() {
		Customer customer=new Customer("shekar", "shekar@gmail.com", "9441477537", "112", "shek");
		try {
			assertEquals(customer,service.registerAccount(customer));
		}catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testCreateAccount() {
		Account account=new Account("106", "vamsi", "112323349887", 12000);
		try {
			assertEquals(account,service.createAccount(account));
		}catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
