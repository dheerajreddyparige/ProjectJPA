package com.capgemini.trg.service;

import com.capgemini.trg.exception.QueryException;
import com.capgemini.trg.model.Query;

public interface IQueryService {

	public Query getQueryAnswers(Integer queryId) throws QueryException;
	public Integer updateQueryDetails(Integer queryId,String solution,String option) throws QueryException;

}
