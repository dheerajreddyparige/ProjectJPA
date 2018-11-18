package com.cap.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.jpa.dao.ITestdao;
import com.cap.jpa.model.TestBean;

@Service
public class TestImpl implements ITestService {
	@Autowired
	ITestdao dao;

	@Override
	public TestBean findqueryID(Integer queryID) {
		return dao.findqueryID(queryID);
	}

}
