package com.banking.fellswargo.model;

public class Response {
	
	private String message;
	
	public Response() {
		
	}
	
	public Response(String mesage) {
		this.message  = mesage;
	}
	
	public String  getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
