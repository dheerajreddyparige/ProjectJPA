package com.capg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bank_Project")

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	int customerid = (int) ((Math.random() * 100) + 1000);
	String name;
	String address;
	String phonenumber;
	String email;
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	String dateofbirth;
	int balance = 0;
	int pin = (int) ((Math.random() * 100));
	int accountnumber = (int) ((Math.random() * 40000) + 1000);
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Transaction> transactions = new ArrayList<Transaction>();
	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Customer(){}
	public Customer(int customerid, String name, String address,
			String phonenumber, String email, String dateofbirth, int balance,
			int pin, int accountnumber, List<Transaction> transactions) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.balance = balance;
		this.pin = pin;
		this.accountnumber = accountnumber;
		this.transactions = transactions;
	}

	public void addTransaction(Transaction transaction) {
		transaction.setCustomer(this);			//this will avoid nested cascade
		this.getTransactions().add(transaction);
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accountnumber="
				+ accountnumber + ", address=" + address + ",balance="
				+ balance + ", dateofbirth=" + dateofbirth + ", email=" + email
				+ ", name=" + name + ", phonenumber=" + phonenumber + ",pin="
				+ pin + "]";
	}
}
