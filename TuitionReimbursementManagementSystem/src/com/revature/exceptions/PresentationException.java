package com.revature.exceptions;

@SuppressWarnings("serial")
public class PresentationException extends Exception{

	
	public PresentationException () 
	{
		super("You are doing a presentation instead of a final letter grade please speak with the supervisor overseeing your presentation for your "
				+ "performance review");
	}
	
}
