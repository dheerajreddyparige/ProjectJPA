package com.capgemini.trg.service;

import java.util.List;

import com.capgemini.trg.entity.UserEntity;
import com.capgemini.trg.exception.UserException;
import com.capgemini.trg.model.User;

public interface IUserService {
	public abstract UserEntity getUserDetails(Integer userid) 
			throws UserException;
	public abstract Boolean isValidUser(String username,String password) 
			throws UserException;
	public abstract Integer addUserDetails(UserEntity user) 
			throws UserException;
	public abstract List<User> getAllUserDetails() throws UserException;

}
