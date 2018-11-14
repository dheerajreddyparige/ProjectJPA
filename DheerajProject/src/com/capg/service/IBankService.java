package com.capg.service;

import java.util.List;

import com.capg.bean.Customer;
import com.capg.bean.Transaction;
import com.capg.exception.CustomerException;

public interface IBankService {
	
	public void CreateAccount(Customer c) throws CustomerException;
	public Customer ShowBalance(int customerid,int pin) throws CustomerException;
	public Customer Deposit(int amount,int customerid1) throws CustomerException;
	
	public Customer displayCustomer(int cid) throws CustomerException;
	Customer Withdraw(int withdraw, int customerid2) throws CustomerException;
	
	boolean FundTransfer(int transferid, int transferamount, int customerid3) throws CustomerException;
	
	public List<Transaction> PrintTransactions(int customerid) throws CustomerException;
	
	

	
	
	
	
	
}
