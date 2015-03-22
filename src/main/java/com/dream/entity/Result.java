package com.dream.entity;

public class Result {
	private boolean successful=true;
	private String message;
	
	
	public Result(String message) {
		super();
		this.message = message;
	}
	public Result(boolean successful, String message) {
		super();
		this.successful = successful;
		this.message = message;
	}
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
