package com.revature.bicycleshop.exceptions;

@SuppressWarnings("serial")
public class NoDataInTableException extends Exception{
 public NoDataInTableException() {
	 super("There is no data in the sql table");
 }
}
//used for testing