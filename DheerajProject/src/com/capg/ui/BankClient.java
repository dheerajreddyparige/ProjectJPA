package com.capg.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capg.bean.Customer;
import com.capg.bean.Transaction;
import com.capg.exception.CustomerException;
import com.capg.service.BankServiceImp;

public class BankClient {

	public static void main(String[] args) throws CustomerException {
		BankServiceImp service = new BankServiceImp();
		while (true) {

			System.out.println("Select an option ");
			System.out.println("1.Create Account ");
			System.out.println("2.Show Balance ");
			System.out.println("3.Deposit ");
			System.out.println("4.Withdraw ");
			System.out.println("5.Fund Transfer");
			System.out.println("6.show customer details");

			System.out.println("7.Print Transactions ");

			Scanner sc = new Scanner(System.in);
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				Customer bean = new Customer();
				System.out.println("Enter ur Name");
				String name = sc.next();
				System.out.println("Enter customer address");
				String address = sc.next();
				System.out.println("Enter customer phone number");
				String phonenumber = sc.next();
				System.out.println("Enter email");
				String email = sc.next();
				System.out.println("Enter date of birth");
				String dateofbirth = sc.next();

				bean.getCustomerid();
				bean.getAccountnumber();
				bean.getPin();

				bean.setName(name);
				bean.setAddress(address);
				bean.getBalance();
				bean.setPhonenumber(phonenumber);
				bean.setEmail(email);
				bean.setDateofbirth(dateofbirth);
				boolean correct = service.validation(bean);
				if (correct) {
					try {
						service.CreateAccount(bean);
					} catch (CustomerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				break;
			case 2:
				Customer bean1 = new Customer();
				System.out.println("enter your customer id");
				int customerid = sc.nextInt();
				System.out.println("enter ur pin");
				int pin = sc.nextInt();
				boolean correct1= service.access(customerid, pin);
				if (correct1) {
				Customer disp = service.ShowBalance(customerid, pin);

				System.out.println("Balance in your account is:"
						+ disp.getBalance());}

				break;

			case 3:
				Customer bean2 = new Customer();
				System.out.println("enter your customer id");
				int customerid1 = sc.nextInt();
				System.out.println("enter ur pin");
				int pin1 = sc.nextInt();

				boolean correct2 = service.access(customerid1, pin1);
				if (correct2) {
					System.out.println("enter amount to deposit");
					int amount = sc.nextInt();

					Customer disp1 = service.Deposit(amount, customerid1);
					System.out.println("Amount Deposited:" + amount);

				}

				break;

			case 4:

				Customer bean3 = new Customer();
				System.out.println("enter your customer id");
				int customerid2 = sc.nextInt();
				System.out.println("enter ur pin");
				int pin2 = sc.nextInt();

				boolean correct3 = service.access(customerid2, pin2);
				if (correct3) {
					System.out.println("enter amount to withdraw");
					int withdraw = sc.nextInt();

					Customer disp2 = service.Withdraw(withdraw, customerid2);
					System.out.println("Amount withdrawn:" + withdraw);

					System.out.println("Current balance:" + disp2.getBalance());
				}
				break;
			case 5:
				Customer bean4 = new Customer();
				System.out.println("enter your customer id");
				int customerid3 = sc.nextInt();
				System.out.println("enter ur pin");
				int pin3 = sc.nextInt();

				boolean correct4 = service.access(customerid3, pin3);
				if (correct4) {
					System.out.println("Enter customerid to transfer");
					int transferid = sc.nextInt();
					System.out.println("Enter amount to transfer");
					int transferamount = sc.nextInt();
					if (service.FundTransfer(transferid, transferamount,
							customerid3)) {

						Customer disp3 = service.ShowBalance(customerid3, pin3);
						System.out.println("Money transfered to id:"
								+ transferid);
						System.out.println("Total Money Transfered is:"
								+ transferamount);
						System.out.println("Balance in ur account:"
								+ disp3.getBalance());
					}
				}
				break;

			case 6:
				System.out.println("enter your customer id");
				int cid = sc.nextInt();
				Customer details = service.displayCustomer(cid);
				System.out.println(details);
				break;

			case 7:
				Customer bean5 = new Customer();
				System.out.println("enter your customer id");
				int customerid4 = sc.nextInt();
				System.out.println("enter ur pin");
				int pin4 = sc.nextInt();

				boolean correct5 = service.access(customerid4, pin4);
				if (correct5) {  Customer c =service.displayCustomer(customerid4);
				List<Transaction> list=service.PrintTransactions(customerid4);
				if(list==null){
					System.out.println("Please enter Correct Account No. and Correct pin");
				}else{
					Transaction a=new Transaction();
					//a.getTransaction().substring(118);
				System.out.println("----------Date----------Deposit----------withdraw----------FundTransfer----------Balance");
				System.out.println("-----------------------------------------------------------------------------------------------");
				Iterator<Transaction> it = list.iterator();
				//System.out.println("                                                            Opening Balance     ");
				System.out.println(it.next());
				while(it.hasNext()){
				System.out.println(it.next());
				}
				//System.out.println("                                                            Current Balance      "+c.getBalance());
				}
			

				}

				break;

			}
		}
	}
}
