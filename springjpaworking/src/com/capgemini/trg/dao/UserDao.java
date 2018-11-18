package com.capgemini.trg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.trg.entity.UserEntity;
import com.capgemini.trg.exception.UserException;



@Repository
public class UserDao implements IUserDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserEntity getUserDetails(Integer userid) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isValidUser(String username, String password) throws UserException {
		String jql="select u from User u where u.username=:pname"
				+ " and u.password=:pwd";
		try{
			//entityManager=JPAUtil.getEntityManager();
			Query query= entityManager.createQuery(jql);
			query.setParameter("pname", username);
			query.setParameter("pwd", password);
			List<UserEntity> userList=query.getResultList();
			if(userList.size()==0) {
				return false;
			}else {
				return true;
			}											
		}catch(PersistenceException e) {
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}finally {
			//entityManager.close();
		}
	}

	@Override
	public Integer addUserDetails(UserEntity user) throws UserException {
		// TODO Auto-generated method stub
		try
		{
		//entityManager=JPAUtil.getEntityManager();
	//	entityManager.getTransaction().begin();
		user.setUserid(null);
		entityManager.persist(user);
	//	entityManager.getTransaction().commit();
		return 1;
		}
		catch(PersistenceException e){
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}
		finally{
			//entityManager.close();
		}
		
		
		
	}

	@Override
	public List<UserEntity> getAlluserDetails() throws UserException {
		String sql="From UserEntity";
		try {
			//transaction.begin();
			Query query=entityManager.createQuery(sql);
			List<UserEntity> userEntityList=query.getResultList();			
			//transaction.commit();
			return userEntityList;
		}catch(PersistenceException e) {			
			throw new UserException(e.getMessage());
		}catch(Exception e) {	
			throw new UserException(e.getMessage());
		}

	}


}
