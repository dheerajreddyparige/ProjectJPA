package com.capgemini.trg.dao;

import java.util.List;

import com.capgemini.trg.entity.UserEntity;
import com.capgemini.trg.exception.UserException;

public interface IUserDAO {
	public abstract UserEntity getUserDetails(Integer userid) 
			throws UserException;
	public abstract Boolean isValidUser(String username,String password) 
			throws UserException;
	public abstract Integer addUserDetails(UserEntity user) 
			throws UserException;
	public abstract List<UserEntity> getAlluserDetails() throws UserException;

	
}
