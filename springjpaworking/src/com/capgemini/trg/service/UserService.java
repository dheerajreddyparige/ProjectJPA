package com.capgemini.trg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.trg.dao.IUserDAO;
import com.capgemini.trg.dao.UserDao;
import com.capgemini.trg.entity.UserEntity;
import com.capgemini.trg.exception.UserException;
import com.capgemini.trg.model.User;



@Service
@Transactional
public class UserService implements IUserService{
// tight coupling	
//	private IUserDAO userDAO=new UserDao();
// loose coupling through DI
	@Autowired
	private IUserDAO userDAO;
	@Override
	public UserEntity getUserDetails(Integer userid) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isValidUser(String username, String password) throws UserException {
			return userDAO.isValidUser(username, password);
	}

	@Override
	public Integer addUserDetails(UserEntity user) throws UserException {
		// TODO Auto-generated method stub
		return userDAO.addUserDetails(user);
	}
	
	
	@Override
	public List<User> getAllUserDetails() throws UserException {
		try {
			List<UserEntity> userEntityList=userDAO.getAlluserDetails();
			//System.out.println(customerEntityList.size());
			
			if(userEntityList !=null) {
				List<User> userList=new ArrayList<>();				
				populateCustomerList(userList,userEntityList);
				return userList;
			}
			throw new UserException("Customer List is empty");
		}catch(Exception e) {
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}
		
	}


	private void populateCustomerList(List<User> userList,List<UserEntity> userEntityList) {
		Iterator<UserEntity> iterator= userEntityList.iterator();		
		while(iterator.hasNext()) {
			User user=new User();
			populateUser(user,iterator.next());
			userList.add(user);		
		}
		
	}
	
	
	private void populateUser(User user, UserEntity next) {
		user.setUserid(next.getUserid());
		user.setUsername(next.getUsername());
		user.setPassword(next.getPassword());
		user.setBirthdate(next.getBirthdate());
		user.setEmailId(next.getEmailId());		
	}

}
