package com.revature.exceptions;

@SuppressWarnings("serial")
public class FormNotCompleteException extends Exception {

	public FormNotCompleteException() {
		super("I'm sorry your form was not completed and therefore not submitted for approval please complete the form so it can be submitted for approval!");
	}
}
