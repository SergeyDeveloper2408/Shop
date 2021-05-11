package com.example.shop.error.errors;

public class CreateOrderException extends RuntimeException {

	public CreateOrderException() {
		super();
	}

	public CreateOrderException(String message) {
		super(message);
	}

	public CreateOrderException(String message, Throwable cause) {
		super(message, cause);
	}
}
