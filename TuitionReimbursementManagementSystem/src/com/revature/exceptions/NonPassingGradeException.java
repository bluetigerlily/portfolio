package com.revature.exceptions;

@SuppressWarnings("serial")
public class NonPassingGradeException extends Exception{

	public NonPassingGradeException () 
	{
		super("You did not get a passing grade in your event I am so sorry but you do not qualify for reimbursement at this time have a wonderful day!");
	}
	
}
