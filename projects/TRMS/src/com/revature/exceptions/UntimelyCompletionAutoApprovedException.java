package com.revature.exceptions;

@SuppressWarnings("serial")
public class UntimelyCompletionAutoApprovedException extends Exception {

	public UntimelyCompletionAutoApprovedException() {
		super("I'm sorry it seems one of our managerial associates did not get to your reimbursement request in a timely manner"
				+ "therefore it has been autoapproved ot the next level! Have a wonderful day!");
	}

}
