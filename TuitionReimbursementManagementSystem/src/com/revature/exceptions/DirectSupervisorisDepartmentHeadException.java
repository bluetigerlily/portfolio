package com.revature.exceptions;

@SuppressWarnings("serial")
public class DirectSupervisorisDepartmentHeadException extends Exception{

	
	public DirectSupervisorisDepartmentHeadException () 
	{
		super("Your direct supervisor is also your departmenthead so you can get approval from both at the same time! Congratulations!");
	}
}
