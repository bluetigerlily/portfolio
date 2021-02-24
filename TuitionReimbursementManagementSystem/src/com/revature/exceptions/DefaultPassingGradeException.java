package com.revature.exceptions;

@SuppressWarnings("serial")
public class DefaultPassingGradeException extends Exception{

	public DefaultPassingGradeException () 
	{
		super("Since no passing grade was submitted on time you have selected the default as a passing grade have a wonderful day!");
	}
	
}
