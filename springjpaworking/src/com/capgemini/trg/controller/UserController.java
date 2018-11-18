package com.capgemini.trg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.trg.entity.UserEntity;
import com.capgemini.trg.exception.UserException;
import com.capgemini.trg.model.User;
import com.capgemini.trg.service.IUserService;


import java.util.List;

@Controller
@RequestMapping(value="/userc")
public class UserController {
	@Autowired
	private IUserService userService;
	
@RequestMapping(value="/newuser",method=RequestMethod.GET)

	public ModelAndView showUserForm() {
		return new ModelAndView("add_user","user",new User());
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView processForm( @Valid @ModelAttribute("user") User user,
			BindingResult result){
		
		try {
			if(result.hasErrors()) {
				List<ObjectError> errorList=result.getAllErrors();
				System.out.println(errorList);
				return new ModelAndView("add_user","user",new User());
			}else {
				System.out.println(user.getUsername()+","+user.getBirthdate());
				//persist into database, call service class method
				com.capgemini.trg.entity.UserEntity userE=new com.capgemini.trg.entity.UserEntity();
				populateUserE(userE,user);
				Integer n=userService.addUserDetails(userE);
				if(n>0)
				{
				return new ModelAndView("status","status","User added to database");
				}
				else
				{
				return new ModelAndView("status","status","Unable to add user to database");	
				}
			}
		} catch (Exception e) {			
			return new ModelAndView("status","status",e.getMessage()); 
		}		
		
	}

	private void populateUserE(com.capgemini.trg.entity.UserEntity userE, User user) {
		
		userE.setUsername(user.getUsername());
		userE.setPassword(user.getPassword());
		userE.setEmailId(user.getEmailId());
		userE.setBirthdate(user.getBirthdate());
	}
	
	
	
	
	
	@RequestMapping(value="/allusers", method=RequestMethod.GET)
	public ModelAndView getAllCustomerDetails() {
		try {
			List<User> userList=userService.getAllUserDetails();
			if(userList.size()!=0) {				
				return new ModelAndView("all_users","userList",userList);
			}else {
				return new ModelAndView("status","status","No users in database");
			}
		}catch(UserException e) {
			e.printStackTrace();
			return new ModelAndView("status","status",e.getMessage());
		}
	}
	
	
	
	
	
	

	
	
}
