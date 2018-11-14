package com.capg.dao;

import java.util.List;

import com.capg.bean.Customer;
import com.capg.bean.Transaction;
import com.capg.exception.CustomerException;

public interface IBankDao {

	abstract public boolean CreateAccount(Customer c) throws CustomerException;

	public List<Transaction> PrintTransactions(int customerid) throws CustomerException;

	public boolean ShowBalance(int customerid, int pin)
			throws CustomerException;

	public Customer displayCustomer(int cid) throws CustomerException;

	Customer Withdraw(Customer disp) throws CustomerException;

	Customer Deposit(Customer disp) throws CustomerException;

	Customer FundTransfer(Customer bal, Customer bal1) throws CustomerException;

}
