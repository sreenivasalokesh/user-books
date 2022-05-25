package com.example.demo.exceptiom;

public class CustomErrorObject {
	public String type;
	public String message;
	public String details;
	
	
	public CustomErrorObject(String type, String message, String details) {
		super();
		this.type = type;
		this.message = message;
		this.details = details;
	}
	
	

	public String getType() {
		return type;
	}
	public String getMessage() {
		return message;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setMessage(String message) {
		this.message = message;
	}



	public String getDetails() {
		return details;
	}



	public void setDetails(String details) {
		this.details = details;
	}

	
	

}
