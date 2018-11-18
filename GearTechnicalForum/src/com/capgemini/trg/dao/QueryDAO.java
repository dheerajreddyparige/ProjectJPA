package com.capgemini.trg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;



import com.capgemini.trg.exception.QueryException;
import com.capgemini.trg.model.Query;

@Repository
public class QueryDAO implements IQueryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Query getQueryDetails(Integer queryId) throws QueryException {
		try{
			Query query=entityManager.find(Query.class, queryId);
			System.out.println(query);
			return query;														
		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new QueryException(e.getMessage());
		}finally {
			entityManager.close();
		}
	}

	@Override
	public Integer updateQueryDetails(Integer queryId,String solution,String solutionBy) throws QueryException {
		//String sql="Update query_master q set solution=:solution,solutionBy=:solutionBy where queryId=:queryId";
		try{
			int query = entityManager.createQuery("updateQuery",Query.class).setParameter(3, queryId).setParameter(1, solution).setParameter(2, solutionBy).executeUpdate();
			return query;
		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new QueryException(e.getMessage());
		}finally {
			entityManager.close();
		}
		
	}

}
