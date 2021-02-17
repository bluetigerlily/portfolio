package com.revature.bicycleshop.methods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.exceptions.NoDataInTableException;
import com.revature.bicycleshop.merchandise.Bicycles;


class CustomerMethodsTest {

	@Test
	void  MakeOfferTest() throws Exception {
		boolean isGood = false;
		Customer customer = new Customer(4, "haley", "4271", 11, false, 4, 2, 1, 2021-02-17);
		Bicycles bicycles = new Bicycles(true, 456, "lovebike");
		CustomerMethods cm = new CustomerMethods();
		try { 
			if(cm.MakeOffer(customer, bicycles).equals((customer))){
				assertTrue(isGood);
			}
		} catch (NoDataInTableException e) {
			e.printStackTrace();
		}
	}
	@Test
 void ViewOwnedTest() throws Exception {
	 boolean isGood = false;
	 Customer customer = new Customer(4, "haley", "4271", 11, false, 4, 2, 1, 2021-02-17);
	CustomerMethods cm = new CustomerMethods();
	if(cm.ViewOwned(customer).equals((customer))){
		assertTrue(isGood);
	}
 }
 @Test
  void ViewPaymentsRemainingTest() throws Exception {
	  boolean isGood = false;
		 Customer customer = new Customer(4, "haley", "4271", 11, false, 4, 2, 1, 2021-02-17);
		CustomerMethods cm = new CustomerMethods();
		if (cm.ViewPaymentsRemaining(customer) == 1) { 
			assertTrue(isGood);
		}
  }
  @Test
  void CreateCustomerTest() throws Exception {
	  boolean isGood = false;
		 Customer customer = new Customer(1,"joey", "45893");
		CustomerMethods cm = new CustomerMethods();
		if (cm.CreateCustomer(customer) != customer) {
			assertTrue(isGood);
		}
  }
  @Test
  void CusLoginTest() throws Exception {
	  boolean isGood = false;
		 CustomerMethods cm = new CustomerMethods();
		if (cm.CusLogin() == null) {
			assertTrue(isGood);
		}

  }
 
  @Test @SuppressWarnings("unlikely-arg-type")
void getAvailableTest() throws Exception {
	  boolean isGood = false;
		 CustomerMethods cm = new CustomerMethods();
		 Bicycles bicycles = new Bicycles(true, 456, "lovebike");
			if(cm.getAvailable(bicycles).equals(true)) {
				assertTrue(isGood);
			}
  }
 
  
  
 
 
 
 
 
}
