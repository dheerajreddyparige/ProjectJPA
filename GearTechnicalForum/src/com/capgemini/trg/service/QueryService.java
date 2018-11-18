package com.capgemini.trg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.trg.dao.IQueryDAO;
import com.capgemini.trg.exception.QueryException;
import com.capgemini.trg.model.Query;
@Service
@Transactional
public class QueryService implements IQueryService {
@Autowired 
private IQueryDAO dao;

	@Override
	public Query getQueryAnswers(Integer queryId) throws QueryException {
		// TODO Auto-generated method stub
		return dao.getQueryDetails(queryId);
	}

	@Override
	public Integer updateQueryDetails(Integer queryId,String solution,String option) throws QueryException {
		// TODO Auto-generated method stub
		return dao.updateQueryDetails(queryId,solution,option);
	}

}
