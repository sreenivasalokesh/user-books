package com.example.demo.exceptiom;

public class BookNotFoundException extends BaseException{

	private static final long serialVersionUID = 2101770462152191770L;
	
	String type = "BOOK_NOT_FOUND";
	CustomErrorObject error;
	
	
	public BookNotFoundException(Throwable e) {
		error = new CustomErrorObject(type, e.getMessage(), e.getStackTrace().toString());
	}

	

	@Override
	public CustomErrorObject getErrorObject() {
		return error;
	}
	
	
	
	

}
