package com.stockmarket.company.exception;

public class CompanyException extends RuntimeException{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2663266195748294072L;
	
	public String errorMessage;
	public CompanyException(String message) {
		super(message);
		this.errorMessage=message;
	}
	public CompanyException() {
	
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
