package com.capgemini.trg.dao;

import com.capgemini.trg.exception.QueryException;
import com.capgemini.trg.model.Query;

public interface IQueryDAO {

	public Query getQueryDetails(Integer queryId) throws QueryException;
	public Integer updateQueryDetails(Integer queryId,String solution,String option) throws QueryException;
}
