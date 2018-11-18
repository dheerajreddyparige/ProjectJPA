package com.cg.sessionmanagement.exception;

public class TrainingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public String msg;
	public TrainingException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
