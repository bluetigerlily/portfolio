package com.revature.exceptions;

@SuppressWarnings("serial")
public class CourseMaterialsNotCoveredException extends Exception{

	public CourseMaterialsNotCoveredException () 
	{
		super("I'm sorry course materials are not covered at this time have a wonderful day!");
	}
	
}
