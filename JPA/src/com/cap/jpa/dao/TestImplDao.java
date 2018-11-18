package com.cap.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jpa.model.TestBean;

@Repository
@Transactional
@PersistenceContext
public class TestImplDao implements ITestdao{
	
	EntityManager em;

	@Override
	public TestBean findqueryID(Integer queryID) {
		return em.find(TestBean.class, queryID);
	}

}
