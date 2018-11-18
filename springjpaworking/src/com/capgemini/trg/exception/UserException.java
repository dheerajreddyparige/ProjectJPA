package com.capgemini.trg.exception;

public class UserException extends Exception{
	private String message;
	
	public UserException() {
		
	}
	
	public UserException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "UserException [message=" + message + "]";
	}
	
	
}
