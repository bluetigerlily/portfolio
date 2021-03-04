package com.revature.exceptions;

@SuppressWarnings("serial")
public class AvailableAmountException extends Exception {

	public AvailableAmountException() {
		super("You have exceeded your available amount of reimbursement for the annual working year if you would like to request"
				+ "approval for more please contact your Benefits Coordinator for further details, have a wonderful day!");
	}
}
