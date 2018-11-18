package com.capgemini.trg.exception;

public class QueryException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public QueryException() {
		
	}
	
	public QueryException(String message) {
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
