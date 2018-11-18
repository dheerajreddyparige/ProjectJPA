package com.capgemini.trg.model;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
private Integer userid;
@Size(min=3, max=45, message="Username must be between 3 and 45 characters")
private String username;
private String password;
@Pattern(regexp="[A-Za-z0-9]+@[A-Za-z0-9.-]+[.]+[A-Za-z]{2,4}",message="Invalid EmailId")
private String emailId;
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date birthdate;



public User() {

}

public User(Integer userid, String username, String password, String emailId,
		Date birthdate) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.emailId = emailId;
	this.birthdate = birthdate;
}


public Integer getUserid() {
	return userid;
}



public void setUserid(Integer userid) {
	this.userid = userid;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getEmailId() {
	return emailId;
}



public void setEmailId(String emailId) {
	this.emailId = emailId;
}



public Date getBirthdate() {
	return birthdate;
}



@Override
public String toString() {
	return "User [userid=" + userid + ", username=" + username + ", password="
			+ password + ", emailId=" + emailId + ", birthdate=" + birthdate
			+ "]";
}

public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}



}