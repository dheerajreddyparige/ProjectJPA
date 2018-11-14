package com.capg.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.capg.bean.Customer;
import com.capg.bean.Transaction;
import com.capg.dao.BankDaoImp;
import com.capg.exception.CustomerException;
import com.capg.exception.InvalidInputException;

public class BankServiceImp implements IBankService {
	BankDaoImp dao = new BankDaoImp();
	Transaction trans = new Transaction();

	@Override
	public void CreateAccount(Customer c) throws CustomerException {

		dao.CreateAccount(c);
	}

	public boolean validation(Customer bean) {
		boolean flag = false;
		if (isValidName(bean.getName()) && isValidaddress(bean.getAddress())
				&& isValidemail(bean.getEmail())
				&& isValidphonenumber(bean.getPhonenumber())
				&& isValiddob(bean.getDateofbirth())
				&& isValidcustomerid(bean.getCustomerid())) {
			flag = true;
		}
		return flag;
	}

	public boolean isValidName(String name) {
		if (((name != null) && name.matches("[A-Z][a-z]+"))) {
			return true;
		} else {
			throw new InvalidInputException(
					" : Name cannot be NULL (or) INVALID Name.");
		}
	}

	public boolean isValidaddress(String address) {
		if (((address != null) && address.matches("[A-Z][a-z]+"))) {
			return true;
		} else {
			throw new InvalidInputException(
					" : address cannot be NULL (or) INVALID address.");
		}
	}

	public boolean isValidemail(String email) {
		if (((email != null) && email
				.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
			return true;
		} else {
			throw new InvalidInputException(
					" : email cannot be NULL (or) INVALID email.");
		}
	}

	public boolean isValidphonenumber(String phonenumber) {
		if (((phonenumber != null) && phonenumber.matches("[4-9][0-9]{9}"))) {
			return true;
		} else {
			throw new InvalidInputException(
					" : Name cannot be NULL (or) INVALID Name.");
		}
	}

	public boolean isValiddob(String dob) {
		if (((dob != null) && dob
				.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"))) {
			return true;
		} else {
			throw new InvalidInputException(
					" : dob cannot be NULL (or) INVALID dob.");
		}
	}

	public boolean isValidcustomerid(int customerid) {
		if (customerid >= 100) {
			return true;
		} else {
			throw new InvalidInputException(
					" : customerid cannot be Null (or) INVALID Customer.");
		}
	}

	public boolean validAmount(int amount) {
		if (amount > 0) {
			return true;
		} else {
			throw new InvalidInputException(
					" : Invalid Amount. Please enter a POSITIVE amount. Thanks. :) \n");
		}
	}

	@Override
	public Customer ShowBalance(int customerid, int pin)
			throws CustomerException {

		Customer disp = displayCustomer(customerid);
		System.out.println(disp);
		int bal1 = 0;
		if (disp.getCustomerid() == customerid && disp.getPin() == pin) {
			bal1 = disp.getBalance();
		}
		return disp;
		// TODO Auto-generated method stub
	}

	@Override
	public Customer Deposit(int amount, int customerid1)
			throws CustomerException {
		Customer disp = displayCustomer(customerid1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		int currbal = disp.getBalance() + amount;

		disp.setBalance(currbal);
		int s1 = trans.getTransactionid();
		trans.setTransactionid(s1);
		trans.setTransaction("TransactionId:"+s1+     "Date of Transaction" + dateFormat.format(date)  +     "Amount Deposited" + amount+     "Ur current Balance"+ currbal);

		disp.addTransaction(trans);

		return dao.Deposit(disp);

	}

	@Override
	public Customer Withdraw(int withdraw, int customerid2)
			throws CustomerException {
		Customer disp = displayCustomer(customerid2);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		int newwithdraw = disp.getBalance() - withdraw;

		disp.setBalance(newwithdraw);
		int s1 = trans.getTransactionid();
		trans.setTransactionid(s1);
		trans.setTransaction("TransactionId:"+s1+       "Date of Transaction" + dateFormat.format(date)+       "Amount Withdrawn" + withdraw+     "Ur current Balance"+ newwithdraw);
		// em.merge(transaction);

		disp.addTransaction(trans);
		return dao.Withdraw(disp);

	}

	@Override
	public boolean FundTransfer(int transferid, int transferamount,
			int customerid3) throws CustomerException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Customer bal = Deposit(transferamount, transferid);

		int s1 = trans.getTransactionid();

		// em.merge(transaction);
		trans.setTransactionid(s1);

		bal.addTransaction(trans);
		trans.setTransaction("TransactionId:"+s1+      "Date of Transaction" + dateFormat.format(date)+     "Amount Transfered" + transferamount+  "to the customerid"+transferid+       "Ur current Balance"   + bal.getBalance());
		Customer bal1 = Withdraw(transferamount, customerid3);

		// em.merge(transaction);
		trans.setTransactionid(s1);
		bal1.addTransaction(trans);
		trans.setTransaction("TransactionId:"+s1+       "Date of Transaction" + dateFormat.format(date)		+          "Amount Transfered to ur account" + transferamount+                "from id"+customerid3	+         "Ur current Balance"+ bal1.getBalance());

		dao.FundTransfer(bal, bal1);

		return true;

	}

	@Override
	public List<Transaction> PrintTransactions(int customerid)
			throws CustomerException {

		return dao.PrintTransactions(customerid);
	}

	@Override
	public Customer displayCustomer(int cid) throws CustomerException {
		// TODO Auto-generated method stub
		return dao.displayCustomer(cid);
	}

	public boolean access(int customerid1, int pin1) throws CustomerException {
		Customer disp = displayCustomer(customerid1);
		System.out.println(disp.getPin());
		boolean flag = false;
		if (disp.getCustomerid() == customerid1 && disp.getPin() == pin1) {
			{
				flag = true;
			}
		}
		return flag;
	}

}
