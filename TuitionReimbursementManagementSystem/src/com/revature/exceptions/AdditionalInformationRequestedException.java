package com.revature.exceptions;

@SuppressWarnings("serial")
public class AdditionalInformationRequestedException extends Exception{
	
	
	public AdditionalInformationRequestedException () 
	{
		super("More information has been requested please check your email for further details");
	}

}
