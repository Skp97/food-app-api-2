package com.ty.foodappapi.exceptions;

public class IdNotFoundException extends RuntimeException {
	private String message;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	public IdNotFoundException(String message) {
		this.message=message;
	}
	public IdNotFoundException() {
	}
}
