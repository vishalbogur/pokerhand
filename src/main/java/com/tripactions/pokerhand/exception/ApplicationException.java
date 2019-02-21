package com.tripactions.pokerhand.exception;

/**
 * Handles all the exceptions in the application.
 * 
 * @author vishalbogur
 *
 */
public class ApplicationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ApplicationException(String message) {
		super(message);
	}

}
