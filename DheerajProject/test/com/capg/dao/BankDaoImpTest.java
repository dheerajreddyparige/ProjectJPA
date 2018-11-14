package com.capg.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.capg.bean.Customer;
import com.capg.bean.Transaction;
import com.capg.exception.CustomerException;

public class BankDaoImpTest {
	
	BankDaoImp dao = new BankDaoImp();
	
	@Test
	public void testCreateAccount() {
		
		try {Customer customer=new Customer();
			customer.setAccountnumber(12345);
			customer.setAddress("1,KannanStreet,Chennai-600028");
			customer.setBalance(500);
			customer.setCustomerid(1001);
			customer.setDateofbirth("27/08/1996");
			customer.setEmail("s@gmail.com");
			customer.setPhonenumber("8121621627");
			customer.setName("Kishore");
			customer.setPin(25);
			boolean test=dao.CreateAccount(customer);
			assertTrue("true",test);
		} catch (CustomerException e) {
			System.out.println("its not working");
		}
	}

	@Test
	public void testWithdraw() throws CustomerException {
		Customer customer=new Customer();
		customer.setAccountnumber(12345);
		customer.setAddress("1,KannanStreet,Chennai-600028");
		customer.setBalance(500);
		customer.setCustomerid(1002);
		customer.setDateofbirth("27/08/1996");
		customer.setEmail("s@gmail.com");
		customer.setPhonenumber("8121621627");
		customer.setName("Kishore");
		customer.setPin(25);
		
		Customer test=dao.Withdraw(customer);
		assertNotNull(test);
	}

	@Test
	public void testFundTransfer() throws CustomerException {
		Customer customer=new Customer();
		customer.setAccountnumber(12345);
		customer.setAddress("1,KannanStreet,Chennai-600028");
		customer.setBalance(500);
		customer.setCustomerid(1003);
		customer.setDateofbirth("27/08/1996");
		customer.setEmail("s@gmail.com");
		customer.setPhonenumber("8121621627");
		customer.setName("Kishore");
		customer.setPin(25);
		
		Customer test=dao.FundTransfer(customer, customer);
		assertNotNull(test);
	}

	@Test
	public void testPrintTransactions() throws CustomerException {
		Customer customer=new Customer();
		customer.setCustomerid(1004);
		List<Transaction>  list=dao.PrintTransactions(customer.getCustomerid());
		assertNotNull(list);
	}

	@Test
	public void testDeposit() throws CustomerException {
		Customer customer=new Customer();
		customer.setAccountnumber(123456);
		customer.setAddress("1,KannanStreet,Chennai-600028");
		customer.setBalance(500);
		customer.setCustomerid(1005);
		customer.setDateofbirth("27/08/1996");
		customer.setEmail("s@gmail.com");
		customer.setPhonenumber("8121621627");
		customer.setName("Kishore");
		customer.setPin(25);
		
		Customer test=dao.Deposit(customer);
		assertNotNull(test);
	}

	@Test
	public void testShowBalance() {
		try {Customer customer=new Customer();
		customer.setAccountnumber(1005);
		customer.setAddress("1,KannanStreet,Chennai-600028");
		customer.setBalance(500);
		customer.setCustomerid(1234);
		customer.setDateofbirth("27/08/1996");
		customer.setEmail("s@gmail.com");
		customer.setPhonenumber("8121621627");
		customer.setName("Kishore");
		customer.setPin(25);
		boolean test=dao.ShowBalance(customer.getCustomerid(),customer.getPin());
		assertTrue("true",test);
	} catch (CustomerException e) {
		System.out.println("its not working");
	}
	}

}
