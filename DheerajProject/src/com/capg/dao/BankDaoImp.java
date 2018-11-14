package com.capg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.capg.bean.Customer;
import com.capg.bean.Transaction;
import com.capg.exception.CustomerException;
import com.capg.utility.JPAUtil;

public class BankDaoImp implements IBankDao {
	Transaction transaction=new Transaction();
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("DheerajProject");

	@Override
	public boolean CreateAccount(Customer c) throws CustomerException {
		EntityManager em1 = factory.createEntityManager();

		try {

			em1.getTransaction().begin();

			System.out.println(c);
			em1.persist(c);

			em1.getTransaction().commit();
			return true;

		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new CustomerException(e.getMessage());
		} finally {
			em1.close();

		}

	}

	@Override
	public Customer Withdraw(Customer disp) throws CustomerException {
		EntityManager em1 = factory.createEntityManager();

		try {

			em1.getTransaction().begin();
			em1.merge(disp);

			em1.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new CustomerException(e.getMessage());
		} finally {
			em1.close();
		}
		return disp;
	}

	@Override
	public Customer FundTransfer(Customer bal, Customer bal1)
			throws CustomerException {
		EntityManager em1 = factory.createEntityManager();
		try {

			em1.getTransaction().begin();

			em1.merge(bal);
			em1.merge(bal1);

			em1.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new CustomerException(e.getMessage());
		} finally {
			em1.close();
		}
		return bal;
	}

	@Override
	public List<com.capg.bean.Transaction> PrintTransactions(int customerid) throws CustomerException {
		EntityManager em=factory.createEntityManager();
		try{
			Customer c=em.find(Customer.class, customerid);
			List<Transaction> passbookList=c.getTransactions();
			 return passbookList;
		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new CustomerException(e.getMessage());
		}finally {
			em.close();
		}
	}

	@Override
	public Customer displayCustomer(int cid) throws CustomerException {
		EntityManager em1 = factory.createEntityManager();
		Customer customer = null;
		try {
			em1.getTransaction().begin();

			customer = em1.find(Customer.class, cid);
			em1.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new CustomerException(e.getMessage());
		} finally {
			em1.close();
		}

		return customer;

	}

	@Override
	public Customer Deposit(Customer disp) throws CustomerException {
		EntityManager em1 = factory.createEntityManager();
		try {

			em1.getTransaction().begin();
			em1.merge(disp);

			em1.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new CustomerException(e.getMessage());
		} finally {
			em1.close();
		}
		return disp;
	}

	@Override
	public boolean ShowBalance(int customerid, int pin)
			throws CustomerException {
		// TODO Auto-generated method stub
		return true;
	}

}
