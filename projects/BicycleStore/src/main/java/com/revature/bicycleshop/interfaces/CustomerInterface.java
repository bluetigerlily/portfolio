package com.revature.bicycleshop.interfaces;

import java.sql.SQLException;
import java.util.*;

import com.revature.bicycleshop.merchandise.Bicycles;
import com.revature.bicycleshop.users.*;


public interface CustomerInterface {

	
		
		public Customer MakeOffer(Customer customer, Bicycles bicycles) throws Exception;
		List<Customer> ViewOwned(Customer customer) throws SQLException;
		int ViewPaymentsRemaining(Customer customer) throws Exception;
		Customer CreateCustomer(Customer customer) throws Exception;
		Customer CusLogin() throws Exception;
		Set<Bicycles> getAvailable(Bicycles bicycles) throws Exception;
		Customer MakeaPayment(Customer customer) throws Exception;
}

