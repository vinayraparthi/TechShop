package com.techshop.TechShop.exception;
;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerNotFoundException(String message) {
        super(message);
    }
}

